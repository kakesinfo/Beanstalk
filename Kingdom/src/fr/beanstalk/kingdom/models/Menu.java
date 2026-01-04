package fr.beanstalk.kingdom.models;

import org.bukkit.*;
import org.bukkit.inventory.*;

public class Menu
{
	private Inventory _inventory;
	
	public Menu(String name, int row)
	{
		if(row > 6)
			row = 6;
		
		_inventory = Bukkit.createInventory(null, row * 9);
	}
	
	public void withItem(ItemBuilder item, int slot)
	{
		_inventory.setItem(slot, item.create(1));
	}
	
	public void withItem(ItemStack item, int slot)
	{
		_inventory.setItem(slot, item);
	}

	public Inventory getInventory()
	{
		return _inventory;
	}
}
