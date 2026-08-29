package com.thefusion21.alotofinterior.forge;

import com.thefusion21.alotofinterior.ALotOfInterior;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ALotOfInterior.MOD_ID)
public class ALotOfInteriorForge {
    public ALotOfInteriorForge() {
        // Architectury's DeferredRegister needs to know which IEventBus belongs to
        // this mod before ModRegistries.init() below uses it - on Forge, unlike
        // Fabric/NeoForge, that mapping isn't automatic, so skipping this throws
        // "Can't get event bus for mod 'alotofinterior' because it was not registered!"
        // the moment any registry tries to bind (see docs.architectury.dev/api/registry).
        EventBuses.registerModEventBus(ALotOfInterior.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ALotOfInterior.init();
    }
}
