package com.lucasmellof.broadcastvoice;

import net.neoforged.neoforge.common.ModConfigSpec;

public class BroadcastVoiceConfig {
    public static final ModConfigSpec GENERAL_SPEC;

    public static ModConfigSpec.ConfigValue<String> BROADCAST_GROUP_NAME;
    public static ModConfigSpec.IntValue PERMISSION_LEVEL;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("General settings").push("general");
        setup(builder);
        builder.pop();
        GENERAL_SPEC = builder.build();
    }

    private static void setup(ModConfigSpec.Builder builder) {
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
