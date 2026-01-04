package fr.beanstalk.kingdom.models;

import org.bukkit.*;

@SuppressWarnings("deprecation")
public class CraftBuilder
{
	private Material _itemToCraft;
	private int[] _items;
	
	public CraftBuilder(Material itemToCraft)
	{
		this._itemToCraft = itemToCraft;
		
		_items = new int[9];
	}
	
	public CraftBuilder set(int slot, Material item)
	{
		return this.set(slot, item.getId());
	}
	
	public CraftBuilder set(int slot, int item)
	{
		_items[slot] = item;
		
		return this;
	}
	
	public void build()
	{
		
	}

	public Material getItemToCraft()
	{
		return _itemToCraft;
	}

	public int[] getItems()
	{
		return _items;
	}	
}
