package com.lucasmellof.broadcastvoice;

import net.fabricmc.api.ModInitializer;

public class BroadcastVoice implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Constants.LOG.info("BroadcastVoice initialized on Fabric!");
    }
}
