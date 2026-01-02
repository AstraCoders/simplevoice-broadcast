package com.lucasmellof.broadcastvoice;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Constants.MOD_ID)
public class BroadcastVoice {

    public BroadcastVoice(IEventBus eventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, BroadcastVoiceConfig.GENERAL_SPEC, Constants.MOD_ID + ".toml");
        
        Constants.LOG.info("BroadcastVoice initialized on NeoForge!");
    }
}
