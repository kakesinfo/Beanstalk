package eu.beanstalk.api.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import eu.beanstalk.api.abstracts.AbstractListener;

public class BlockBreak extends AbstractListener
{
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		event.getPlayer().sendMessage("&c&lHey! &7Sorry, but you can't break that block here.".replace("&", "§"));
		
		event.setCancelled(true);
	}
}
