package com.thefusion21.alotofinterior.registry;

import com.thefusion21.alotofinterior.ALotOfInterior;
import com.thefusion21.alotofinterior.entity.DrawerBlockEntity;
import com.thefusion21.alotofinterior.entity.SeatEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

/**
 * Cross-loader entity registry, same {@link DeferredRegister} pattern as
 * {@link ModItems}/{@link ModBlocks}/{@link ModBlockEntities}. {@link #buildType} hits two
 * genuine Minecraft version differences, both already dealt with elsewhere in this
 * codebase so this mirrors their approach rather than duplicating the whole registry per
 * version: 1.21.6 turned {@code EntityType.Builder.build(String)} into
 * {@code build(ResourceKey<EntityType<?>>)} (same boundary as
 * {@link ModBlockEntities#newType}'s {@code BlockEntityType.Builder} change), and 1.21.11
 * renamed {@code ResourceLocation} to {@code Identifier} (same boundary {@link ModSounds#id}
 * documents). The class name itself changes between the last two branches, so - like
 * {@code ModSounds} - it's referenced fully-qualified inline rather than imported.
 */
public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ALotOfInterior.MOD_ID, Registries.ENTITY_TYPE);

    // Deliberately NOT .noSave(): 1.21.6 added a check to Entity#startRiding() that silently
    // refuses to mount a passenger onto a vehicle whose EntityType "can't serialize" (i.e. is
    // built with .noSave()) - found by decompiling startRiding() on both sides of that
    // boundary after sitting silently stopped working on 1.21.6+ with no exception anywhere
    // (the mount attempt just returns false). SeatEntity's own tick() already discards it
    // within a tick or two of losing its passenger regardless, so allowing it to serialize
    // costs nothing in practice - it just means startRiding() actually works again.
    public static final RegistrySupplier<EntityType<SeatEntity>> SEAT = ENTITIES.register("seat",
            () -> buildType("seat", EntityType.Builder.of(SeatEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.01f)
                    .noSummon()));

    private ModEntities() {
    }

    //? if >=1.21.11 {
    /*
    private static <T extends Entity> EntityType<T> buildType(String name, EntityType.Builder<T> builder) {
        return builder.build(ResourceKey.create(Registries.ENTITY_TYPE, net.minecraft.resources.Identifier.fromNamespaceAndPath(ALotOfInterior.MOD_ID, name)));
    }
    */
    //?} else if >=1.21.6 {
    /*
    private static <T extends Entity> EntityType<T> buildType(String name, EntityType.Builder<T> builder) {
        return builder.build(ResourceKey.create(Registries.ENTITY_TYPE, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(ALotOfInterior.MOD_ID, name)));
    }
    */
    //?} else {
    private static <T extends Entity> EntityType<T> buildType(String name, EntityType.Builder<T> builder) {
        return builder.build(name);
    }
    //?}
}
