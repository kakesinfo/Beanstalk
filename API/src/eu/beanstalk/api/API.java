package eu.beanstalk.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import eu.beanstalk.api.handlers.GamerHandler;
import eu.beanstalk.api.listeners.BlockBreak;
import eu.beanstalk.api.listeners.PlayerChat;
import eu.beanstalk.api.listeners.PlayerHandChange;
import eu.beanstalk.api.listeners.PlayerJoinQuit;
import eu.beanstalk.api.models.Gamer;
import eu.beanstalk.api.sql.Database;

public class API extends JavaPlugin
{
	private static API plugin;
	private GamerHandler gamerHandler;

	public void onEnable()
	{
		plugin = this;

		new Database("beanstalk_eu");

		gamerHandler = new GamerHandler();
		
		new BlockBreak().register();
		
		new PlayerHandChange().register();
		new PlayerJoinQuit(this).register();
		new PlayerChat().register();
		
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		for (Player player : Bukkit.getOnlinePlayers())
		{
			Bukkit.getPluginManager().callEvent(new PlayerJoinEvent(player, ""));
		}
	}

	public static API getPlugin()
	{
		return plugin;
	}

	public GamerHandler getGamerHandler()
	{
		return gamerHandler;
	}

	public Gamer getGamer(Player player)
	{
		return gamerHandler.getGamer(player);
	}
}
