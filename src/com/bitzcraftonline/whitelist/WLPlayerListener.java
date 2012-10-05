package com.bitzcraftonline.whitelist;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class WLPlayerListener implements Listener
{
	private final Whitelist plugin;

	public WLPlayerListener(Whitelist instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		if ( plugin.isWhitelistActive() ) {
			//Check if whitelist.txt needs to be reloaded
			if ( plugin.needReloadWhitelist() ) {
				System.out.println("Whitelist: Executing scheduled whitelist reload.");
				plugin.reloadSettings();
				plugin.resetNeedReloadWhitelist();
			}

			String playerName = event.getPlayer().getName();
			System.out.print("Whitelist: Player " + playerName + " is trying to join...");
			if ( plugin.isOnWhitelist(playerName) ) {
				System.out.println("allow!");
			} else {
				System.out.println("kick!");
				event.disallow(PlayerLoginEvent.Result.KICK_OTHER, plugin.getKickMessage());
			}
		}
	}
}
