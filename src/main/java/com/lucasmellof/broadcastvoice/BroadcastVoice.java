package com.lucasmellof.broadcastvoice;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BroadcastVoice.MOD_ID)
public class BroadcastVoice {
    public static final String MOD_ID = "simplevoicechat-broadcast";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BroadcastVoice() {
        // Server side only
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "any", (remote, isServer) -> true));
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BroadcastVoiceConfig.GENERAL_SPEC, MOD_ID + ".toml");
    }
}
