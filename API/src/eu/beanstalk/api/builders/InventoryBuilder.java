package eu.beanstalk.api.builders;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryBuilder
{
	private Inventory inventory;

	public InventoryBuilder(String displayName, int row)
	{
		inventory = Bukkit.createInventory(null, row * 9, displayName);
	}

	public InventoryBuilder setItem(int slot, ItemBuilder item)
	{
		inventory.setItem(slot, item.build());

		return this;
	}

	public InventoryBuilder addItem(ItemBuilder item)
	{
		inventory.addItem(item.build());

		return this;
	}

	public Inventory getInventory()
	{
		return inventory;
	}

	public Inventory build()
	{
		return inventory;
	}

	public void open(Player player)
	{
		player.openInventory(inventory);
	}
	
	public abstract  void click(Player player, ItemStack item);
}
