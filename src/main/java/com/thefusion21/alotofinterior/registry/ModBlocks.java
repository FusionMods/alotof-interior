package com.thefusion21.alotofinterior.registry;

import com.thefusion21.alotofinterior.ALotOfInterior;
import com.thefusion21.alotofinterior.block.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> OAK_PALE_OAK_TABLE = registerWithItem(
        "table_oak_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> OAK_CHERRY_TABLE = registerWithItem(
        "table_oak_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BAMBOO_TABLE = registerWithItem(
        "table_oak_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_GLASS_TABLE = registerWithItem(
        "table_oak_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_TINTED_GLASS_TABLE = registerWithItem(
        "table_oak_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> OAK_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_oak_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // SPRUCE TABLES
    public static final RegistrySupplier<TableBlock> SPRUCE_OAK_TABLE = registerWithItem(
        "table_spruce_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_SPRUCE_TABLE = registerWithItem(
        "table_spruce_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_BIRCH_TABLE = registerWithItem(
        "table_spruce_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_JUNGLE_TABLE = registerWithItem(
        "table_spruce_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_ACACIA_TABLE = registerWithItem(
        "table_spruce_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_DARK_OAK_TABLE = registerWithItem(
        "table_spruce_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_MANGROVE_TABLE = registerWithItem(
        "table_spruce_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_CRIMSON_TABLE = registerWithItem(
        "table_spruce_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_WARPED_TABLE = registerWithItem(
        "table_spruce_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> SPRUCE_PALE_OAK_TABLE = registerWithItem(
        "table_spruce_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> SPRUCE_CHERRY_TABLE = registerWithItem(
        "table_spruce_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_BAMBOO_TABLE = registerWithItem(
        "table_spruce_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_GLASS_TABLE = registerWithItem(
        "table_spruce_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_TINTED_GLASS_TABLE = registerWithItem(
        "table_spruce_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> SPRUCE_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_spruce_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // BIRCH TABLES
    public static final RegistrySupplier<TableBlock> BIRCH_OAK_TABLE = registerWithItem(
        "table_birch_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_SPRUCE_TABLE = registerWithItem(
        "table_birch_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_BIRCH_TABLE = registerWithItem(
        "table_birch_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_JUNGLE_TABLE = registerWithItem(
        "table_birch_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_ACACIA_TABLE = registerWithItem(
        "table_birch_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_DARK_OAK_TABLE = registerWithItem(
        "table_birch_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_MANGROVE_TABLE = registerWithItem(
        "table_birch_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_CRIMSON_TABLE = registerWithItem(
        "table_birch_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_WARPED_TABLE = registerWithItem(
        "table_birch_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> BIRCH_PALE_OAK_TABLE = registerWithItem(
        "table_birch_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> BIRCH_CHERRY_TABLE = registerWithItem(
        "table_birch_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_BAMBOO_TABLE = registerWithItem(
        "table_birch_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_GLASS_TABLE = registerWithItem(
        "table_birch_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_TINTED_GLASS_TABLE = registerWithItem(
        "table_birch_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BIRCH_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_birch_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // JUNGLE TABLES
    public static final RegistrySupplier<TableBlock> JUNGLE_OAK_TABLE = registerWithItem(
        "table_jungle_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_SPRUCE_TABLE = registerWithItem(
        "table_jungle_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_BIRCH_TABLE = registerWithItem(
        "table_jungle_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_JUNGLE_TABLE = registerWithItem(
        "table_jungle_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_ACACIA_TABLE = registerWithItem(
        "table_jungle_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_DARK_OAK_TABLE = registerWithItem(
        "table_jungle_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_MANGROVE_TABLE = registerWithItem(
        "table_jungle_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_CRIMSON_TABLE = registerWithItem(
        "table_jungle_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_WARPED_TABLE = registerWithItem(
        "table_jungle_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> JUNGLE_PALE_OAK_TABLE = registerWithItem(
        "table_jungle_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> JUNGLE_CHERRY_TABLE = registerWithItem(
        "table_jungle_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_BAMBOO_TABLE = registerWithItem(
        "table_jungle_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_GLASS_TABLE = registerWithItem(
        "table_jungle_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_TINTED_GLASS_TABLE = registerWithItem(
        "table_jungle_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> JUNGLE_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_jungle_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // ACACIA TABLES
    public static final RegistrySupplier<TableBlock> ACACIA_OAK_TABLE = registerWithItem(
        "table_acacia_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_SPRUCE_TABLE = registerWithItem(
        "table_acacia_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_BIRCH_TABLE = registerWithItem(
        "table_acacia_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_JUNGLE_TABLE = registerWithItem(
        "table_acacia_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_ACACIA_TABLE = registerWithItem(
        "table_acacia_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_DARK_OAK_TABLE = registerWithItem(
        "table_acacia_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_MANGROVE_TABLE = registerWithItem(
        "table_acacia_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_CRIMSON_TABLE = registerWithItem(
        "table_acacia_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_WARPED_TABLE = registerWithItem(
        "table_acacia_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> ACACIA_PALE_OAK_TABLE = registerWithItem(
        "table_acacia_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> ACACIA_CHERRY_TABLE = registerWithItem(
        "table_acacia_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_BAMBOO_TABLE = registerWithItem(
        "table_acacia_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_GLASS_TABLE = registerWithItem(
        "table_acacia_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_TINTED_GLASS_TABLE = registerWithItem(
        "table_acacia_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> ACACIA_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_acacia_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // DARK_OAK TABLES
    public static final RegistrySupplier<TableBlock> DARK_OAK_OAK_TABLE = registerWithItem(
        "table_dark_oak_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_SPRUCE_TABLE = registerWithItem(
        "table_dark_oak_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_BIRCH_TABLE = registerWithItem(
        "table_dark_oak_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_JUNGLE_TABLE = registerWithItem(
        "table_dark_oak_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_ACACIA_TABLE = registerWithItem(
        "table_dark_oak_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_DARK_OAK_TABLE = registerWithItem(
        "table_dark_oak_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_MANGROVE_TABLE = registerWithItem(
        "table_dark_oak_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_CRIMSON_TABLE = registerWithItem(
        "table_dark_oak_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_WARPED_TABLE = registerWithItem(
        "table_dark_oak_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> DARK_OAK_PALE_OAK_TABLE = registerWithItem(
        "table_dark_oak_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> DARK_OAK_CHERRY_TABLE = registerWithItem(
        "table_dark_oak_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_BAMBOO_TABLE = registerWithItem(
        "table_dark_oak_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_GLASS_TABLE = registerWithItem(
        "table_dark_oak_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_TINTED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> DARK_OAK_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_dark_oak_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // MANGROVE TABLES
    public static final RegistrySupplier<TableBlock> MANGROVE_OAK_TABLE = registerWithItem(
        "table_mangrove_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_SPRUCE_TABLE = registerWithItem(
        "table_mangrove_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_BIRCH_TABLE = registerWithItem(
        "table_mangrove_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_JUNGLE_TABLE = registerWithItem(
        "table_mangrove_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_ACACIA_TABLE = registerWithItem(
        "table_mangrove_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_DARK_OAK_TABLE = registerWithItem(
        "table_mangrove_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_MANGROVE_TABLE = registerWithItem(
        "table_mangrove_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_CRIMSON_TABLE = registerWithItem(
        "table_mangrove_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_WARPED_TABLE = registerWithItem(
        "table_mangrove_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> MANGROVE_PALE_OAK_TABLE = registerWithItem(
        "table_mangrove_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> MANGROVE_CHERRY_TABLE = registerWithItem(
        "table_mangrove_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_BAMBOO_TABLE = registerWithItem(
        "table_mangrove_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_GLASS_TABLE = registerWithItem(
        "table_mangrove_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_TINTED_GLASS_TABLE = registerWithItem(
        "table_mangrove_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> MANGROVE_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_mangrove_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // CRIMSON TABLES
    public static final RegistrySupplier<TableBlock> CRIMSON_OAK_TABLE = registerWithItem(
        "table_crimson_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_SPRUCE_TABLE = registerWithItem(
        "table_crimson_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_BIRCH_TABLE = registerWithItem(
        "table_crimson_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_JUNGLE_TABLE = registerWithItem(
        "table_crimson_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_ACACIA_TABLE = registerWithItem(
        "table_crimson_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_DARK_OAK_TABLE = registerWithItem(
        "table_crimson_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_MANGROVE_TABLE = registerWithItem(
        "table_crimson_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_CRIMSON_TABLE = registerWithItem(
        "table_crimson_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_WARPED_TABLE = registerWithItem(
        "table_crimson_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> CRIMSON_PALE_OAK_TABLE = registerWithItem(
        "table_crimson_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> CRIMSON_CHERRY_TABLE = registerWithItem(
        "table_crimson_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_BAMBOO_TABLE = registerWithItem(
        "table_crimson_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_GLASS_TABLE = registerWithItem(
        "table_crimson_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_TINTED_GLASS_TABLE = registerWithItem(
        "table_crimson_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CRIMSON_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_crimson_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // WARPED TABLES
    public static final RegistrySupplier<TableBlock> WARPED_OAK_TABLE = registerWithItem(
        "table_warped_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_SPRUCE_TABLE = registerWithItem(
        "table_warped_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_BIRCH_TABLE = registerWithItem(
        "table_warped_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_JUNGLE_TABLE = registerWithItem(
        "table_warped_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_ACACIA_TABLE = registerWithItem(
        "table_warped_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_DARK_OAK_TABLE = registerWithItem(
        "table_warped_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_MANGROVE_TABLE = registerWithItem(
        "table_warped_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_CRIMSON_TABLE = registerWithItem(
        "table_warped_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_WARPED_TABLE = registerWithItem(
        "table_warped_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> WARPED_PALE_OAK_TABLE = registerWithItem(
        "table_warped_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> WARPED_CHERRY_TABLE = registerWithItem(
        "table_warped_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_BAMBOO_TABLE = registerWithItem(
        "table_warped_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_GLASS_TABLE = registerWithItem(
        "table_warped_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_TINTED_GLASS_TABLE = registerWithItem(
        "table_warped_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> WARPED_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_warped_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // PALE_OAK TABLES
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> PALE_OAK_OAK_TABLE = registerWithItem(
        "table_pale_oak_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_SPRUCE_TABLE = registerWithItem(
        "table_pale_oak_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_BIRCH_TABLE = registerWithItem(
        "table_pale_oak_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_JUNGLE_TABLE = registerWithItem(
        "table_pale_oak_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_ACACIA_TABLE = registerWithItem(
        "table_pale_oak_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_DARK_OAK_TABLE = registerWithItem(
        "table_pale_oak_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_MANGROVE_TABLE = registerWithItem(
        "table_pale_oak_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_CRIMSON_TABLE = registerWithItem(
        "table_pale_oak_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_WARPED_TABLE = registerWithItem(
        "table_pale_oak_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_PALE_OAK_TABLE = registerWithItem(
        "table_pale_oak_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_CHERRY_TABLE = registerWithItem(
        "table_pale_oak_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_BAMBOO_TABLE = registerWithItem(
        "table_pale_oak_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_GLASS_TABLE = registerWithItem(
        "table_pale_oak_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_TINTED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> PALE_OAK_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_pale_oak_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    // CHERRY TABLES
    public static final RegistrySupplier<TableBlock> CHERRY_OAK_TABLE = registerWithItem(
        "table_cherry_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_SPRUCE_TABLE = registerWithItem(
        "table_cherry_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_BIRCH_TABLE = registerWithItem(
        "table_cherry_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_JUNGLE_TABLE = registerWithItem(
        "table_cherry_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_ACACIA_TABLE = registerWithItem(
        "table_cherry_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_DARK_OAK_TABLE = registerWithItem(
        "table_cherry_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_MANGROVE_TABLE = registerWithItem(
        "table_cherry_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_CRIMSON_TABLE = registerWithItem(
        "table_cherry_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_WARPED_TABLE = registerWithItem(
        "table_cherry_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> CHERRY_PALE_OAK_TABLE = registerWithItem(
        "table_cherry_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> CHERRY_CHERRY_TABLE = registerWithItem(
        "table_cherry_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_BAMBOO_TABLE = registerWithItem(
        "table_cherry_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_GLASS_TABLE = registerWithItem(
        "table_cherry_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_TINTED_GLASS_TABLE = registerWithItem(
        "table_cherry_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> CHERRY_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_cherry_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // BAMBOO TABLES
    public static final RegistrySupplier<TableBlock> BAMBOO_OAK_TABLE = registerWithItem(
        "table_bamboo_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_SPRUCE_TABLE = registerWithItem(
        "table_bamboo_spruce",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_BIRCH_TABLE = registerWithItem(
        "table_bamboo_birch",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_JUNGLE_TABLE = registerWithItem(
        "table_bamboo_jungle",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_ACACIA_TABLE = registerWithItem(
        "table_bamboo_acacia",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_DARK_OAK_TABLE = registerWithItem(
        "table_bamboo_dark_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_MANGROVE_TABLE = registerWithItem(
        "table_bamboo_mangrove",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_CRIMSON_TABLE = registerWithItem(
        "table_bamboo_crimson",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_WARPED_TABLE = registerWithItem(
        "table_bamboo_warped",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<TableBlock> BAMBOO_PALE_OAK_TABLE = registerWithItem(
        "table_bamboo_pale_oak",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<TableBlock> BAMBOO_CHERRY_TABLE = registerWithItem(
        "table_bamboo_cherry",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_BAMBOO_TABLE = registerWithItem(
        "table_bamboo_bamboo",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_GLASS_TABLE = registerWithItem(
        "table_bamboo_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_TINTED_GLASS_TABLE = registerWithItem(
        "table_bamboo_tinted_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_WHITE_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_white_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_LIGHT_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_light_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_GRAY_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_gray_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_BLACK_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_black_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_BROWN_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_brown_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_RED_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_red_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_ORANGE_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_orange_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_YELLOW_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_yellow_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_LIME_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_lime_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_GREEN_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_green_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_CYAN_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_cyan_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_LIGHT_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_light_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_BLUE_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_blue_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_PURPLE_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_purple_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_MAGENTA_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_magenta_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<TableBlock> BAMBOO_PINK_STAINED_GLASS_TABLE = registerWithItem(
        "table_bamboo_pink_stained_glass",
        properties -> new TableBlock(properties.mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());

    // STOOLS
    public static final RegistrySupplier<StoolBlock> OAK_OAK_STOOL = registerWithItem(
        "stool_oak_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_SPRUCE_STOOL = registerWithItem(
        "stool_oak_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_BIRCH_STOOL = registerWithItem(
        "stool_oak_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_JUNGLE_STOOL = registerWithItem(
        "stool_oak_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_ACACIA_STOOL = registerWithItem(
        "stool_oak_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_DARK_OAK_STOOL = registerWithItem(
        "stool_oak_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_MANGROVE_STOOL = registerWithItem(
        "stool_oak_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_CRIMSON_STOOL = registerWithItem(
        "stool_oak_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_WARPED_STOOL = registerWithItem(
        "stool_oak_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> OAK_PALE_OAK_STOOL = registerWithItem(
        "stool_oak_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> OAK_CHERRY_STOOL = registerWithItem(
        "stool_oak_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> OAK_BAMBOO_STOOL = registerWithItem(
        "stool_oak_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // SPRUCE STOOLS
    public static final RegistrySupplier<StoolBlock> SPRUCE_OAK_STOOL = registerWithItem(
        "stool_spruce_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_SPRUCE_STOOL = registerWithItem(
        "stool_spruce_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_BIRCH_STOOL = registerWithItem(
        "stool_spruce_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_JUNGLE_STOOL = registerWithItem(
        "stool_spruce_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_ACACIA_STOOL = registerWithItem(
        "stool_spruce_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_DARK_OAK_STOOL = registerWithItem(
        "stool_spruce_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_MANGROVE_STOOL = registerWithItem(
        "stool_spruce_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_CRIMSON_STOOL = registerWithItem(
        "stool_spruce_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_WARPED_STOOL = registerWithItem(
        "stool_spruce_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> SPRUCE_PALE_OAK_STOOL = registerWithItem(
        "stool_spruce_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> SPRUCE_CHERRY_STOOL = registerWithItem(
        "stool_spruce_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> SPRUCE_BAMBOO_STOOL = registerWithItem(
        "stool_spruce_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // BIRCH STOOLS
    public static final RegistrySupplier<StoolBlock> BIRCH_OAK_STOOL = registerWithItem(
        "stool_birch_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_SPRUCE_STOOL = registerWithItem(
        "stool_birch_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_BIRCH_STOOL = registerWithItem(
        "stool_birch_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_JUNGLE_STOOL = registerWithItem(
        "stool_birch_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_ACACIA_STOOL = registerWithItem(
        "stool_birch_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_DARK_OAK_STOOL = registerWithItem(
        "stool_birch_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_MANGROVE_STOOL = registerWithItem(
        "stool_birch_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_CRIMSON_STOOL = registerWithItem(
        "stool_birch_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_WARPED_STOOL = registerWithItem(
        "stool_birch_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> BIRCH_PALE_OAK_STOOL = registerWithItem(
        "stool_birch_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> BIRCH_CHERRY_STOOL = registerWithItem(
        "stool_birch_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BIRCH_BAMBOO_STOOL = registerWithItem(
        "stool_birch_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // JUNGLE STOOLS
    public static final RegistrySupplier<StoolBlock> JUNGLE_OAK_STOOL = registerWithItem(
        "stool_jungle_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_SPRUCE_STOOL = registerWithItem(
        "stool_jungle_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_BIRCH_STOOL = registerWithItem(
        "stool_jungle_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_JUNGLE_STOOL = registerWithItem(
        "stool_jungle_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_ACACIA_STOOL = registerWithItem(
        "stool_jungle_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_DARK_OAK_STOOL = registerWithItem(
        "stool_jungle_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_MANGROVE_STOOL = registerWithItem(
        "stool_jungle_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_CRIMSON_STOOL = registerWithItem(
        "stool_jungle_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_WARPED_STOOL = registerWithItem(
        "stool_jungle_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> JUNGLE_PALE_OAK_STOOL = registerWithItem(
        "stool_jungle_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> JUNGLE_CHERRY_STOOL = registerWithItem(
        "stool_jungle_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> JUNGLE_BAMBOO_STOOL = registerWithItem(
        "stool_jungle_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // ACACIA STOOLS
    public static final RegistrySupplier<StoolBlock> ACACIA_OAK_STOOL = registerWithItem(
        "stool_acacia_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_SPRUCE_STOOL = registerWithItem(
        "stool_acacia_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_BIRCH_STOOL = registerWithItem(
        "stool_acacia_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_JUNGLE_STOOL = registerWithItem(
        "stool_acacia_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_ACACIA_STOOL = registerWithItem(
        "stool_acacia_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_DARK_OAK_STOOL = registerWithItem(
        "stool_acacia_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_MANGROVE_STOOL = registerWithItem(
        "stool_acacia_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_CRIMSON_STOOL = registerWithItem(
        "stool_acacia_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_WARPED_STOOL = registerWithItem(
        "stool_acacia_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> ACACIA_PALE_OAK_STOOL = registerWithItem(
        "stool_acacia_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> ACACIA_CHERRY_STOOL = registerWithItem(
        "stool_acacia_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> ACACIA_BAMBOO_STOOL = registerWithItem(
        "stool_acacia_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // DARK_OAK STOOLS
    public static final RegistrySupplier<StoolBlock> DARK_OAK_OAK_STOOL = registerWithItem(
        "stool_dark_oak_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_SPRUCE_STOOL = registerWithItem(
        "stool_dark_oak_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_BIRCH_STOOL = registerWithItem(
        "stool_dark_oak_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_JUNGLE_STOOL = registerWithItem(
        "stool_dark_oak_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_ACACIA_STOOL = registerWithItem(
        "stool_dark_oak_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_DARK_OAK_STOOL = registerWithItem(
        "stool_dark_oak_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_MANGROVE_STOOL = registerWithItem(
        "stool_dark_oak_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_CRIMSON_STOOL = registerWithItem(
        "stool_dark_oak_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_WARPED_STOOL = registerWithItem(
        "stool_dark_oak_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> DARK_OAK_PALE_OAK_STOOL = registerWithItem(
        "stool_dark_oak_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> DARK_OAK_CHERRY_STOOL = registerWithItem(
        "stool_dark_oak_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> DARK_OAK_BAMBOO_STOOL = registerWithItem(
        "stool_dark_oak_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // MANGROVE STOOLS
    public static final RegistrySupplier<StoolBlock> MANGROVE_OAK_STOOL = registerWithItem(
        "stool_mangrove_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_SPRUCE_STOOL = registerWithItem(
        "stool_mangrove_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_BIRCH_STOOL = registerWithItem(
        "stool_mangrove_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_JUNGLE_STOOL = registerWithItem(
        "stool_mangrove_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_ACACIA_STOOL = registerWithItem(
        "stool_mangrove_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_DARK_OAK_STOOL = registerWithItem(
        "stool_mangrove_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_MANGROVE_STOOL = registerWithItem(
        "stool_mangrove_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_CRIMSON_STOOL = registerWithItem(
        "stool_mangrove_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_WARPED_STOOL = registerWithItem(
        "stool_mangrove_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> MANGROVE_PALE_OAK_STOOL = registerWithItem(
        "stool_mangrove_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> MANGROVE_CHERRY_STOOL = registerWithItem(
        "stool_mangrove_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> MANGROVE_BAMBOO_STOOL = registerWithItem(
        "stool_mangrove_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // CRIMSON STOOLS
    public static final RegistrySupplier<StoolBlock> CRIMSON_OAK_STOOL = registerWithItem(
        "stool_crimson_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_SPRUCE_STOOL = registerWithItem(
        "stool_crimson_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_BIRCH_STOOL = registerWithItem(
        "stool_crimson_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_JUNGLE_STOOL = registerWithItem(
        "stool_crimson_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_ACACIA_STOOL = registerWithItem(
        "stool_crimson_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_DARK_OAK_STOOL = registerWithItem(
        "stool_crimson_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_MANGROVE_STOOL = registerWithItem(
        "stool_crimson_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_CRIMSON_STOOL = registerWithItem(
        "stool_crimson_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_WARPED_STOOL = registerWithItem(
        "stool_crimson_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> CRIMSON_PALE_OAK_STOOL = registerWithItem(
        "stool_crimson_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> CRIMSON_CHERRY_STOOL = registerWithItem(
        "stool_crimson_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CRIMSON_BAMBOO_STOOL = registerWithItem(
        "stool_crimson_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // WARPED STOOLS
    public static final RegistrySupplier<StoolBlock> WARPED_OAK_STOOL = registerWithItem(
        "stool_warped_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_SPRUCE_STOOL = registerWithItem(
        "stool_warped_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_BIRCH_STOOL = registerWithItem(
        "stool_warped_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_JUNGLE_STOOL = registerWithItem(
        "stool_warped_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_ACACIA_STOOL = registerWithItem(
        "stool_warped_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_DARK_OAK_STOOL = registerWithItem(
        "stool_warped_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_MANGROVE_STOOL = registerWithItem(
        "stool_warped_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_CRIMSON_STOOL = registerWithItem(
        "stool_warped_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_WARPED_STOOL = registerWithItem(
        "stool_warped_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> WARPED_PALE_OAK_STOOL = registerWithItem(
        "stool_warped_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> WARPED_CHERRY_STOOL = registerWithItem(
        "stool_warped_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> WARPED_BAMBOO_STOOL = registerWithItem(
        "stool_warped_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // PALE_OAK STOOLS
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> PALE_OAK_OAK_STOOL = registerWithItem(
        "stool_pale_oak_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_SPRUCE_STOOL = registerWithItem(
        "stool_pale_oak_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_BIRCH_STOOL = registerWithItem(
        "stool_pale_oak_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_JUNGLE_STOOL = registerWithItem(
        "stool_pale_oak_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_ACACIA_STOOL = registerWithItem(
        "stool_pale_oak_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_DARK_OAK_STOOL = registerWithItem(
        "stool_pale_oak_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_MANGROVE_STOOL = registerWithItem(
        "stool_pale_oak_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_CRIMSON_STOOL = registerWithItem(
        "stool_pale_oak_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_WARPED_STOOL = registerWithItem(
        "stool_pale_oak_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_PALE_OAK_STOOL = registerWithItem(
        "stool_pale_oak_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_CHERRY_STOOL = registerWithItem(
        "stool_pale_oak_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> PALE_OAK_BAMBOO_STOOL = registerWithItem(
        "stool_pale_oak_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    // CHERRY STOOLS
    public static final RegistrySupplier<StoolBlock> CHERRY_OAK_STOOL = registerWithItem(
        "stool_cherry_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_SPRUCE_STOOL = registerWithItem(
        "stool_cherry_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_BIRCH_STOOL = registerWithItem(
        "stool_cherry_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_JUNGLE_STOOL = registerWithItem(
        "stool_cherry_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_ACACIA_STOOL = registerWithItem(
        "stool_cherry_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_DARK_OAK_STOOL = registerWithItem(
        "stool_cherry_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_MANGROVE_STOOL = registerWithItem(
        "stool_cherry_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_CRIMSON_STOOL = registerWithItem(
        "stool_cherry_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_WARPED_STOOL = registerWithItem(
        "stool_cherry_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> CHERRY_PALE_OAK_STOOL = registerWithItem(
        "stool_cherry_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> CHERRY_CHERRY_STOOL = registerWithItem(
        "stool_cherry_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> CHERRY_BAMBOO_STOOL = registerWithItem(
        "stool_cherry_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    // BAMBOO STOOLS
    public static final RegistrySupplier<StoolBlock> BAMBOO_OAK_STOOL = registerWithItem(
        "stool_bamboo_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_SPRUCE_STOOL = registerWithItem(
        "stool_bamboo_spruce",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_BIRCH_STOOL = registerWithItem(
        "stool_bamboo_birch",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_JUNGLE_STOOL = registerWithItem(
        "stool_bamboo_jungle",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_ACACIA_STOOL = registerWithItem(
        "stool_bamboo_acacia",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_DARK_OAK_STOOL = registerWithItem(
        "stool_bamboo_dark_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_MANGROVE_STOOL = registerWithItem(
        "stool_bamboo_mangrove",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_CRIMSON_STOOL = registerWithItem(
        "stool_bamboo_crimson",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_WARPED_STOOL = registerWithItem(
        "stool_bamboo_warped",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<StoolBlock> BAMBOO_PALE_OAK_STOOL = registerWithItem(
        "stool_bamboo_pale_oak",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<StoolBlock> BAMBOO_CHERRY_STOOL = registerWithItem(
        "stool_bamboo_cherry",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<StoolBlock> BAMBOO_BAMBOO_STOOL = registerWithItem(
        "stool_bamboo_bamboo",
        properties -> new StoolBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());

    // CHAIRS
    public static final RegistrySupplier<ChairSimpleBlock> OAK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> OAK_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> OAK_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> OAK_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_oak_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> SPRUCE_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_spruce_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BIRCH_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_birch_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> JUNGLE_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_jungle_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> ACACIA_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_acacia_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> DARK_OAK_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_dark_oak_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> MANGROVE_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_mangrove_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CRIMSON_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_crimson_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> WARPED_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_warped_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> PALE_OAK_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_pale_oak_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> CHERRY_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_cherry_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_SPRUCE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_spruce",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_BIRCH_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_birch",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_JUNGLE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_jungle",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_ACACIA_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_acacia",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_DARK_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_dark_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_MANGROVE_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_mangrove",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_CRIMSON_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_crimson",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_WARPED_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_warped",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    //? if >= 1.21.6 {
    /*
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_PALE_OAK_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_pale_oak",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    */
    //?}
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_CHERRY_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_cherry",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
        new Item.Properties());
    public static final RegistrySupplier<ChairSimpleBlock> BAMBOO_BAMBOO_CHAIR_SIMPLE = registerWithItem(
        "chair_simple_bamboo_bamboo",
        properties -> new ChairSimpleBlock(properties.mapColor(MapColor.NONE).strength(2.0f).noOcclusion().isRedstoneConductor((a, b, c) -> false).isSuffocating((a, b, c) -> false)),
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
