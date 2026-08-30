package com.thefusion21.alotofinterior.block;

import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
//? if >= 1.21.6 {
/*
import net.minecraft.world.level.ScheduledTickAccess;
*/
//?}

public class TableBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    // Must reuse vanilla's own instance, not a new BooleanProperty.create("waterlogged") -
    // SimpleWaterloggedBlock's default placeLiquid()/getFluidState() hard-code a reference
    // to BlockStateProperties.WATERLOGGED, and blockstate property lookup is identity-based,
    // so a same-named-but-different property object throws "Cannot get property ... as it
    // does not exist" the moment a water bucket is used on this block.
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    // Legs from y=0 to y=11, top slab from y=11 to y=13 - one unit taller than a plain
    // 3/4 block so a player sitting on a nearby chair/stool-style seat has knee clearance
    // underneath instead of clipping the tabletop - matching the geometry gen.py writes into
    // models/block/base/table_*.json.
    private static final VoxelShape TOP = Block.box(0, 11, 0, 16, 13, 16);
    private static final VoxelShape LEG_NW = Block.box(0, 0, 0, 2, 11, 2);
    private static final VoxelShape LEG_NE = Block.box(14, 0, 0, 16, 11, 2);
    private static final VoxelShape LEG_SE = Block.box(14, 0, 14, 16, 11, 16);
    private static final VoxelShape LEG_SW = Block.box(0, 0, 14, 2, 11, 16);

    public TableBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockGetter = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos northPos = blockPos.north();
        BlockPos eastPos = blockPos.east();
        BlockPos southPos = blockPos.south();
        BlockPos westPos = blockPos.west();
        return this.defaultBlockState()
                .setValue(NORTH, blockGetter.getBlockState(northPos).getBlock() == this)
                .setValue(EAST, blockGetter.getBlockState(eastPos).getBlock() == this)
                .setValue(SOUTH, blockGetter.getBlockState(southPos).getBlock() == this)
                .setValue(WEST, blockGetter.getBlockState(westPos).getBlock() == this)
                .setValue(WATERLOGGED, fluidState.isEmpty() ? false : true);
    }

    public boolean hasDynamicShape() {
        return true;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return false;
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        // SimpleWaterloggedBlock's default placeLiquid() only flips the WATERLOGGED
        // property - Block#getFluidState() isn't touched by that interface, so without
        // this override the game still thinks the block has no fluid at all: no water
        // render, no swimming/breathing, no fluid ticking.
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos,
            CollisionContext collisionContext) {
        boolean north = blockState.getValue(NORTH);
        boolean east = blockState.getValue(EAST);
        boolean south = blockState.getValue(SOUTH);
        boolean west = blockState.getValue(WEST);
        VoxelShape shape = TOP;
        if (!north && !west) {
            shape = Shapes.or(shape, LEG_NW);
        }
        if (!north && !east) {
            shape = Shapes.or(shape, LEG_NE);
        }
        if (!south && !east) {
            shape = Shapes.or(shape, LEG_SE);
        }
        if (!south && !west) {
            shape = Shapes.or(shape, LEG_SW);
        }
        return shape;
    }

    //? if < 1.20.5 {
    /*
    @Override
    public BlockState updateShape(BlockState arg, Direction arg2, BlockState arg3, LevelAccessor arg4, BlockPos arg5, BlockPos arg6) {
        if (arg.getValue(WATERLOGGED)) {
            arg4.scheduleTick(arg5, arg.getFluidState().getType(), arg.getFluidState().getType().getTickDelay(arg4));
        }

        if (arg2.getAxis().isHorizontal()) {
            boolean north = arg4.getBlockState(arg5.north()).getBlock() == this;
            boolean east = arg4.getBlockState(arg5.east()).getBlock() == this;
            boolean south = arg4.getBlockState(arg5.south()).getBlock() == this;
            boolean west = arg4.getBlockState(arg5.west()).getBlock() == this;
            return arg.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
        }
        return super.updateShape(arg, arg2, arg3, arg4, arg5, arg6);
    }
    */
    //? } else if < 1.21.6 {

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, blockState.getFluidState().getType(), blockState.getFluidState().getType().getTickDelay(levelAccessor));
        }
        if (direction.getAxis().isHorizontal()) {
            boolean north = levelAccessor.getBlockState(blockPos.north()).getBlock() == this;
            boolean east = levelAccessor.getBlockState(blockPos.east()).getBlock() == this;
            boolean south = levelAccessor.getBlockState(blockPos.south()).getBlock() == this;
            boolean west = levelAccessor.getBlockState(blockPos.west()).getBlock() == this;
            return blockState.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    //?} else {
    /*
    @Override
    public BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, blockState.getFluidState().getType(), blockState.getFluidState().getType().getTickDelay(levelReader));
        }
        if (direction.getAxis().isHorizontal()) {
            boolean north = levelReader.getBlockState(blockPos.north()).getBlock() == this;
            boolean east = levelReader.getBlockState(blockPos.east()).getBlock() == this;
            boolean south = levelReader.getBlockState(blockPos.south()).getBlock() == this;
            boolean west = levelReader.getBlockState(blockPos.west()).getBlock() == this;
            return blockState.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
        }
        return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
    }
    */
    //?}

}
