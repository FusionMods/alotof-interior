package com.thefusion21.alotofinterior.registry;

import com.thefusion21.alotofinterior.ALotOfInterior;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * Cross-loader item registry, backed by Architectury API's {@link DeferredRegister}
 * (see https://docs.architectury.dev/api/registry) - one {@code register(...)} call
 * here reaches Fabric, Forge and NeoForge alike, with no per-loader copy needed.
 * {@link ModRegistries#init()} calls {@link #ITEMS}{@code .register()} once, to actually
 * bind this to whichever loader ends up running.
 */
public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ALotOfInterior.MOD_ID, Registries.ITEM);

    private ModItems() {
    }

    //? if < 1.21.6 {
    /** Registers a plain {@link Item}. */
    public static RegistrySupplier<Item> registerSimple(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties));
    }

    /** Registers a {@link BlockItem} for a block registered elsewhere - see {@link ModBlocks#registerWithItem}. */
    public static RegistrySupplier<Item> registerBlockItem(String name, Supplier<? extends Block> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }
    //? } else if < 1.21.11 {
    /*
    public static RegistrySupplier<Item> registerSimple(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties.setId(itemId(name))));
    }

    public static RegistrySupplier<Item> registerBlockItem(String name, Supplier<? extends Block> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties.setId(itemId(name))));
    }

    private static net.minecraft.resources.ResourceKey<Item> itemId(String name) {
        return net.minecraft.resources.ResourceKey.create(Registries.ITEM, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(ALotOfInterior.MOD_ID, name));
    }
    */
    //? } else {
    /*
    // 1.21.11 made Item.Properties#setId(ResourceKey<Item>) mandatory - Item's constructor now
    // calls properties.itemIdOrThrow(), so every Item/BlockItem needs its id set up front
    // (Item's registry name isn't known otherwise until DeferredRegister binds it later).
    public static RegistrySupplier<Item> registerSimple(String name, Item.Properties properties) {
        return ITEMS.register(name, () -> new Item(properties.setId(itemId(name))));
    }

    public static RegistrySupplier<Item> registerBlockItem(String name, Supplier<? extends Block> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties.setId(itemId(name))));
    }

    private static net.minecraft.resources.ResourceKey<Item> itemId(String name) {
        return net.minecraft.resources.ResourceKey.create(Registries.ITEM, net.minecraft.resources.Identifier.fromNamespaceAndPath(ALotOfInterior.MOD_ID, name));
    }
    */
    //? }
}
