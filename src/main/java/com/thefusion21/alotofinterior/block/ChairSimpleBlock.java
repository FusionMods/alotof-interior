package com.thefusion21.alotofinterior.block;

import com.mojang.serialization.MapCodec;
import com.thefusion21.alotofinterior.entity.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
//? if < 1.20.5 {
/*
import net.minecraft.world.InteractionHand;
*/
//?}
//? if >= 1.21.6 {
/*
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
*/
//?}

/**
 * Every "chair style" (solid-backrest, ladder-back, no-backrest - more to come) in one
 * concrete block, distinguished at runtime by {@link #STYLE} instead of one Java class per
 * style: a style is purely a cosmetic/collision variant of the same leg/seat wood combo, never
 * something a player picks an item for (see {@link #getDrops} - only {@link #STYLE_SIMPLE} is
 * ever obtainable), so it belongs in the blockstate, not the registry. Shift-right-clicking
 * (see {@link #useWithoutItem}) cycles {@link #STYLE} on the same block instead of swapping to
 * a different registered block; a plain right-click sits as usual.
 *
 * Otherwise unchanged from the previous per-style-subclass design: a
 * {@link HorizontalDirectionalBlock#FACING} property, and rotation-limited sitting (see
 * {@link #getMaxYawDeviation}) so the player's view can't clip through the backrest. Only the
 * backrest itself ({@link #backrestShapeFacingNorth}) differs between styles - seat and legs
 * are identical - so {@link #getShape} derives the other 3 facings from that one shape via
 * {@link #rotateY90} rather than needing 4 hand-authored boxes per style.
 *
 * Every backed style's backrest overflows a full unit above the block (y goes up to 19, not
 * 16), so - regardless of {@link #STYLE}, since every style shares the same footprint - this
 * follows the same two-position pattern vanilla uses for doors/tall flowers: a {@link #HALF}
 * property, with the actual model only ever drawn by the {@code LOWER} half (it already
 * overflows into the block above's render space) while the {@code UPPER} half is a real,
 * otherwise-invisible blockstate occupying that space - {@link #getStateForPlacement} refuses
 * to place unless that space is free, {@link #setPlacedBy} claims it, and {@link #updateShape}
 * removes either half if its pair disappears, exactly like {@code DoublePlantBlock}. (A future
 * style that doesn't fit this 2-block-tall/leg-seat-backrest shape would need a separate class
 * instead of another {@link #STYLE} value.)
 */
public class ChairSimpleBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, Seat {
    // Must reuse vanilla's own instance, not a new BooleanProperty.create("waterlogged") -
    // SimpleWaterloggedBlock's default placeLiquid()/getFluidState() hard-code a reference
    // to BlockStateProperties.WATERLOGGED, and blockstate property lookup is identity-based,
    // so a same-named-but-different property object throws "Cannot get property ... as it
    // does not exist" the moment a water bucket is used on this block.
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public static final int STYLE_SIMPLE = 0;
    public static final int STYLE_SIMPLE_TALL = 1;
    public static final int STYLE_OPEN = 2;
    public static final int STYLE_OPEN_TALL = 3;
    public static final int STYLE_NO_BACK = 4;
    public static final IntegerProperty STYLE = IntegerProperty.create("style", STYLE_SIMPLE, STYLE_NO_BACK);

    private static final VoxelShape SEAT = Block.box(2, 6, 2, 14, 8, 14);
    private static final VoxelShape LEG_NW = Block.box(3, 0, 3, 5, 6, 5);
    private static final VoxelShape LEG_NE = Block.box(11, 0, 3, 13, 6, 5);
    private static final VoxelShape LEG_SE = Block.box(11, 0, 11, 13, 6, 13);
    private static final VoxelShape LEG_SW = Block.box(3, 0, 11, 5, 6, 13);
    private static final VoxelShape BASE = Shapes.or(SEAT, LEG_NW, LEG_NE, LEG_SE, LEG_SW);

    private static final VoxelShape SIMPLE_BACKREST_FACING_NORTH = Block.box(2, 8, 12, 14, 19, 14);
    private static final VoxelShape SIMPLE_TALL_BACKREST_FACING_NORTH = Block.box(2, 8, 12, 14, 19+2, 14);
    // Matches chair_open_backrest_core.json's 4 elements (everything above the seat that
    // isn't a leg) with FACING=north. Chosen over a simplified bounding box per the
    // exact-lattice-collision decision: you can reach/see through the gaps, e.g. to place a
    // torch on the back.
    private static final VoxelShape OPEN_BACKREST_FACING_NORTH = Shapes.or(
            Block.box(2, 8, 12, 4, 19, 14), // left post
            Block.box(12, 8, 12, 14, 19, 14), // right post
            Block.box(4, 17, 12, 12, 19, 14), // top rail
            Block.box(4, 12, 12, 12, 13, 14) // mid rail
    );

