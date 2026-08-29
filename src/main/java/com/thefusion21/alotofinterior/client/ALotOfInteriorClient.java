package com.thefusion21.alotofinterior.client;

import com.thefusion21.alotofinterior.registry.ModEntities;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
//? if < 26.1 {
import com.thefusion21.alotofinterior.registry.ModBlocks;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
//?}
//? if < 1.21.6 {
import net.minecraft.client.renderer.RenderType;
//?} else if < 26.1 {
/*
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
*/
//?}

@Environment(EnvType.CLIENT)
public final class ALotOfInteriorClient {
    private ALotOfInteriorClient() {
    }

    /** Called once by every loader's client entry point, after that loader's own client setup. */
    public static void init() {
        //? if < 26.1 {
        registerRenderTypes();
        //?}
        registerEntityRenderers();
    }

    // SeatEntity is fully invisible, but every EntityType still needs a renderer
    // registered or the client crashes trying to draw it - unlike registerRenderTypes(),
    // Architectury's EntityRendererRegistry is still present in 26.1+, so this isn't
    // gated to before it.
    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.SEAT, SeatEntityRenderer::new);
    }

    // Before 26.1, Minecraft picks a single render layer per Block for chunk rendering
    // (defaulting to solid) rather than auto-detecting per-quad transparency from the
    // actual texture pixels the way 26.1+ does, so glass/stained-glass tabletops render
    // as opaque wood there unless a mod explicitly registers a transparent layer for
    // them - architectury's RenderTypeRegistry is gone in 26.1+ (nothing left to
    // register), so this whole method only exists pre-26.1. 1.21.6 additionally split
    // its parameter from RenderType (shared with item rendering) to the chunk-only
    // ChunkSectionLayer.
    //? if < 1.21.6 {
    private static void registerRenderTypes() {
        RenderTypeRegistry.register(RenderType.cutout(),
            ModBlocks.OAK_GLASS_TABLE.get(),
            ModBlocks.SPRUCE_GLASS_TABLE.get(),
            ModBlocks.BIRCH_GLASS_TABLE.get(),
            ModBlocks.JUNGLE_GLASS_TABLE.get(),
            ModBlocks.ACACIA_GLASS_TABLE.get(),
            ModBlocks.DARK_OAK_GLASS_TABLE.get(),
            ModBlocks.MANGROVE_GLASS_TABLE.get(),
            ModBlocks.CRIMSON_GLASS_TABLE.get(),
            ModBlocks.WARPED_GLASS_TABLE.get()
        );
        RenderTypeRegistry.register(
                RenderType.translucent(),
                ModBlocks.OAK_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_TINTED_GLASS_TABLE.get(),

                ModBlocks.SPRUCE_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_TINTED_GLASS_TABLE.get(),

                ModBlocks.BIRCH_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_TINTED_GLASS_TABLE.get(),

                ModBlocks.JUNGLE_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_TINTED_GLASS_TABLE.get(),

                ModBlocks.ACACIA_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_TINTED_GLASS_TABLE.get(),

                ModBlocks.DARK_OAK_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_TINTED_GLASS_TABLE.get(),

                ModBlocks.MANGROVE_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_TINTED_GLASS_TABLE.get(),

                ModBlocks.CRIMSON_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_TINTED_GLASS_TABLE.get(),

                ModBlocks.WARPED_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_TINTED_GLASS_TABLE.get()
        );
    }
    //?} else if < 26.1 {
    /*
    private static void registerRenderTypes() {
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, 
            ModBlocks.OAK_GLASS_TABLE.get(),
            ModBlocks.SPRUCE_GLASS_TABLE.get(),
            ModBlocks.BIRCH_GLASS_TABLE.get(),
            ModBlocks.JUNGLE_GLASS_TABLE.get(),
            ModBlocks.ACACIA_GLASS_TABLE.get(),
            ModBlocks.DARK_OAK_GLASS_TABLE.get(),
            ModBlocks.MANGROVE_GLASS_TABLE.get(),
            ModBlocks.CRIMSON_GLASS_TABLE.get(),
            ModBlocks.WARPED_GLASS_TABLE.get()
        );
        RenderTypeRegistry.register(
                ChunkSectionLayer.TRANSLUCENT,
                ModBlocks.OAK_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.OAK_TINTED_GLASS_TABLE.get(),

                ModBlocks.SPRUCE_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.SPRUCE_TINTED_GLASS_TABLE.get(),

                ModBlocks.BIRCH_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.BIRCH_TINTED_GLASS_TABLE.get(),

                ModBlocks.JUNGLE_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.JUNGLE_TINTED_GLASS_TABLE.get(),

                ModBlocks.ACACIA_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.ACACIA_TINTED_GLASS_TABLE.get(),

                ModBlocks.DARK_OAK_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.DARK_OAK_TINTED_GLASS_TABLE.get(),

                ModBlocks.MANGROVE_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.MANGROVE_TINTED_GLASS_TABLE.get(),

                ModBlocks.CRIMSON_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.CRIMSON_TINTED_GLASS_TABLE.get(),

                ModBlocks.WARPED_WHITE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_LIGHT_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_GRAY_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_BLACK_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_BROWN_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_RED_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_ORANGE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_YELLOW_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_LIME_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_GREEN_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_CYAN_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_LIGHT_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_BLUE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_PURPLE_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_MAGENTA_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_PINK_STAINED_GLASS_TABLE.get(),
                ModBlocks.WARPED_TINTED_GLASS_TABLE.get()
        );
    }
    */
    //?}
}
