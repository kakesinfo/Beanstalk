package eu.beanstalk.hub.handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.scheduler.BukkitRunnable;

import eu.beanstalk.api.models.Server;
import eu.beanstalk.hub.Hub;

public class ServerHandler
{
	private Hub plugin;
	private List<Server> servers;

	public ServerHandler(Hub plugin)
	{
		this.plugin = plugin;
		this.servers = new ArrayList<>();

		for (int i = 1; i < 3; i++)
		{
			servers.add(new Server("hub-" + i, "localhost", Integer.valueOf("2551" + i)));
		}
	}

	public void run()
	{
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				for (Server server : servers)
				{
					if (server == null)
						continue;
					server.update();
				}
			}
		}.runTaskTimer(plugin, 0, 20);
	}

	public Hub getPlugin()
	{
		return plugin;
	}

	public List<Server> getServers()
	{
		return servers;
	}

}
