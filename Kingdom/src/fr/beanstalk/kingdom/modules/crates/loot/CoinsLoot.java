package fr.beanstalk.kingdom.modules.crates.loot;

import org.bukkit.entity.*;

public class CoinsLoot implements Loot
{
	private int amount;
	
	public CoinsLoot(int amount)
	{
		this.amount = amount;
	}

	@Override
	public void doAction(Player player)
	{
		
	}

	public int getAmount()
	{
		return amount;
	}
}
