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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
//? if >= 1.21.6 {
/*
import net.minecraft.world.level.ScheduledTickAccess;
*/
//?}

public class StoolBlock extends Block implements SimpleWaterloggedBlock {
    // Must reuse vanilla's own instance, not a new BooleanProperty.create("waterlogged") -
    // SimpleWaterloggedBlock's default placeLiquid()/getFluidState() hard-code a reference
    // to BlockStateProperties.WATERLOGGED, and blockstate property lookup is identity-based,
    // so a same-named-but-different property object throws "Cannot get property ... as it
    // does not exist" the moment a water bucket is used on this block.
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape LEG_NW = Block.box(3, 0, 3, 5, 6, 5);
    private static final VoxelShape LEG_NE = Block.box(11, 0, 3, 13, 6, 5);
    private static final VoxelShape LEG_SE = Block.box(11, 0, 11, 13, 6, 13);
    private static final VoxelShape LEG_SW = Block.box(3, 0, 11, 5, 6, 13);
    private static final VoxelShape SEAT = Block.box(2, 6, 2, 14, 8, 14);

    public StoolBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, !fluidState.isEmpty());
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
        return Shapes.or(LEG_NW, LEG_NE, LEG_SE, LEG_SW, SEAT);
    }
}
