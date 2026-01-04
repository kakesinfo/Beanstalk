package eu.beanstalk.api.crates;

import org.bukkit.Material;

public class Crate
{

	private Material material;

	public Crate()
	{
		material = Material.ENDER_CHEST;
	}

	public Material getMaterial()
	{
		return material;
	}

}
