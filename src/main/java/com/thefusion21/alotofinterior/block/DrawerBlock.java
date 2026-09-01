package com.thefusion21.alotofinterior.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;
import com.thefusion21.alotofinterior.block.state.DrawerType;
import com.thefusion21.alotofinterior.entity.DrawerBlockEntity;
import com.thefusion21.alotofinterior.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

//? if < 1.20.5 {
/*
import net.minecraft.world.InteractionHand;
*/
//?}
//? if >= 1.21.6 {
/*
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
*/
//?}

/**
 * A player-craftable furniture piece, up to 3 wide - unlike vanilla's {@code ChestBlock}
 * (which only ever pairs 2-wide, via {@link net.minecraft.world.level.block.DoubleBlockCombiner}),
 * this deliberately doesn't extend {@code AbstractChestBlock}: its one abstract method,
 * {@code combine(...)}, hard-codes a return type of
 * {@code DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity>} - not
 * {@code <? extends E>} - so it can only ever hold a real {@code ChestBlockEntity}, and
 * {@link DrawerBlockEntity} deliberately isn't one (that class is {@code final}-heavy enough
 * - private {@code openersCounter}/{@code chestLidController}/{@code items} fields, sounds
 * hard-coded to {@code SoundEvents.CHEST_*}, {@code setBlockState} hard-coded to
 * {@code ChestBlock.FACING}/{@code ChestBlock.TYPE} - that subclassing it to reuse its logic
 * would fight it at every turn instead of saving work). {@link #combinedSegments} below is
 * this class's own from-scratch equivalent, generalized to 1-3 blocks instead of 1-2.
 *
 * <p>Several {@code Block}/{@code BlockBehaviour} override signatures moved from {@code public}
 * to {@code protected} - and a few changed parameters entirely - across this project's targeted
 * versions (verified against real decompiled {@code ChestBlock} sources per era, not assumed):
 * 1.20.x methods are {@code public}; 1.21.1 flips the same methods to {@code protected} with
 * unchanged parameters; 1.21.6+ additionally rewrites {@code updateShape}'s parameter list and
 * replaces {@code onRemove} with {@code affectNeighborsAfterRemoval} (which no longer drops
 * contents itself - that's automatic since 1.21.6 - only notifies neighboring comparators).
 */
