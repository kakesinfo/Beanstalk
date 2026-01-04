package eu.beanstalk.api.builders;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public class ItemBuilder
{
	private ItemStack stack;
	private ItemMeta meta;

	private List<String> lores;
	
	public ItemBuilder(Material material)
	{
		this(material.getId(), 1, (short) 0);
	}
	
	public ItemBuilder(Material material, int amount)
	{
		this(material.getId(), amount, (short) 0);
	}

	public ItemBuilder(Material material, int amount, short data)
	{
		this(material.getId(), amount, data);
	}

	public ItemBuilder(int type, int amount, short data)
	{
		stack = new ItemStack(type, amount, data);
		meta = stack.getItemMeta();

		lores = new ArrayList<>();
	}

	public ItemBuilder withName(String displayName)
	{
		displayName = ChatColor.translateAlternateColorCodes('&', displayName);

		meta.setDisplayName(displayName);

		this.save();

		return this;
	}

	public ItemBuilder withLore(String lore)
	{
		lores.add(ChatColor.translateAlternateColorCodes('&', lore));
		meta.setLore(lores);

		this.save();

		return this;
	}

	public ItemBuilder setUnbreakable(boolean value)
	{
		meta.spigot().setUnbreakable(value);

		this.save();

		return this;
	}

	public ItemBuilder hideFlag(ItemFlag itemFlag)
	{
		for (int i = 0; i < 5; i++)
			meta.addItemFlags(itemFlag);

		this.save();

		return this;
	}

	public ItemBuilder hideFlags()
	{

		for (int i = 0; i < 5; i++)
		{
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
			meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
			meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		}

		this.save();

		return this;
	}

	public ItemStack build()
	{
		return stack;
	}

	public void give(Player player, int slot)
	{
		player.getInventory().setItem(slot, stack);
		player.updateInventory();
	}

	private void save()
	{
		if (stack != null && meta != null)
			stack.setItemMeta(meta);
	}

}
