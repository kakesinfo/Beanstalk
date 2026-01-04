package eu.beanstalk.hub.listeners;

import static org.bukkit.Material.*;
import static org.bukkit.event.block.Action.*;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.hub.Hub;
import eu.beanstalk.hub.inventories.HubSelectorMenu;

public class PlayerInteract extends AbstractListener
{
	private Hub plugin;

	public PlayerInteract(Hub plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();

		if ((action == Action.RIGHT_CLICK_AIR || action == RIGHT_CLICK_BLOCK) && item != null)
		{
			Material material = item.getType();

			if (material == COMPASS)
			{
				plugin.getInventories().getMenu(0).open(player);
			}

			if (material == Material.CHEST)
			{
				plugin.getInventories().getMenu(1).open(player);
			}

			if (material == Material.BOOK)
			{
				new HubSelectorMenu(plugin).open(player);
			}
		}
		
		if (action != Action.LEFT_CLICK_BLOCK)
		{
			event.setCancelled(true);
		}
		
		if (action == Action.RIGHT_CLICK_BLOCK)
		{
			event.setCancelled(true);
		}
	}

}
