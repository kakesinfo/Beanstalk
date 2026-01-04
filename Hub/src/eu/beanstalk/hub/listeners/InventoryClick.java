package eu.beanstalk.hub.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.portal.Portal;
import eu.beanstalk.hub.Hub;

public class InventoryClick extends AbstractListener
{
	private Hub plugin;	
	
	public InventoryClick(Hub plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();

		if (player != null && item != null && inventory != null)
		{
			Material material = item.getType();

			if (inventory.getName().equalsIgnoreCase("Choose Game"))
			{
				if (material == Material.IRON_HOE)
				{
					player.closeInventory();
					player.teleport(plugin.getMap().QUAKE_LOBBY);
				}
			}

			if (inventory.getName().equalsIgnoreCase("Hub Selector"))
			{
				if (material == Material.EMPTY_MAP || material == Material.MAP)
				{
					player.closeInventory();
					
					String server = "hub-" + item.getItemMeta().getDisplayName().split(" ")[1];
					
					Portal.teleport(player, server);
				}
			}
		}

		event.setCancelled(true);
	}
}
