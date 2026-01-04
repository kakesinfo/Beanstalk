package eu.beanstalk.hub.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherChangeEvent;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.hub.Hub;

public class WeatherChange extends AbstractListener
{
	private Hub plugin;	
	
	public WeatherChange(Hub plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onWeatherChange(WeatherChangeEvent event)
	{		
		if (event.toWeatherState())
		{
			event.setCancelled(true);
		}
	}
	
	public Hub getPlugin()
	{
		return plugin;
	}
}
