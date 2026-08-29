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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
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
 * "chair_simple_" variants - same leg/seat wood matrix as {@link StoolBlock}, but with a
 * {@link HorizontalDirectionalBlock#FACING} property and a backrest, so rotation while
 * sitting has to stay limited (see {@link #getMaxYawDeviation}) or the player's view would
 * clip straight through it.
 *
 * The seat and 4 legs are geometrically identical to {@link StoolBlock}'s (same box
 * coordinates) - only the backrest, placed on whichever side is opposite {@code FACING},
 * is new. {@link #getShape} therefore never needs real per-state rotation math: the leg/seat
 * base shape is rotationally symmetric on its own, so only the backrest's four possible
 * positions need to be listed explicitly.
 *
 * The backrest overflows a full unit above the block (y goes up to 19, not 16), so this
 * follows the same two-position pattern vanilla uses for doors/tall flowers: a
 * {@link #HALF} property, with the actual model only ever drawn by the {@code LOWER} half
 * (it already overflows into the block above's render space) while the {@code UPPER} half
 * is a real, otherwise-invisible blockstate occupying that space - {@link #getStateForPlacement}
 * refuses to place unless that space is free, {@link #setPlacedBy} claims it, and
 * {@link #updateShape} removes either half if its pair disappears, exactly like
 * {@code DoublePlantBlock}.
 */
public class ChairSimpleBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock, Seat {
    // Must reuse vanilla's own instance, not a new BooleanProperty.create("waterlogged") -
    // SimpleWaterloggedBlock's default placeLiquid()/getFluidState() hard-code a reference
    // to BlockStateProperties.WATERLOGGED, and blockstate property lookup is identity-based,
    // so a same-named-but-different property object throws "Cannot get property ... as it
    // does not exist" the moment a water bucket is used on this block.
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    private static final VoxelShape SEAT = Block.box(2, 6, 2, 14, 8, 14);
    private static final VoxelShape LEG_NW = Block.box(3, 0, 3, 5, 6, 5);
    private static final VoxelShape LEG_NE = Block.box(11, 0, 3, 13, 6, 5);
    private static final VoxelShape LEG_SE = Block.box(11, 0, 11, 13, 6, 13);
    private static final VoxelShape LEG_SW = Block.box(3, 0, 11, 5, 6, 13);
    private static final VoxelShape BASE = Shapes.or(SEAT, LEG_NW, LEG_NE, LEG_SE, LEG_SW);

    // The backrest sits on whichever side is opposite the direction the sitter faces -
    // e.g. FACING=north means the player faces north, so the backrest is on the south side.
    private static final VoxelShape BACKREST_FACING_NORTH = Block.box(2, 8, 12, 14, 19, 14);
    private static final VoxelShape BACKREST_FACING_SOUTH = Block.box(2, 8, 2, 14, 19, 4);
    private static final VoxelShape BACKREST_FACING_WEST = Block.box(12, 8, 2, 14, 19, 14);
    private static final VoxelShape BACKREST_FACING_EAST = Block.box(2, 8, 2, 4, 19, 14);

    private static final VoxelShape SHAPE_NORTH = Shapes.or(BASE, BACKREST_FACING_NORTH);
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(BASE, BACKREST_FACING_SOUTH);
    private static final VoxelShape SHAPE_WEST = Shapes.or(BASE, BACKREST_FACING_WEST);
    private static final VoxelShape SHAPE_EAST = Shapes.or(BASE, BACKREST_FACING_EAST);

    public ChairSimpleBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    //? if >= 1.20.4 {
    public static final MapCodec<ChairSimpleBlock> CODEC = simpleCodec(ChairSimpleBlock::new);

    @Override
    protected MapCodec<? extends ChairSimpleBlock> codec() {
        return CODEC;
    }
    //?}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        // HorizontalDirectionalBlock does NOT add FACING itself (unlike what its name might
        // suggest) - vanilla subclasses like FurnaceBlock/ChestBlock each add it explicitly,
        // so this has to too, or FACING is never part of the state definition and
        // setValue(FACING, ...) below throws "does not exist" the moment this constructs.
        builder.add(FACING, HALF, WATERLOGGED);
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
        return switch (blockState.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
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
        // Free look left/right up to 90 degrees each way, but clamped before it turns far
        // enough to look straight back through the backrest.
        return 90f;
    }

    //? if < 1.20.5 {
    /*
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return sit(state, level, pos, player);
    }
    */
    //?} else {
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        return sit(state, level, pos, player);
    }
    //?}

    // Clicking the invisible UPPER half (its hitbox is empty, but a player can still target it
    // e.g. via a hit against the LOWER half's overflowing model that resolves to the block
    // above) redirects down to the LOWER half, which is the only one SeatEntity#sit understands.
    private InteractionResult sit(BlockState state, Level level, BlockPos pos, Player player) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockPos lowerPos = pos.below();
            return SeatEntity.sit(this, level.getBlockState(lowerPos), level, lowerPos, player);
        }
        return SeatEntity.sit(this, state, level, pos, player);
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
}
