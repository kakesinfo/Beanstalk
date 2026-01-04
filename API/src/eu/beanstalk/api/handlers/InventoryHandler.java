package eu.beanstalk.api.handlers;

import java.util.Collection;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.builders.InventoryBuilder;

public class InventoryHandler extends AbstractListener
{

	private HashMap<Object, InventoryBuilder> menus;

	public InventoryHandler()
	{
		this.menus = new HashMap<>();

		this.register();
	}

	public void addMenu(Object key, InventoryBuilder menu)
	{
		menus.put(key, menu);
	}

	public Collection<InventoryBuilder> getMenus(Object key, InventoryBuilder menu)
	{
		return menus.values();
	}

	public InventoryBuilder getMenu(Object key)
	{
		return menus.get(key);
	}

	@EventHandler
	public void onEvent(InventoryDragEvent event)
	{
		Inventory inv = event.getWhoClicked().getOpenInventory().getTopInventory();
		for (InventoryBuilder menu : menus.values())
		{
			if (menu.getInventory().getName().equals(inv.getName()))
			{
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onEvent(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		Inventory inv = player.getOpenInventory().getTopInventory();
		for (InventoryBuilder menu : menus.values())
		{
			if (menu.getInventory().getName().equals(inv.getName()))
			{
				event.setCancelled(true);
				if (event.getCurrentItem() != null)
				{
					menu.click(player, event.getCurrentItem());
				}
			}
		}
	}

}
