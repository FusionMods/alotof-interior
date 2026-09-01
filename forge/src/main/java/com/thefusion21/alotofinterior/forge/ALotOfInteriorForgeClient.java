package com.thefusion21.alotofinterior.forge;

import com.thefusion21.alotofinterior.ALotOfInterior;
import com.thefusion21.alotofinterior.client.ALotOfInteriorClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

// value = Dist.CLIENT tells Forge to skip loading this class entirely on a dedicated
// server, so ALotOfInteriorClient (and whatever client-only classes it in turn references)
// never needs to exist there.
@Mod.EventBusSubscriber(modid = ALotOfInterior.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ALotOfInteriorForgeClient {
    private ALotOfInteriorForgeClient() {
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ALotOfInteriorClient.init();
    }
}
