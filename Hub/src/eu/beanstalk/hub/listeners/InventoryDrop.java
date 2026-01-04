package eu.beanstalk.hub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.hub.Hub;

public class InventoryDrop extends AbstractListener
{
	private Hub plugin;	
	
	public InventoryDrop(Hub plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryDrop(PlayerDropItemEvent event)
	{
		event.setCancelled(true);
	}

	public Hub getPlugin()
	{
		return plugin;
	}
}
