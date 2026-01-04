package eu.beanstalk.api.models;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import eu.beanstalk.api.enums.Gamerule;

public class Map
{
	private World world;
	private Location spawn;

	public Map(World world)
	{
		this.world = world;
		this.spawn = world.getSpawnLocation().add(0.5, 0, 0.5);
		
		this.clear();
	}

	public void setGameRule(Gamerule gamerule, Object value)
	{
		gamerule.setValue(world, value);
	}

	public World getWorld()
	{
		return world;
	}

	public Location getSpawn()
	{
		return spawn;
	}

	public void clear()
	{
		world.getEntities().forEach((entity)-> {
			if(!(entity instanceof Player))
				entity.remove();			
		});
	}
}
