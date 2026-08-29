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
 * path actually runs (only caught by the {@code fabric/src/gametest/} GameTests actually
 * booting a server - see README.md's "Testing" section - {@code chiseledBuild} alone doesn't
 * exercise this at all, since it only compiles). Wrapping the tab in an ordinary
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
            ModBlocks.OAK_GLASS_TABLE,
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
            ModBlocks.OAK_PINK_STAINED_GLASS_TABLE
        );
    }
}