    private static final VoxelShape OPEN_TALL_BACKREST_FACING_NORTH = Shapes.or(
            Block.box(2, 8, 12, 4, 19+2, 14), // left post
            Block.box(12, 8, 12, 14, 19+2, 14), // right post
            Block.box(4, 17+2, 12, 12, 19+2, 14), // top rail
            Block.box(4, 12-1, 12, 12, 13-1, 14), // lower mid rail
            Block.box(4, 12+3, 12, 12, 13+3, 14) // upper mid rail
    );

    // Indexed [STYLE][facing: north/east/south/west], precomputed once per block instance
    // since every element here is a fixed set of axis-aligned boxes.
    private final VoxelShape[][] shapesByStyle = new VoxelShape[5][4];

    public ChairSimpleBlock(Properties properties) {
        super(properties);
        for (int style = STYLE_SIMPLE; style <= STYLE_NO_BACK; style++) {
            VoxelShape backrestNorth = backrestShapeFacingNorth(style);
            VoxelShape backrestEast = rotateY90(backrestNorth);
            VoxelShape backrestSouth = rotateY90(backrestEast);
            VoxelShape backrestWest = rotateY90(backrestSouth);
            shapesByStyle[style][0] = Shapes.or(BASE, backrestNorth);
            shapesByStyle[style][1] = Shapes.or(BASE, backrestEast);
            shapesByStyle[style][2] = Shapes.or(BASE, backrestSouth);
            shapesByStyle[style][3] = Shapes.or(BASE, backrestWest);
        }
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(STYLE, STYLE_SIMPLE)
                .setValue(WATERLOGGED, false));
    }

    /** This style's backrest shape when FACING=north (i.e. on the block's south side). */
    private static VoxelShape backrestShapeFacingNorth(int style) {
        return switch (style) {
            case STYLE_SIMPLE_TALL -> SIMPLE_TALL_BACKREST_FACING_NORTH;
            case STYLE_OPEN -> OPEN_BACKREST_FACING_NORTH;
            case STYLE_OPEN_TALL -> OPEN_TALL_BACKREST_FACING_NORTH;
            case STYLE_NO_BACK -> Shapes.empty();
            default -> SIMPLE_BACKREST_FACING_NORTH;
        };
    }

    // Rotates a VoxelShape 90 degrees clockwise as viewed from above, matching the "y: 90"
    // blockstate rotation convention used everywhere else in this project (e.g. table/chair
    // models authored facing north, rotated per FACING in the generated blockstate). VoxelShape
    // has no built-in rotate, but every shape here is just axis-aligned boxes, so decomposing
    // via toAabbs() and remapping each corner is exact - verified by hand against
    // ChairSimpleBlock's previous 4 hand-authored backrest boxes before this refactor (each one
    // came out byte-for-byte identical to rotating the previous facing's box by this formula).
    private static VoxelShape rotateY90(VoxelShape shape) {
        VoxelShape result = Shapes.empty();
        for (AABB box : shape.toAabbs()) {
            result = Shapes.or(result, Shapes.create(new AABB(
                    1 - box.maxZ, box.minY, box.minX,
                    1 - box.minZ, box.maxY, box.maxX)));
        }
        return result;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        // HorizontalDirectionalBlock does NOT add FACING itself (unlike what its name might
        // suggest) - vanilla subclasses like FurnaceBlock/ChestBlock each add it explicitly,
        // so this has to too, or FACING is never part of the state definition and
        // setValue(FACING, ...) below throws "does not exist" the moment this constructs.
        builder.add(FACING, HALF, STYLE, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        // Refuse to place at all unless the space above is free - a chair whose backrest
        // pokes into an already-solid block above would otherwise just render clipped into it.
        if (!level.getBlockState(pos.above()).canBeReplaced(context)) {
            return null;
        }
        FluidState fluidState = level.getFluidState(pos);
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection())
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(STYLE, STYLE_SIMPLE)
                .setValue(WATERLOGGED, !fluidState.isEmpty());
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        // Claims the space above with a real (if invisible) blockstate of this same chair, so
        // nothing else can be placed there afterwards - see the class doc for the full picture.
        BlockPos abovePos = pos.above();
        FluidState fluidState = level.getFluidState(abovePos);
        level.setBlock(abovePos, state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, !fluidState.isEmpty()), 3);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            // No collision/model of its own - the LOWER half's backrest already overflows
            // visually into this space, this half exists purely to reserve it.
            return Shapes.empty();
        }
        VoxelShape[] byFacing = shapesByStyle[blockState.getValue(STYLE)];
        return switch (blockState.getValue(FACING)) {
            case SOUTH -> byFacing[2];
            case WEST -> byFacing[3];
            case EAST -> byFacing[1];
            default -> byFacing[0];
        };
    }

    // True when this half's counterpart (the block directly above a LOWER half, or directly
    // below an UPPER half) is no longer a matching half of this same chair - i.e. it was
    // broken/replaced out from under this one, so this half should disappear too rather than
    // leave a dangling orphan. Mirrors DoublePlantBlock/DoorBlock's own updateShape check.
    private boolean isPairedHalfGone(BlockState state, Direction direction, BlockState neighborState) {
        if (direction.getAxis() != Direction.Axis.Y) {
            return false;
        }
        DoubleBlockHalf half = state.getValue(HALF);
        boolean directionToCheck = (half == DoubleBlockHalf.LOWER) == (direction == Direction.UP);
        if (!directionToCheck) {
            return false;
        }
        return neighborState.getBlock() != this || neighborState.getValue(HALF) == half;
    }

    @Override
    public double getSeatHeight(BlockState state) {
        // Matches the SEAT box's top face (y=8 out of 16) above.
        return 0.5;
    }

    @Override
    public float getSeatYaw(BlockState state) {
        return state.getValue(FACING).toYRot();
    }

    @Override
    public float getMaxYawDeviation(BlockState state) {
        if (state.getValue(STYLE) == STYLE_NO_BACK) {
            // No backrest to clip through, so free look instead of the clamp below.
            return Float.POSITIVE_INFINITY;
        }
        // Free look left/right up to 90 degrees each way, but clamped before it turns far
        // enough to look straight back through the backrest.
        return 90f;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            // The UPPER half's own destruction (e.g. an explosion catching both halves
            // independently, unlike updateShape's neighbor-triggered removal) would otherwise
            // double the drop - only the LOWER half represents "the chair" for this purpose.
            return List.of();
        }
        // No loot table backs this block (see ModBlocks.java) - STYLE is a cosmetic/collision
        // variant, not a separate item, so every style drops the same (only) registered item
        // regardless of which one is currently showing.
        return List.of(new ItemStack(this.asItem()));
    }

    //? if < 1.20.5 {
    /*
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return interact(state, level, pos, player);
    }
    */
    //?} else {
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        return interact(state, level, pos, player);
    }
    //?}

    // Clicking the invisible UPPER half (its hitbox is empty, but a player can still target it
    // e.g. via a hit against the LOWER half's overflowing model that resolves to the block
    // above) redirects down to the LOWER half, which both sitting and cycling understand.
    private InteractionResult interact(BlockState state, Level level, BlockPos pos, Player player) {
        BlockPos lowerPos = state.getValue(HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos;
        BlockState lowerState = state.getValue(HALF) == DoubleBlockHalf.UPPER ? level.getBlockState(lowerPos) : state;
        if (player.isShiftKeyDown()) {
            return cycleStyle(lowerState, level, lowerPos);
        }
        return SeatEntity.sit(this, lowerState, level, lowerPos, player);
    }

    // Shift-right-click with an empty hand advances STYLE (wrapping back to simple) on both
    // halves instead of sitting down. This only ever changes blockstate on the SAME block
    // instance - unlike the previous per-style-subclass design, there's no cross-block
    // neighbor-shape cascade to guard against here (isPairedHalfGone only compares HALF/block
    // identity, both unaffected by STYLE), so a plain flag suffices.
    private InteractionResult cycleStyle(BlockState lowerState, Level level, BlockPos lowerPos) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        int nextStyle = (lowerState.getValue(STYLE) + 1) % 5;
        level.setBlock(lowerPos, lowerState.setValue(STYLE, nextStyle), Block.UPDATE_ALL);
        level.setBlock(lowerPos.above(), lowerState.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STYLE, nextStyle), Block.UPDATE_ALL);
        return InteractionResult.SUCCESS;
    }

    //? if < 1.20.5 {
    /*
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return isPairedHalfGone(state, direction, neighborState) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
    */
    //? } else if < 1.21.6 {
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return isPairedHalfGone(state, direction, neighborState) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
    //?} else {
    /*
    @Override
    public BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource randomSource) {
        return isPairedHalfGone(state, direction, neighborState) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, levelReader, scheduledTickAccess, pos, direction, neighborPos, neighborState, randomSource);
    }
    */
    //?}

    //? if >= 1.20.4 {
    public static final MapCodec<ChairSimpleBlock> CODEC = simpleCodec(ChairSimpleBlock::new);

    @Override
    protected MapCodec<? extends ChairSimpleBlock> codec() {
        return CODEC;
    }
    //?}
}
