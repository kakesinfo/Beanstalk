package eu.beanstalk.quake.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import eu.beanstalk.quake.Quake;

public class PlayerDeath implements Listener
{
	private Quake plugin;

	public PlayerDeath(Quake plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onEvent(PlayerDeathEvent event)
	{
		Player player = event.getEntity();

		
		player.spigot().respawn();
	}

	@EventHandler
	public void onEvent(PlayerRespawnEvent event)
	{
//		Player player = event.getPlayer();
	}

	public Quake getPlugin()
	{
		return plugin;
	}
}
