package eu.beanstalk.hub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.hub.Hub;

public class PlayerStarve extends AbstractListener
{
	private Hub plugin;	
	
	public PlayerStarve(Hub plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerStarve(FoodLevelChangeEvent event)
	{
		event.setFoodLevel(20);
	}
	
	public Hub getPlugin()
	{
		return plugin;
	}
}
