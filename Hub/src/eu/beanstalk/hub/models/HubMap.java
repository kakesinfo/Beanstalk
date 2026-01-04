package eu.beanstalk.hub.models;

import org.bukkit.Location;
import org.bukkit.World;

import eu.beanstalk.api.models.Hologram;
import eu.beanstalk.api.models.Map;
import eu.beanstalk.hub.models.map.TeleportPad;

public class HubMap extends Map
{

	public Location QUAKE_LOBBY;
	public Location ARCADES_LOBBY;

	public HubMap(World world)
	{
		super(world);

		this.QUAKE_LOBBY = new Location(world, -21.5, 63, 71.5, 57.9f, -2.6f);
		this.ARCADES_LOBBY = new Location(world, 29.5, 68, 19.5, -192.3f, 1.9f);
		
		Hologram hologram = new Hologram();
		hologram.withTitle("&e&lCome to play Quake").withTitle("&a&l|").withTitle("&a&lV");		
		
		TeleportPad pad = new TeleportPad(new Location(world, -25.5, 63, 74.4));
		pad.bind(hologram);
		pad.spawn();
	}

}
