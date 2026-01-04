package eu.beanstalk.api.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import eu.beanstalk.api.abstracts.AbstractListener;

public class PlayerHandChange extends AbstractListener
{

	@EventHandler
	public void onPlayerHandChange(PlayerSwapHandItemsEvent event)
	{
		event.setCancelled(true);
	}

}
