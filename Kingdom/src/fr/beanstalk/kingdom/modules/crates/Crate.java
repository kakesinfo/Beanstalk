package fr.beanstalk.kingdom.modules.crates;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

import fr.beanstalk.kingdom.modules.crates.loot.*;

public class Crate
{
	private List<Loot> loots;
	
	public Crate()
	{
		loots = new ArrayList<>();
	}
	
	public void reset()
	{
		loots.clear();		

		loots.add(new CoinsLoot(10));
		loots.add(new CoinsLoot(50));
		loots.add(new CoinsLoot(100));
		loots.add(new CoinsLoot(250));
		
		loots.add(new ItemLoot(new ItemStack(Material.ACACIA_DOOR)));
	}
	
	public void launch(Player player)
	{
		loots.get(0).doAction(player);
	}
}
