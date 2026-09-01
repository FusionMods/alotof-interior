package com.thefusion21.alotofinterior.registry;

import com.thefusion21.alotofinterior.ALotOfInterior;
import com.thefusion21.alotofinterior.entity.DrawerBlockEntity;

//import com.thefusion21.alotofinterior.block.entity.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Cross-loader block entity registry, same {@link DeferredRegister} pattern as
 * {@link ModItems}/{@link ModBlocks}. {@link #newType} is the one genuine Minecraft
 * *version* difference this hits, and it's an unusually sharp one: 1.21.2 removed
 * {@code BlockEntityType.Builder} *and* privatized {@code BlockEntityType}'s constructor,
 * with no vanilla public replacement. Fabric API and NeoForge each patch in their own
 * widened path for their loader specifically (Fabric API's {@code FabricBlockEntityTypeBuilder},
 * NeoForge's own access-transformed constructor) - see
 * https://docs.fabricmc.net/develop/blocks/block-entities and
 * https://docs.neoforged.net/docs/blockentities/ - but neither is available from shared
 * {@code common} code, so there's no single vanilla or Architectury API call to make here.
 * {@link #newType} reaches through reflection instead for versions that need it, to keep
 * this one call shared rather than duplicating block entity registration per loader.
 */
public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ALotOfInterior.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    private ModBlockEntities() {
    }

    /** Registers a {@link BlockEntityType} valid for exactly one block - see {@link #register(String, BlockEntityType.BlockEntitySupplier, Supplier[])} for one shared across several (e.g. one wood matrix). */
    public static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String name, BlockEntityType.BlockEntitySupplier<T> factory, Supplier<? extends Block> block) {
        return BLOCK_ENTITIES.register(name, () -> newType(factory, block.get()));
    }

    /**
     * Registers a {@link BlockEntityType} valid for every given block - e.g. {@link DrawerBlockEntity}'s
     * one type backing all 12 wood-variant {@code DrawerBlock}s, the same way vanilla's one
     * {@code BlockEntityType.SIGN} backs oak/spruce/birch/... sign blocks.
     */
    @SafeVarargs
    public static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(
            String name, BlockEntityType.BlockEntitySupplier<T> factory, Supplier<? extends Block>... blocks) {
        return BLOCK_ENTITIES.register(name, () -> newType(factory, Arrays.stream(blocks).map(Supplier::get).toArray(Block[]::new)));
    }

    public static final RegistrySupplier<BlockEntityType<DrawerBlockEntity>> DRAWER = register("drawer_entity",
            DrawerBlockEntity::new,
            ModBlocks.OAK_DRAWER,
            ModBlocks.SPRUCE_DRAWER,
            ModBlocks.BIRCH_DRAWER,
            ModBlocks.JUNGLE_DRAWER,
            ModBlocks.ACACIA_DRAWER,
            ModBlocks.DARK_OAK_DRAWER,
            ModBlocks.MANGROVE_DRAWER,
            ModBlocks.CRIMSON_DRAWER,
            ModBlocks.WARPED_DRAWER,
            //? if >= 1.21.6 {
            /*
            ModBlocks.PALE_OAK_DRAWER,
            */
            //?}
            ModBlocks.CHERRY_DRAWER,
            ModBlocks.BAMBOO_DRAWER);

    //? if >=1.21.2 {
    /*
    private static <T extends BlockEntity> BlockEntityType<T> newType(BlockEntityType.BlockEntitySupplier<T> factory, Block... blocks) {
        try {
            var constructor = BlockEntityType.class.getDeclaredConstructor(BlockEntityType.BlockEntitySupplier.class, java.util.Set.class);
            constructor.setAccessible(true);
            return (BlockEntityType<T>) constructor.newInstance(factory, java.util.Set.of(blocks));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to construct BlockEntityType for " + Arrays.toString(blocks), e);
        }
    }
    */
    //?} else {
    private static <T extends BlockEntity> BlockEntityType<T> newType(BlockEntityType.BlockEntitySupplier<T> factory, Block... blocks) {
        return BlockEntityType.Builder.of(factory, blocks).build(null);
    }
    //?}
}
