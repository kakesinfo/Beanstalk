package fr.beanstalk.kingdom.modules.crates.loot;

import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class ItemLoot implements Loot
{
	private ItemStack item;

	public ItemLoot(ItemStack item)
	{
		this.item = item;
	}

	@Override
	public void doAction(Player player)
	{
		player.getInventory().addItem(item);
	}

	public ItemStack getItem()
	{
		return item;
	}	
}
