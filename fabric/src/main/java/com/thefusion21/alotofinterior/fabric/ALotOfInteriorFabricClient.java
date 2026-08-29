package com.thefusion21.alotofinterior.fabric;

import com.thefusion21.alotofinterior.client.ALotOfInteriorClient;
import net.fabricmc.api.ClientModInitializer;

public class ALotOfInteriorFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ALotOfInteriorClient.init();
    }
}
