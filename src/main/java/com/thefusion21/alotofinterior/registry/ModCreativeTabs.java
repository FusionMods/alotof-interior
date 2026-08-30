package com.thefusion21.alotofinterior.registry;

import com.thefusion21.alotofinterior.ALotOfInterior;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * Cross-loader creative tab. Same {@link DeferredRegister} pattern as
 * {@link ModItems}/{@link ModBlocks} - not the shortcut it first looks like: Architectury
 * API's {@link CreativeTabRegistry#create}/{@code #appendBuiltin} pairing (a natural first
 * reach, since {@code create} looks like it should register the tab itself) turned out to be
 * for adding entries to an *existing, already-registered* tab - either a vanilla one or one
 * of yours registered some other way - not for registering a new one; calling
 * {@code appendBuiltin} on a tab {@code create} just built throws
 * {@code IllegalArgumentException: Builtin tab ... is not registered!} the moment any code
 * path actually runs (only caught by actually booting a server - {@code chiseledBuild} alone
 * doesn't exercise this at all, since it only compiles). Wrapping the tab in an ordinary
 * {@code DeferredRegister<CreativeModeTab>} sidesteps the question entirely: it handles
 * per-loader registration timing the same proven way it does for every other content type
 * here, and {@link CreativeTabRegistry#append(dev.architectury.registry.registries.DeferredSupplier, net.minecraft.world.level.ItemLike...)}
 * accepts a {@code RegistrySupplier} directly ({@code RegistrySupplier} extends Architectury's
 * {@code DeferredSupplier}).
 */
public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(ALotOfInterior.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> ALOTOFINTERIOR_TAB = TABS.register("alotofinterior_tab", () ->
            CreativeTabRegistry.create(
                    Component.translatable("itemGroup." + ALotOfInterior.MOD_ID),
                    () -> new ItemStack(ModBlocks.OAK_OAK_TABLE.get().asItem())));

    private ModCreativeTabs() {
    }

    /**
     * Called from {@link ModRegistries#init()}, after every other {@code Mod*} registry has
     * bulk-registered. On Fabric that means the blocks below are already resolvable, but on
     * Forge/NeoForge {@code DeferredRegister.register()} only schedules a {@code RegisterEvent}
     * listener - actual registry population happens later, well after this method (and the
     * {@code @Mod} constructor calling it) returns. Calling {@code .get()} here would throw
     * {@code NullPointerException: Registry Object not present} on those loaders, so this passes
     * the {@code RegistrySupplier}s themselves through {@link CreativeTabRegistry}'s generic
     * {@code append(DeferredSupplier, Supplier...)} overload and lets it resolve them lazily,
     * once the tab's contents are actually needed.
     */
    public static void init() {
        TABS.register();
        CreativeTabRegistry.append(ALOTOFINTERIOR_TAB,
            ModBlocks.OAK_OAK_TABLE,
            ModBlocks.OAK_SPRUCE_TABLE,
            ModBlocks.OAK_BIRCH_TABLE,
            ModBlocks.OAK_JUNGLE_TABLE,
            ModBlocks.OAK_ACACIA_TABLE,
            ModBlocks.OAK_DARK_OAK_TABLE,
            ModBlocks.OAK_MANGROVE_TABLE,
            ModBlocks.OAK_CRIMSON_TABLE,
            ModBlocks.OAK_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.OAK_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.OAK_CHERRY_TABLE,
            ModBlocks.OAK_BAMBOO_TABLE,
            ModBlocks.OAK_GLASS_TABLE,
            ModBlocks.OAK_TINTED_GLASS_TABLE,
            ModBlocks.OAK_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.OAK_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.OAK_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.OAK_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.OAK_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.OAK_RED_STAINED_GLASS_TABLE,
            ModBlocks.OAK_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.OAK_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.OAK_LIME_STAINED_GLASS_TABLE,
            ModBlocks.OAK_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.OAK_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.OAK_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.OAK_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.OAK_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.OAK_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.OAK_PINK_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_OAK_TABLE,
            ModBlocks.SPRUCE_SPRUCE_TABLE,
            ModBlocks.SPRUCE_BIRCH_TABLE,
            ModBlocks.SPRUCE_JUNGLE_TABLE,
            ModBlocks.SPRUCE_ACACIA_TABLE,
            ModBlocks.SPRUCE_DARK_OAK_TABLE,
            ModBlocks.SPRUCE_MANGROVE_TABLE,
            ModBlocks.SPRUCE_CRIMSON_TABLE,
            ModBlocks.SPRUCE_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.SPRUCE_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.SPRUCE_CHERRY_TABLE,
            ModBlocks.SPRUCE_BAMBOO_TABLE,
            ModBlocks.SPRUCE_GLASS_TABLE,
            ModBlocks.SPRUCE_TINTED_GLASS_TABLE,
            ModBlocks.SPRUCE_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_RED_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_LIME_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.SPRUCE_PINK_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_OAK_TABLE,
            ModBlocks.BIRCH_SPRUCE_TABLE,
            ModBlocks.BIRCH_BIRCH_TABLE,
            ModBlocks.BIRCH_JUNGLE_TABLE,
            ModBlocks.BIRCH_ACACIA_TABLE,
            ModBlocks.BIRCH_DARK_OAK_TABLE,
            ModBlocks.BIRCH_MANGROVE_TABLE,
            ModBlocks.BIRCH_CRIMSON_TABLE,
            ModBlocks.BIRCH_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.BIRCH_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.BIRCH_CHERRY_TABLE,
            ModBlocks.BIRCH_BAMBOO_TABLE,
            ModBlocks.BIRCH_GLASS_TABLE,
            ModBlocks.BIRCH_TINTED_GLASS_TABLE,
            ModBlocks.BIRCH_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_RED_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_LIME_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.BIRCH_PINK_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_OAK_TABLE,
            ModBlocks.JUNGLE_SPRUCE_TABLE,
            ModBlocks.JUNGLE_BIRCH_TABLE,
            ModBlocks.JUNGLE_JUNGLE_TABLE,
            ModBlocks.JUNGLE_ACACIA_TABLE,
            ModBlocks.JUNGLE_DARK_OAK_TABLE,
            ModBlocks.JUNGLE_MANGROVE_TABLE,
            ModBlocks.JUNGLE_CRIMSON_TABLE,
            ModBlocks.JUNGLE_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.JUNGLE_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.JUNGLE_CHERRY_TABLE,
            ModBlocks.JUNGLE_BAMBOO_TABLE,
            ModBlocks.JUNGLE_GLASS_TABLE,
            ModBlocks.JUNGLE_TINTED_GLASS_TABLE,
            ModBlocks.JUNGLE_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_RED_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_LIME_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.JUNGLE_PINK_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_OAK_TABLE,
            ModBlocks.ACACIA_SPRUCE_TABLE,
            ModBlocks.ACACIA_BIRCH_TABLE,
            ModBlocks.ACACIA_JUNGLE_TABLE,
            ModBlocks.ACACIA_ACACIA_TABLE,
            ModBlocks.ACACIA_DARK_OAK_TABLE,
            ModBlocks.ACACIA_MANGROVE_TABLE,
            ModBlocks.ACACIA_CRIMSON_TABLE,
            ModBlocks.ACACIA_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.ACACIA_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.ACACIA_CHERRY_TABLE,
            ModBlocks.ACACIA_BAMBOO_TABLE,
            ModBlocks.ACACIA_GLASS_TABLE,
            ModBlocks.ACACIA_TINTED_GLASS_TABLE,
            ModBlocks.ACACIA_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_RED_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_LIME_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.ACACIA_PINK_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_OAK_TABLE,
            ModBlocks.DARK_OAK_SPRUCE_TABLE,
            ModBlocks.DARK_OAK_BIRCH_TABLE,
            ModBlocks.DARK_OAK_JUNGLE_TABLE,
            ModBlocks.DARK_OAK_ACACIA_TABLE,
            ModBlocks.DARK_OAK_DARK_OAK_TABLE,
            ModBlocks.DARK_OAK_MANGROVE_TABLE,
            ModBlocks.DARK_OAK_CRIMSON_TABLE,
            ModBlocks.DARK_OAK_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.DARK_OAK_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.DARK_OAK_CHERRY_TABLE,
            ModBlocks.DARK_OAK_BAMBOO_TABLE,
            ModBlocks.DARK_OAK_GLASS_TABLE,
            ModBlocks.DARK_OAK_TINTED_GLASS_TABLE,
            ModBlocks.DARK_OAK_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_RED_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_LIME_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.DARK_OAK_PINK_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_OAK_TABLE,
            ModBlocks.MANGROVE_SPRUCE_TABLE,
            ModBlocks.MANGROVE_BIRCH_TABLE,
            ModBlocks.MANGROVE_JUNGLE_TABLE,
            ModBlocks.MANGROVE_ACACIA_TABLE,
            ModBlocks.MANGROVE_DARK_OAK_TABLE,
            ModBlocks.MANGROVE_MANGROVE_TABLE,
            ModBlocks.MANGROVE_CRIMSON_TABLE,
            ModBlocks.MANGROVE_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.MANGROVE_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.MANGROVE_CHERRY_TABLE,
            ModBlocks.MANGROVE_BAMBOO_TABLE,
            ModBlocks.MANGROVE_GLASS_TABLE,
            ModBlocks.MANGROVE_TINTED_GLASS_TABLE,
            ModBlocks.MANGROVE_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_RED_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_LIME_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.MANGROVE_PINK_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_OAK_TABLE,
            ModBlocks.CRIMSON_SPRUCE_TABLE,
            ModBlocks.CRIMSON_BIRCH_TABLE,
            ModBlocks.CRIMSON_JUNGLE_TABLE,
            ModBlocks.CRIMSON_ACACIA_TABLE,
            ModBlocks.CRIMSON_DARK_OAK_TABLE,
            ModBlocks.CRIMSON_MANGROVE_TABLE,
            ModBlocks.CRIMSON_CRIMSON_TABLE,
            ModBlocks.CRIMSON_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.CRIMSON_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.CRIMSON_CHERRY_TABLE,
            ModBlocks.CRIMSON_BAMBOO_TABLE,
            ModBlocks.CRIMSON_GLASS_TABLE,
            ModBlocks.CRIMSON_TINTED_GLASS_TABLE,
            ModBlocks.CRIMSON_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_RED_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_LIME_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.CRIMSON_PINK_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_OAK_TABLE,
            ModBlocks.WARPED_SPRUCE_TABLE,
            ModBlocks.WARPED_BIRCH_TABLE,
            ModBlocks.WARPED_JUNGLE_TABLE,
            ModBlocks.WARPED_ACACIA_TABLE,
            ModBlocks.WARPED_DARK_OAK_TABLE,
            ModBlocks.WARPED_MANGROVE_TABLE,
            ModBlocks.WARPED_CRIMSON_TABLE,
            ModBlocks.WARPED_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.WARPED_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.WARPED_CHERRY_TABLE,
            ModBlocks.WARPED_BAMBOO_TABLE,
            ModBlocks.WARPED_GLASS_TABLE,
            ModBlocks.WARPED_TINTED_GLASS_TABLE,
            ModBlocks.WARPED_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_RED_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_LIME_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.WARPED_PINK_STAINED_GLASS_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.PALE_OAK_OAK_TABLE,
            ModBlocks.PALE_OAK_SPRUCE_TABLE,
            ModBlocks.PALE_OAK_BIRCH_TABLE,
            ModBlocks.PALE_OAK_JUNGLE_TABLE,
            ModBlocks.PALE_OAK_ACACIA_TABLE,
            ModBlocks.PALE_OAK_DARK_OAK_TABLE,
            ModBlocks.PALE_OAK_MANGROVE_TABLE,
            ModBlocks.PALE_OAK_CRIMSON_TABLE,
            ModBlocks.PALE_OAK_WARPED_TABLE,
            ModBlocks.PALE_OAK_PALE_OAK_TABLE,
            ModBlocks.PALE_OAK_CHERRY_TABLE,
            ModBlocks.PALE_OAK_BAMBOO_TABLE,
            ModBlocks.PALE_OAK_GLASS_TABLE,
            ModBlocks.PALE_OAK_TINTED_GLASS_TABLE,
            ModBlocks.PALE_OAK_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_RED_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_LIME_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.PALE_OAK_PINK_STAINED_GLASS_TABLE,
        */
        //?}
            ModBlocks.CHERRY_OAK_TABLE,
            ModBlocks.CHERRY_SPRUCE_TABLE,
            ModBlocks.CHERRY_BIRCH_TABLE,
            ModBlocks.CHERRY_JUNGLE_TABLE,
            ModBlocks.CHERRY_ACACIA_TABLE,
            ModBlocks.CHERRY_DARK_OAK_TABLE,
            ModBlocks.CHERRY_MANGROVE_TABLE,
            ModBlocks.CHERRY_CRIMSON_TABLE,
            ModBlocks.CHERRY_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.CHERRY_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.CHERRY_CHERRY_TABLE,
            ModBlocks.CHERRY_BAMBOO_TABLE,
            ModBlocks.CHERRY_GLASS_TABLE,
            ModBlocks.CHERRY_TINTED_GLASS_TABLE,
            ModBlocks.CHERRY_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_RED_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_LIME_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.CHERRY_PINK_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_OAK_TABLE,
            ModBlocks.BAMBOO_SPRUCE_TABLE,
            ModBlocks.BAMBOO_BIRCH_TABLE,
            ModBlocks.BAMBOO_JUNGLE_TABLE,
            ModBlocks.BAMBOO_ACACIA_TABLE,
            ModBlocks.BAMBOO_DARK_OAK_TABLE,
            ModBlocks.BAMBOO_MANGROVE_TABLE,
            ModBlocks.BAMBOO_CRIMSON_TABLE,
            ModBlocks.BAMBOO_WARPED_TABLE,
        //? if >= 1.21.6 {
        /*
            ModBlocks.BAMBOO_PALE_OAK_TABLE,
        */
        //?}
            ModBlocks.BAMBOO_CHERRY_TABLE,
            ModBlocks.BAMBOO_BAMBOO_TABLE,
            ModBlocks.BAMBOO_GLASS_TABLE,
            ModBlocks.BAMBOO_TINTED_GLASS_TABLE,
            ModBlocks.BAMBOO_WHITE_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_LIGHT_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_GRAY_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_BLACK_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_BROWN_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_RED_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_ORANGE_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_YELLOW_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_LIME_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_GREEN_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_CYAN_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_LIGHT_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_BLUE_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_PURPLE_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_MAGENTA_STAINED_GLASS_TABLE,
            ModBlocks.BAMBOO_PINK_STAINED_GLASS_TABLE
        );
        CreativeTabRegistry.append(ALOTOFINTERIOR_TAB,
            ModBlocks.OAK_OAK_SIMPLE_CHAIR,
            ModBlocks.OAK_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.OAK_BIRCH_SIMPLE_CHAIR,
            ModBlocks.OAK_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.OAK_ACACIA_SIMPLE_CHAIR,
            ModBlocks.OAK_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.OAK_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.OAK_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.OAK_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.OAK_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.OAK_CHERRY_SIMPLE_CHAIR,
            ModBlocks.OAK_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_OAK_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_BIRCH_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_ACACIA_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.SPRUCE_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.SPRUCE_CHERRY_SIMPLE_CHAIR,
            ModBlocks.SPRUCE_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.BIRCH_OAK_SIMPLE_CHAIR,
            ModBlocks.BIRCH_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.BIRCH_BIRCH_SIMPLE_CHAIR,
            ModBlocks.BIRCH_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.BIRCH_ACACIA_SIMPLE_CHAIR,
            ModBlocks.BIRCH_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.BIRCH_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.BIRCH_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.BIRCH_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.BIRCH_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.BIRCH_CHERRY_SIMPLE_CHAIR,
            ModBlocks.BIRCH_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_OAK_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_BIRCH_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_ACACIA_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.JUNGLE_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.JUNGLE_CHERRY_SIMPLE_CHAIR,
            ModBlocks.JUNGLE_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.ACACIA_OAK_SIMPLE_CHAIR,
            ModBlocks.ACACIA_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.ACACIA_BIRCH_SIMPLE_CHAIR,
            ModBlocks.ACACIA_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.ACACIA_ACACIA_SIMPLE_CHAIR,
            ModBlocks.ACACIA_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.ACACIA_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.ACACIA_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.ACACIA_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.ACACIA_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.ACACIA_CHERRY_SIMPLE_CHAIR,
            ModBlocks.ACACIA_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_OAK_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_BIRCH_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_ACACIA_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.DARK_OAK_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.DARK_OAK_CHERRY_SIMPLE_CHAIR,
            ModBlocks.DARK_OAK_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_OAK_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_BIRCH_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_ACACIA_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.MANGROVE_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.MANGROVE_CHERRY_SIMPLE_CHAIR,
            ModBlocks.MANGROVE_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_OAK_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_BIRCH_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_ACACIA_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.CRIMSON_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.CRIMSON_CHERRY_SIMPLE_CHAIR,
            ModBlocks.CRIMSON_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.WARPED_OAK_SIMPLE_CHAIR,
            ModBlocks.WARPED_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.WARPED_BIRCH_SIMPLE_CHAIR,
            ModBlocks.WARPED_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.WARPED_ACACIA_SIMPLE_CHAIR,
            ModBlocks.WARPED_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.WARPED_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.WARPED_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.WARPED_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.WARPED_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.WARPED_CHERRY_SIMPLE_CHAIR,
            ModBlocks.WARPED_BAMBOO_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.PALE_OAK_OAK_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_BIRCH_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_ACACIA_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_WARPED_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_PALE_OAK_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_CHERRY_SIMPLE_CHAIR,
            ModBlocks.PALE_OAK_BAMBOO_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.CHERRY_OAK_SIMPLE_CHAIR,
            ModBlocks.CHERRY_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.CHERRY_BIRCH_SIMPLE_CHAIR,
            ModBlocks.CHERRY_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.CHERRY_ACACIA_SIMPLE_CHAIR,
            ModBlocks.CHERRY_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.CHERRY_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.CHERRY_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.CHERRY_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.CHERRY_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.CHERRY_CHERRY_SIMPLE_CHAIR,
            ModBlocks.CHERRY_BAMBOO_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_OAK_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_SPRUCE_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_BIRCH_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_JUNGLE_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_ACACIA_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_DARK_OAK_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_MANGROVE_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_CRIMSON_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_WARPED_SIMPLE_CHAIR,
        //? if >= 1.21.6 {
        /*
            ModBlocks.BAMBOO_PALE_OAK_SIMPLE_CHAIR,
        */
        //?}
            ModBlocks.BAMBOO_CHERRY_SIMPLE_CHAIR,
            ModBlocks.BAMBOO_BAMBOO_SIMPLE_CHAIR
        );
    }
}
