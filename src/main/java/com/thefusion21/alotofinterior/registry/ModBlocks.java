package com.thefusion21.alotofinterior.registry;

import com.thefusion21.alotofinterior.ALotOfInterior;
import com.thefusion21.alotofinterior.block.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ALotOfInterior.MOD_ID, Registries.BLOCK);

    // OAK TABLES
    public static final RegistrySupplier<TableBlock> OAK_OAK_TABLE = registerWithItem(
        "table_oak_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_SPRUCE_TABLE = registerWithItem(
        "table_oak_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BIRCH_TABLE = registerWithItem(
        "table_oak_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_JUNGLE_TABLE = registerWithItem(
        "table_oak_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_ACACIA_TABLE = registerWithItem(
        "table_oak_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_DARK_OAK_TABLE = registerWithItem(
        "table_oak_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_MANGROVE_TABLE = registerWithItem(
        "table_oak_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_CRIMSON_TABLE = registerWithItem(
        "table_oak_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_WARPED_TABLE = registerWithItem(
        "table_oak_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_GLASS_TABLE = registerWithItem(
        "table_oak_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    
            

    private ModBlocks() {
    }

    /** Registers a block with no accompanying item - see {@link #registerWithItem} for the common case. */
    public static <T extends Block> RegistrySupplier<T> registerBlockOnly(String name, Function<BlockBehaviour.Properties, T> block) {
        return BLOCKS.register(name, () -> block.apply(newProperties(name)));
    }

    /** Registers a block and a matching {@link net.minecraft.world.item.BlockItem} for it. */
    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Function<BlockBehaviour.Properties, T> block, Item.Properties itemProperties) {
        RegistrySupplier<T> registered = registerBlockOnly(name, block);
        ModItems.registerBlockItem(name, registered, itemProperties);
        return registered;
    }

    //? if < 1.21.6 {
    private static BlockBehaviour.Properties newProperties(String name) {
        return BlockBehaviour.Properties.of();
    }
    //? } else if < 1.21.11 {
    /*
    private static BlockBehaviour.Properties newProperties(String name) {
        return BlockBehaviour.Properties.of().setId(blockId(name));
    }

    private static net.minecraft.resources.ResourceKey<Block> blockId(String name) {
        return net.minecraft.resources.ResourceKey.create(Registries.BLOCK, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(ALotOfInterior.MOD_ID, name));
    }
    */
    //? } else {
    /*
    // 1.21.11 made BlockBehaviour.Properties#setId(ResourceKey<Block>) mandatory - the
    // Block/BlockBehaviour constructor now calls properties.effectiveDrops()/
    // effectiveDescriptionId(), which both require the id up front (Block's registry
    // name isn't known otherwise until DeferredRegister binds it later).
    private static BlockBehaviour.Properties newProperties(String name) {
        return BlockBehaviour.Properties.of().setId(blockId(name));
    }

    private static net.minecraft.resources.ResourceKey<Block> blockId(String name) {
        return net.minecraft.resources.ResourceKey.create(Registries.BLOCK, net.minecraft.resources.Identifier.fromNamespaceAndPath(ALotOfInterior.MOD_ID, name));
    }
    */
    //? }
}
