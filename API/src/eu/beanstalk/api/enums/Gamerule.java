package eu.beanstalk.api.enums;

import org.bukkit.World;

public enum Gamerule
{
	DO_MOB_LOOT("doMobLoot"),
	DO_DAYLIGHT_CYCLE("doDaylightCycle"),
	
	KEEP_INVENTORY("keepInventory");
	
	private String name;

	private Gamerule(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setValue(World world, Object value)
	{
		world.setGameRuleValue(name, String.valueOf(value));
	}

}
