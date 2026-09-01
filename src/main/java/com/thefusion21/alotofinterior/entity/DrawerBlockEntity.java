package com.thefusion21.alotofinterior.entity;

import com.thefusion21.alotofinterior.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

//? if >= 1.21.9 {
/*
import net.minecraft.world.entity.ContainerUser;
*/  
//?}

public class DrawerBlockEntity extends RandomizableContainerBlockEntity implements LidBlockEntity {
    // Matches ChestBlockEntity's own EVENT_SET_OPEN_COUNT - the block-event id used below
    // to tell the client (via triggerEvent) how many players currently have this drawer
    // open, which is what actually drives the lid animation opening/closing.
    private static final int EVENT_SET_OPEN_COUNT = 1;

    private NonNullList<ItemStack> items;
    private final ContainerOpenersCounter openersCounter;
    private final ChestLidController chestLidController;

    public DrawerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.DRAWER.get(), blockPos, blockState);
        this.items = NonNullList.withSize(9, ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                // No open/close sound yet - left to the sounds/textures pass.
            }

            protected void onClose(Level level, BlockPos pos, BlockState state) {
            }

            protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int count, int openCount) {
                Block block = state.getBlock();
                level.blockEvent(pos, block, EVENT_SET_OPEN_COUNT, openCount);
            }

            public boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ChestMenu) {
                    Container container = ((ChestMenu)player.containerMenu).getContainer();
                    return container == DrawerBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
        this.chestLidController = new ChestLidController();
    }

    @Override
    public boolean triggerEvent(int id, int count) {
        if (id == EVENT_SET_OPEN_COUNT) {
            this.chestLidController.shouldBeOpen(count > 0);
            return true;
        }
        return super.triggerEvent(id, count);
    }

    /** Client-side tick, driven by {@link com.thefusion21.alotofinterior.block.DrawerBlock#getTicker}. */
    public static void lidAnimateTick(Level level, BlockPos pos, BlockState state, DrawerBlockEntity blockEntity) {
        blockEntity.chestLidController.tickLid();
    }

    /** Server-side tick, driven by {@link com.thefusion21.alotofinterior.block.DrawerBlock#tick}. */
    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public int getContainerSize() {
        return 9;
    }

    @Override
    public float getOpenNess(float f) {
        return this.chestLidController.getOpenness(f);
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        // Single (uncombined) segment only - DrawerBlock.getMenuProvider() builds the
        // merged 2/3-segment menu itself when segments are combined. Uses ChestMenu's
        // (MenuType, int, Inventory, Container, int) constructor directly - the
        // container-accepting oneRow()/twoRows() convenience factories don't exist on
        // every targeted version, but this constructor is stable across all of them.
        return new ChestMenu(MenuType.GENERIC_9x1, i, inventory, this, 1);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.drawer");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        this.items = nonNullList;
    }

    //? if >= 1.21.9 {
    /*
    public void startOpen(ContainerUser containerUser) {
        if (!this.remove && !containerUser.getLivingEntity().isSpectator()) {
            this.openersCounter.incrementOpeners(containerUser.getLivingEntity(), this.getLevel(), this.getBlockPos(), this.getBlockState(), containerUser.getContainerInteractionRange());
        }
    }

    public void stopOpen(ContainerUser containerUser) {
        if (!this.remove && !containerUser.getLivingEntity().isSpectator()) {
            this.openersCounter.decrementOpeners(containerUser.getLivingEntity(), this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }
    */
    //? } else {
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }
    //? }
}
