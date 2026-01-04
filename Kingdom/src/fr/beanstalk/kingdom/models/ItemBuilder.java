package fr.beanstalk.kingdom.models;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class ItemBuilder
{
	private ItemStack _item;
	
	private ItemMeta _meta;
	
	private List<String> _lore;

	public ItemBuilder(Material material)
	{
		_item = new ItemStack(material);
		_meta = _item.getItemMeta();
		
		_lore = new ArrayList<>();
	}	
	
	public ItemBuilder withName(String name)
	{
		_meta.setDisplayName(name.replace("&", "§"));
		
		return this;
	}	
	
	public ItemBuilder withLore(String line)
	{
		_lore.add(line.replace("&", "§"));
		
		return this;
	}
	
	public ItemBuilder withLore(String[] lines)
	{
		for(String line : lines)
			withLore(line);
		
		return this;
	}
	
	public ItemBuilder withDurability(short durability)
	{
		_item.setDurability(durability);
		
		return this;
	}	
	
	public void give(Player player)
	{
		this.give(player, 1);
	}
	
	public void give(Player player, int amount)
	{
		ItemStack stack = create(amount);
		Inventory inventory = player.getInventory();
		inventory.addItem(stack);
		player.updateInventory();
	}
	
	public ItemStack create(int amount)
	{		
		_meta.setLore(_lore);
		_item.setItemMeta(_meta);
		_item.setAmount(amount);
		
		return _item;
	}
	
	public ItemMeta getMeta()
	{
		return _meta;
	}

	public List<String> getLore()
	{
		return _lore;
	}	
}
