package com.lucasmellof.broadcastvoice;

import de.maxhenkel.voicechat.api.*;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.MicrophonePacketEvent;
import de.maxhenkel.voicechat.api.packets.StaticSoundPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;

@ForgeVoicechatPlugin
public class BroadcastVoicePlugin implements VoicechatPlugin {

	@Override
	public String getPluginId() {
		return BroadcastVoice.MOD_ID;
	}

	@Override
	public void registerEvents(EventRegistration registration) {
		registration.registerEvent(MicrophonePacketEvent.class, this::onVoicePacket);
	}

	private void onVoicePacket(MicrophonePacketEvent event) {
		// Some sanity checks
		if (event.getSenderConnection() == null) return;
		if (event.getSenderConnection().getPlayer() == null) return;

		if (!(event.getSenderConnection().getPlayer().getPlayer() instanceof ServerPlayer player)) return;

		Group group = event.getSenderConnection().getGroup();
		if (group == null) return;

		if (!player.hasPermissions(BroadcastVoiceConfig.PERMISSION_LEVEL.get())) return;
		if (!group.getName().strip().equals(BroadcastVoiceConfig.BROADCAST_GROUP_NAME.get())) return;

		// We want to cancel the event so that the packet doesn't get sent to the other players
		event.cancel();

		VoicechatServerApi api = event.getVoicechat();
		MinecraftServer server = player.getServer();

		if (server == null) {
			return;
		}

		PlayerList playerManager = server.getPlayerList();

		// Create a static audio packet from the microphone data
		StaticSoundPacket packet = event.getPacket().staticSoundPacketBuilder().build();

		// broadcasting to everyone
		for (ServerPlayer onlinePlayer : playerManager.getPlayers()) {
			// We don't want to loopback the packet to the sender
			if (onlinePlayer.equals(player)) {
				continue;
			}

			VoicechatConnection connection = api.getConnectionOf(onlinePlayer.getUUID());

			// Let's make sure that we have a connection to the player
			if (connection == null) return;

			// Send a static audio packet of the microphone data to the connection of each player
			api.sendStaticSoundPacketTo(connection, packet);
		}
	}

}
