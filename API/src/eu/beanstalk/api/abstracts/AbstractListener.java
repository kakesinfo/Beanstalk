package eu.beanstalk.api.abstracts;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import eu.beanstalk.api.API;

public abstract class AbstractListener implements Listener
{	
	
	public void register()
	{
		Bukkit.getPluginManager().registerEvents(this, API.getPlugin());
	}

}
