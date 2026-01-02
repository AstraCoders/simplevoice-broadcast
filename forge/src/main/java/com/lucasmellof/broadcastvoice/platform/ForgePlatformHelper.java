package com.lucasmellof.broadcastvoice.platform;

import com.lucasmellof.broadcastvoice.BroadcastVoiceConfig;
import com.lucasmellof.broadcastvoice.platform.services.IPlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
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
