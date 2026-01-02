package com.lucasmellof.broadcastvoice;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Constants.MOD_ID)
public class BroadcastVoice {

    public BroadcastVoice() {
        // Server side only - allow clients without the mod to connect
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, 
                () -> new IExtensionPoint.DisplayTest(() -> "any", (remote, isServer) -> true));
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BroadcastVoiceConfig.GENERAL_SPEC, Constants.MOD_ID + ".toml");
        
        Constants.LOG.info("BroadcastVoice initialized on Forge!");
    }
}
