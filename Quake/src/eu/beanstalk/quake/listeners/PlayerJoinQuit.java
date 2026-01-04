package eu.beanstalk.quake.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.portal.Portal;
import eu.beanstalk.quake.Quake;
import eu.beanstalk.quake.railguns.Railgun;

public class PlayerJoinQuit extends AbstractListener
{
	private Quake plugin;

	public PlayerJoinQuit(Quake plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		
		if (plugin.getArena().isRunning())
		{ 
			event.setJoinMessage("");
			
			Portal.teleport(player, "Hub-1");
			return;
		}
		
		player.setExp(0);
		player.setLevel(0);		
		
		event.setJoinMessage(Quake.PREFIX + "joined !");
		
		Railgun.BASIC.shoot(player);
		
		if (plugin.getArena().shouldStart())
		{
			plugin.getArena().load();
		}
	}

	public Quake getPlugin()
	{
		return plugin;
	}

}
