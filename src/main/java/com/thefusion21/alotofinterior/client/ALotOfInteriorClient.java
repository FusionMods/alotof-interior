package com.thefusion21.alotofinterior.client;

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
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.OAK_GLASS_TABLE.get());
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
                ModBlocks.OAK_PINK_STAINED_GLASS_TABLE.get());
    }
    //?} else if < 26.1 {
    /*
    private static void registerRenderTypes() {
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT, ModBlocks.OAK_GLASS_TABLE.get());
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
                ModBlocks.OAK_PINK_STAINED_GLASS_TABLE.get());
    }
    */
    //?}
}
