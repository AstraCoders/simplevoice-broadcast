package com.lucasmellof.broadcastvoice;

import net.minecraftforge.common.ForgeConfigSpec;

public class BroadcastVoiceConfig {
    public static final ForgeConfigSpec GENERAL_SPEC;

    public static ForgeConfigSpec.ConfigValue<String> BROADCAST_GROUP_NAME;
    public static ForgeConfigSpec.IntValue PERMISSION_LEVEL;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("General settings").push("general");
        setup(builder);
        builder.pop();
        GENERAL_SPEC = builder.build();
    }

    private static void setup(ForgeConfigSpec.Builder builder) {
        BROADCAST_GROUP_NAME = builder.comment("The name of the group that will be broadcast").define("broadcast_group_name", "broadcast");
        PERMISSION_LEVEL = builder.comment("The permission level required to use the broadcast command").defineInRange("permission_level", 2, 0, 4);
    }

    public static String getBroadcastGroupName() {
        return BROADCAST_GROUP_NAME.get();
    }

    public static int getPermissionLevel() {
        return PERMISSION_LEVEL.get();
    }
}
