package fr.beanstalk.kingdom;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

import fr.beanstalk.kingdom.core.*;

public class Plugin extends JavaPlugin
{
	private Kingdom _kingdom;

	public void onEnable()
	{
		_kingdom = new Kingdom(this);	
	}
	
	public void register(Listener listener)
	{
		Bukkit.getPluginManager().registerEvents(listener, this);
	}
	
	public void call(Event event)
	{
		Bukkit.getPluginManager().callEvent(event);
	}
	
	public void onDisable()
	{

	}

	public Kingdom getKingdom()
	{
		return _kingdom;
	}
}
