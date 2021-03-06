package io.github.lxgaming.discordbot.listeners;

import io.github.lxgaming.discordbot.DiscordBot;
import io.github.lxgaming.discordbot.util.Date;
import io.github.lxgaming.discordbot.util.MessageSender;
import net.dv8tion.jda.events.DisconnectEvent;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.ReconnectedEvent;
import net.dv8tion.jda.events.ShutdownEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {
	
	private String botTextChannel = DiscordBot.config.getString("BotChannel");
	
	@Override
	public void onDisconnect(DisconnectEvent event) {
		System.out.println("DiscordBot Disconnected!");
		return;
	}
	
	@Override
	public void onReady(ReadyEvent event) {
		if (botTextChannel.equals("") || botTextChannel.contains("[a-zA-Z]+") == true) {
			System.out.println("Please make sure you are using the Channel ID in the config");
			System.out.println("List of available TextChannels " + event.getJDA().getTextChannels());
			System.exit(0);
		}
		MessageSender.sendMessage("``Time:`` **" + Date.getTime() + "** ``DiscordBot`` **Connected!**");
		System.out.println("DiscordBot Connected!");
		return;
	}
	
	@Override
	public void onReconnect(ReconnectedEvent event) {
		System.out.println("DiscordBot Reconnected!");
		return;
	}
	
	@Override
	public void onShutdown(ShutdownEvent event) {
		System.out.println("DiscordBot Shutdown!");
		return;
	}
}