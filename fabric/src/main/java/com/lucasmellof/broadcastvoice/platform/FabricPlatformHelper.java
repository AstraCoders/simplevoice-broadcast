package com.lucasmellof.broadcastvoice.platform;

import com.lucasmellof.broadcastvoice.BroadcastVoiceConfig;
import com.lucasmellof.broadcastvoice.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

    static {
        BroadcastVoiceConfig.load();
    }

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public String getBroadcastGroupName() {
        return BroadcastVoiceConfig.getBroadcastGroupName();
    }

    @Override
    public int getPermissionLevel() {
        return BroadcastVoiceConfig.getPermissionLevel();
    }
}
