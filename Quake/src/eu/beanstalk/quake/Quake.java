package eu.beanstalk.quake;

import org.bukkit.plugin.java.JavaPlugin;

import eu.beanstalk.quake.core.Arena;
import eu.beanstalk.quake.listeners.PlayerJoinQuit;

public class Quake extends JavaPlugin
{
	public static final String PREFIX = "&cQuake &7» &e".replace("&", "§");
	
	private Quake plugin;
	private Arena arena; 

	public void onEnable()
	{
		this.plugin = this;
		this.arena = new Arena(this);
		
		new PlayerJoinQuit(this).register();
	}

	public void inDisable()
	{
		
	}

	public Quake getPlugin()
	{
		return plugin;
	}

	public static String getPrefix()
	{
		return PREFIX;
	}

	public Arena getArena()
	{
		return arena;
	}
	
}
