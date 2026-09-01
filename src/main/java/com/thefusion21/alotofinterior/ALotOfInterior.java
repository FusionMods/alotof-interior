package com.thefusion21.alotofinterior;

import com.thefusion21.alotofinterior.registry.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point shared by every loader (fabric/forge/neoforge) for this
 * Minecraft version - see the fabric/forge/neoforge projects' own entry
 * point classes for how each loader calls into this class.
 *
 * Real content (items, blocks, registries, ...) belongs in the {@code registry}/
 * {@code block} packages next to this class, using Architectury API's cross-loader
 * registry/event/network abstractions (https://docs.architectury.dev/) so it doesn't
 * need per-loader copies - see {@link ModRegistries} for the pattern. Where an actual
 * Minecraft/Architectury API genuinely changed between 1.20.1, 1.21.1 and 26.2 (as
 * opposed to a loader difference, which Architectury API already handles), reach for a
 * Stonecutter {@code //? if <mc version>} comment instead (e.g. {@code //? if <1.21 {} else {}}) -
 * see https://stonecutter.kikugie.dev/ for the full syntax) - {@link com.thefusion21.alotofinterior.registry.ModSounds}
 * and {@link com.thefusion21.alotofinterior.registry.ModBlocks} both do this for real,
 * narrowly-scoped API changes rather than duplicating whole files.
 */
public final class ALotOfInterior {
    // Keep this in sync with `modId` in gradle.properties.
    public static final String MOD_ID = "alotofinterior";

    public static final Logger LOGGER = LoggerFactory.getLogger("[A Lot Of] Interior");

    private ALotOfInterior() {
    }

    /** Called once by every loader's entry point, after that loader's own setup. */
    public static void init() {
        ModRegistries.init();
        LOGGER.info("[A Lot Of] Interior ({}) initialized", MOD_ID);
    }
}
