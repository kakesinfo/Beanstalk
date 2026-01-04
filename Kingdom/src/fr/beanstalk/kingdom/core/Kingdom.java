package fr.beanstalk.kingdom.core;

import java.util.*;

import org.bukkit.*;

import fr.beanstalk.kingdom.*;
import fr.beanstalk.kingdom.listeners.*;
import fr.beanstalk.kingdom.modules.factions.*;

public class Kingdom
{
	private Plugin plugin;

	private Map<String, Faction> factions;

	public Kingdom(Plugin plugin)
	{
		this.plugin = plugin;

		factions = new HashMap<>();
		
		register(new Faction("SAFE_ZONE", ChatColor.GREEN, false));
		register(new Faction("WAR_ZONE", ChatColor.RED, false));
		
		plugin.register(new PlayerJoin(this));
	}
	
	public void register(Faction faction)
	{
		factions.put(faction.getName(), faction);
	}

	public Plugin getPlugin()
	{
		return plugin;
	}

	public Map<String, Faction> getFactions()
	{
		return factions;
	}
}
