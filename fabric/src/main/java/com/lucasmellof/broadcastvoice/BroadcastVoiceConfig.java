package com.lucasmellof.broadcastvoice;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class BroadcastVoiceConfig {
    private static final String CONFIG_FILE = "broadcastvoice.properties";
    private static final Properties PROPERTIES = new Properties();

    private static String broadcastGroupName = "broadcast";
    private static int permissionLevel = 2;

    public static void load() {
        Path configDir = FabricLoader.getInstance().getConfigDir();
        Path configFile = configDir.resolve(CONFIG_FILE);

        if (Files.exists(configFile)) {
            try (InputStream is = Files.newInputStream(configFile)) {
                PROPERTIES.load(is);
                broadcastGroupName = PROPERTIES.getProperty("broadcast_group_name", "broadcast");
                permissionLevel = Integer.parseInt(PROPERTIES.getProperty("permission_level", "2"));
            } catch (IOException e) {
                Constants.LOG.error("Failed to load config", e);
            }
        } else {
            // Create default config
            PROPERTIES.setProperty("broadcast_group_name", broadcastGroupName);
            PROPERTIES.setProperty("permission_level", String.valueOf(permissionLevel));
            try (OutputStream os = Files.newOutputStream(configFile)) {
                PROPERTIES.store(os, "BroadcastVoice Configuration");
            } catch (IOException e) {
                Constants.LOG.error("Failed to save config", e);
            }
        }
    }

    public static String getBroadcastGroupName() {
        return broadcastGroupName;
    }

    public static int getPermissionLevel() {
        return permissionLevel;
    }
}