public class DrawerBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    // Must reuse vanilla's own instance, not a new BooleanProperty.create("waterlogged") -
    // SimpleWaterloggedBlock's default placeLiquid()/getFluidState() hard-code a reference
    // to BlockStateProperties.WATERLOGGED, and blockstate property lookup is identity-based,
    // so a same-named-but-different property object throws "Cannot get property ... as it
    // does not exist" the moment a water bucket is used on this block.
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<DrawerType> TYPE = EnumProperty.create("type", DrawerType.class);
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

    // Roughly matches the actual model's footprint (a shallow cabinet set back from the
    // block's front face, not a full cube) - not pixel-exact across every FACING, since the
    // real model/orientation convention is being built separately; swap this out once that's
    // finalized.
    private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 6, 16, 16, 16);
    private static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 0, 16, 16, 10);
    private static final VoxelShape SHAPE_WEST = Block.box(6, 0, 0, 16, 16, 16);
    private static final VoxelShape SHAPE_EAST = Block.box(0, 0, 0, 10, 16, 16);

    protected final Supplier<BlockEntityType<? extends DrawerBlockEntity>> blockEntityType;

    public DrawerBlock(Properties properties, Supplier<BlockEntityType<? extends DrawerBlockEntity>> supplier) {
        super(properties);
        this.blockEntityType = supplier;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, DrawerType.SINGLE).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    // --- Multi-block combining --------------------------------------------------------
    //
    // A LEFT's/MIDDLE's partner toward its right lies in facing.getClockWise(); a
    // RIGHT's/MIDDLE's partner toward its left lies in facing.getCounterClockWise() -
    // matches ChestBlock.getConnectedDirection(), just named for two directions instead
    // of one since MIDDLE (unlike anything in vanilla's ChestType) has both.

    private static Direction towardRight(Direction facing) {
        return facing.getClockWise();
    }

    private static Direction towardLeft(Direction facing) {
        return facing.getCounterClockWise();
    }

    private boolean isMatchingDrawer(BlockState candidate, Direction facing) {
        return candidate.is(this) && candidate.getValue(FACING) == facing;
    }

    private Optional<DrawerBlockEntity> blockEntityAt(BlockGetter level, BlockPos pos) {
        BlockEntity entity = level.getBlockEntity(pos);
        return entity instanceof DrawerBlockEntity drawer ? Optional.of(drawer) : Optional.empty();
    }

    /**
     * Every {@link DrawerBlockEntity} making up the same combined unit as (state, pos),
     * ordered left-to-right - or just the one at pos if it's not combined. Walks left to
     * find the leftmost segment first, then walks right collecting every segment up to
     * (and including) the rightmost one.
     */
    private List<DrawerBlockEntity> combinedSegments(BlockState state, BlockGetter level, BlockPos pos) {
        DrawerType type = state.getValue(TYPE);
        if (type == DrawerType.SINGLE) {
            return blockEntityAt(level, pos).map(List::of).orElse(List.of());
        }

        Direction facing = state.getValue(FACING);
        BlockPos leftmostPos = pos;
        BlockState leftmostState = state;
        while (leftmostState.getValue(TYPE) != DrawerType.SINGLE && leftmostState.getValue(TYPE) != DrawerType.LEFT) {
            leftmostPos = leftmostPos.relative(towardLeft(facing));
            leftmostState = level.getBlockState(leftmostPos);
            if (!isMatchingDrawer(leftmostState, facing)) {
                // Desynced state (shouldn't normally happen) - fall back to just this segment.
                return blockEntityAt(level, pos).map(List::of).orElse(List.of());
            }
        }

        List<DrawerBlockEntity> segments = new ArrayList<>(3);
        BlockPos current = leftmostPos;
        BlockState currentState = leftmostState;
        while (true) {
            Optional<DrawerBlockEntity> entity = blockEntityAt(level, current);
            if (entity.isEmpty()) {
                break;
            }
            segments.add(entity.get());
            if (currentState.getValue(TYPE) == DrawerType.SINGLE || currentState.getValue(TYPE) == DrawerType.RIGHT) {
                break;
            }
            current = current.relative(towardRight(facing));
            currentState = level.getBlockState(current);
            if (!isMatchingDrawer(currentState, facing)) {
                break;
            }
        }
        return segments;
    }

    private static Container mergedContainer(List<DrawerBlockEntity> segments) {
        return switch (segments.size()) {
            case 0 -> null;
            case 1 -> segments.get(0);
            case 2 -> new CompoundContainer(segments.get(0), segments.get(1));
            default -> new CompoundContainer(new CompoundContainer(segments.get(0), segments.get(1)), segments.get(2));
        };
    }

    private static MenuType<?> menuTypeFor(int segmentCount) {
        return switch (segmentCount) {
            case 1 -> MenuType.GENERIC_9x1;
            case 2 -> MenuType.GENERIC_9x2;
            default -> MenuType.GENERIC_9x3;
        };
    }

    //? if < 1.21.1 {
    /*
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
    */
    //?} else {
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
    //?}
        List<DrawerBlockEntity> segments = combinedSegments(state, level, pos);
        if (segments.isEmpty()) {
            return null;
        }
        if (segments.size() == 1) {
            return segments.get(0);
        }

        Container container = mergedContainer(segments);
        return new MenuProvider() {
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                return new ChestMenu(menuTypeFor(segments.size()), id, inventory, container, segments.size());
            }

            @Override
            public Component getDisplayName() {
                return segments.stream()
                        .filter(DrawerBlockEntity::hasCustomName)
                        .findFirst()
                        .map(DrawerBlockEntity::getDisplayName)
                        .orElse(Component.translatable("container.drawer"));
            }
        };
    }

    private InteractionResult interact(BlockState state, Level level, BlockPos pos, Player player) {
        if (level instanceof ServerLevel serverLevel) {
            MenuProvider menuProvider = this.getMenuProvider(state, level, pos);
            if (menuProvider != null) {
                player.openMenu(menuProvider);
                //? if < 1.21.6 {
                PiglinAi.angerNearbyPiglins(player, true);
                //?} else {
                /*
                PiglinAi.angerNearbyPiglins(serverLevel, player, true);
                */
                //?}
            }
        }

        return InteractionResult.SUCCESS;
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

    // --- Placement / neighbor updates --------------------------------------------------

    private DrawerType neighborTypeAt(BlockGetter level, BlockPos pos, Direction facing) {
        BlockState state = level.getBlockState(pos);
        return isMatchingDrawer(state, facing) ? state.getValue(TYPE) : null;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos pos = context.getClickedPos();

        // Attach next to an existing SINGLE (forming a new pair) or an existing pair's open
        // end (growing it into a triple) - checked on our right-hand side first, then our
        // left, matching ChestBlock.getStateForPlacement's own priority order. Doesn't
        // replicate its shift-click/clicked-face orientation override - that's a placement UX
        // nicety, not a functional gap.
        DrawerType type = DrawerType.SINGLE;
        DrawerType rightNeighbor = neighborTypeAt(context.getLevel(), pos.relative(towardRight(facing)), facing);
        DrawerType leftNeighbor = neighborTypeAt(context.getLevel(), pos.relative(towardLeft(facing)), facing);
        if (rightNeighbor == DrawerType.SINGLE || rightNeighbor == DrawerType.LEFT) {
            type = DrawerType.LEFT;
        } else if (leftNeighbor == DrawerType.SINGLE || leftNeighbor == DrawerType.RIGHT) {
            type = DrawerType.RIGHT;
        }

        return this.defaultBlockState().setValue(FACING, facing).setValue(TYPE, type).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    /**
     * Reacts to a horizontal neighbor changing: gaining or losing a connection on
     * whichever side changed. Generalizes ChestBlock.updateShape's single-partner
     * SINGLE&lt;-&gt;LEFT/RIGHT flip to a two-sided LEFT/MIDDLE/RIGHT/SINGLE state
     * machine (SINGLE and MIDDLE each track 0 or 2 connections; LEFT/RIGHT track exactly
     * 1, on their right/left side respectively).
     */
    private BlockState updateConnections(BlockState state, Direction direction, BlockState neighborState) {
        if (!direction.getAxis().isHorizontal()) {
            return state;
        }

        Direction facing = state.getValue(FACING);
        boolean isRightSide = direction == towardRight(facing);
        boolean isLeftSide = !isRightSide && direction == towardLeft(facing);
        if (!isRightSide && !isLeftSide) {
            return state;
        }

        DrawerType type = state.getValue(TYPE);
        DrawerType neighborType = isMatchingDrawer(neighborState, facing) ? neighborState.getValue(TYPE) : null;

        if (isRightSide) {
            boolean haveRightPartner = type == DrawerType.LEFT || type == DrawerType.MIDDLE;
            if (!haveRightPartner && neighborType == DrawerType.RIGHT) {
                return state.setValue(TYPE, type == DrawerType.RIGHT ? DrawerType.MIDDLE : DrawerType.LEFT);
            }
            if (haveRightPartner && neighborType != DrawerType.RIGHT && neighborType != DrawerType.MIDDLE) {
                return state.setValue(TYPE, type == DrawerType.MIDDLE ? DrawerType.RIGHT : DrawerType.SINGLE);
            }
        } else {
            boolean haveLeftPartner = type == DrawerType.RIGHT || type == DrawerType.MIDDLE;
            if (!haveLeftPartner && neighborType == DrawerType.LEFT) {
                return state.setValue(TYPE, type == DrawerType.LEFT ? DrawerType.MIDDLE : DrawerType.RIGHT);
            }
            if (haveLeftPartner && neighborType != DrawerType.LEFT && neighborType != DrawerType.MIDDLE) {
                return state.setValue(TYPE, type == DrawerType.MIDDLE ? DrawerType.LEFT : DrawerType.SINGLE);
            }
        }

        return state;
    }

    //? if < 1.21.1 {
    /*
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return updateConnections(state, direction, neighborState);
    }
    */
    //?} else if < 1.21.6 {
    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return updateConnections(state, direction, neighborState);
    }
    //?} else {
    /*
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess tickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            tickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return updateConnections(state, direction, neighborState);
    }
    */
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapeFor(state);
    }
    */
    //?} else {
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapeFor(state);
    }
    //?}

    private static VoxelShape shapeFor(BlockState state) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> SHAPE_NORTH;
        };
    }

    //? if < 1.21.1 {
    /*
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    */
    //?} else {
    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        // Matches vanilla 1.20.x ChestBlock.onRemove exactly - dropContentsOnDestroy(...)
        // (used on 1.21.1) doesn't exist yet on this era.
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof Container container) {
                Containers.dropContents(level, pos, container);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }
    */
    //?} else if < 1.21.6 {
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        Containers.dropContentsOnDestroy(state, newState, level, pos);
        super.onRemove(state, level, pos, newState, isMoving);
    }
    //?} else {
    /*
    // Content-dropping itself is automatic since 1.21.6 (tied to the block entity's own
    // "container" data, not something the block needs to trigger manually anymore) - this
    // is only left to notify neighboring comparators that this position's signal changed.
    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean isMoving) {
        Containers.updateNeighboursAfterDestroy(state, level, pos);
    }
    */
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }
    */
    //?} else {
    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromContainer(mergedContainer(combinedSegments(state, level, pos)));
    }
    */
    //?} else if < 1.21.9 {
    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromContainer(mergedContainer(combinedSegments(state, level, pos)));
    }
    //?} else {
    /*
    // The extra Direction (which side the comparator is reading from) isn't needed - a
    // drawer's signal doesn't vary by side, same as ChestBlock's never has either. Verified
    // directly against each 1.21.x jar: the param lands exactly at 1.21.9 (1.21.6-1.21.8
    // still use the 3-arg form), not 1.21.11 like the Item.Properties#setId() boundary
    // elsewhere in this codebase - a different, independently-verified API, not the same one.
    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return AbstractContainerMenu.getRedstoneSignalFromContainer(mergedContainer(combinedSegments(state, level, pos)));
    }
    */
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }
    */
    //?} else {
    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
    */
    //?} else {
    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
    //?}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, WATERLOGGED);
    }

    //? if < 1.21.1 {
    /*
    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType pathComputationType) {
        return false;
    }
    */
    //?} else {
    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }
    //?}

    //? if < 1.21.1 {
    /*
    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DrawerBlockEntity drawer) {
            drawer.recheckOpen();
        }
    }
    */
    //?} else {
    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DrawerBlockEntity drawer) {
            drawer.recheckOpen();
        }
    }
    //?}

    // RenderShape.ENTITYBLOCK_ANIMATED itself is gone on 1.21.6+ (RenderShape is down to just
    // INVISIBLE/MODEL there) - the whole "static model + animated block-entity renderer on
    // top" split moved to a different mechanism this project's rendering pass will need to
    // pick up for that era; not overriding getRenderShape here just leaves the 1.21.6+ default
    // (MODEL) in place until then.
    //? if < 1.21.6 {
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
    //?}

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DrawerBlockEntity(pos, state);
    }

    public BlockEntityType<? extends DrawerBlockEntity> blockEntityType() {
        return this.blockEntityType.get();
    }

    // isClientSide() (the method, not the field, which went private at 1.21.9) is available
    // on every targeted version back to 1.20.1 - verified directly, no gating needed.
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? createTickerHelper(type, this.blockEntityType(), DrawerBlockEntity::lidAnimateTick) : null;
    }

    //? if >= 1.20.4 {
    public static final MapCodec<DrawerBlock> CODEC = simpleCodec((properties) -> new DrawerBlock(properties, () -> ModBlockEntities.DRAWER.get()));

    public MapCodec<DrawerBlock> codec() {
        return CODEC;
    }
    //?}
}
