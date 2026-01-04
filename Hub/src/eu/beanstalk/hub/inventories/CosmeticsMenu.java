package eu.beanstalk.hub.inventories;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.beanstalk.api.builders.InventoryBuilder;

public class CosmeticsMenu extends InventoryBuilder
{

	public CosmeticsMenu()
	{
		super("Cosmetics", 3);
	}

	@Override
	public void click(Player player, ItemStack item)
	{
		
	}

}
