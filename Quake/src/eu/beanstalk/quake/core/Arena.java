package eu.beanstalk.quake.core;

import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import eu.beanstalk.api.enums.Gamerule;
import eu.beanstalk.api.libs.Sound;
import eu.beanstalk.api.models.Gamer;
import eu.beanstalk.api.models.Map;
import eu.beanstalk.quake.Quake;
import eu.beanstalk.quake.models.ArenaMap;

public class Arena
{
	public static final int MINIMUM_PLAYERS = 1;
	public static final int MAXIMUM_PLAYERS = 10;
	public static final int COUNTDOWN = 60;

	private Quake plugin;
	private ArenaMap map;
	private State state;
	private int countdown;
	
	private HashSet<UUID> players = new HashSet<>();
	private HashSet<UUID> spectators = new HashSet<>();

	public Arena(Quake plugin)
	{
		this.plugin = plugin;
		this.map = new ArenaMap(Bukkit.getWorld("world"));
		this.map.setGameRule(Gamerule.DO_DAYLIGHT_CYCLE, false);
		this.map.setGameRule(Gamerule.KEEP_INVENTORY, true);
		this.map.setGameRule(Gamerule.DO_MOB_LOOT, false);

		this.state = State.WAITING;
	}

	public Quake getPlugin()
	{
		return plugin;
	}

	public boolean isMinimumPlayers()
	{
		return Bukkit.getOnlinePlayers().size() > MINIMUM_PLAYERS;
	}

	public boolean isMaximumPlayers()
	{
		return Bukkit.getOnlinePlayers().size() == MAXIMUM_PLAYERS;
	}

	public boolean isRunning()
	{
		return state == State.RUNNING;
	}

	public boolean shouldStart()
	{
		return isMaximumPlayers() && !isRunning();
	}

	public boolean shouldStop()
	{
		return false;
	}

	public void load()
	{
		state = State.STARTING;

		new BukkitRunnable()
		{
			int countdown = COUNTDOWN;

			@Override
			public void run()
			{
				if (isMinimumPlayers())
				{
					if (countdown != 0)
					{
						if ((countdown >= 1 && countdown <= 5) || countdown % 10 == 0)
						{
							Bukkit.broadcastMessage(Quake.PREFIX + " The game's stating in §b"
									+ countdown + " §eseconds.");

							Sound.UI_BUTTON_CLICK.broadcast(5f, 1f);
						}
						countdown--;
					}
					else
					{
						cancel();
						if (state == State.STARTING)
						{
							start();
						}
						else
						{
							state = State.WAITING;
						}
					}
				}
				else
				{
					cancel();
					state = State.WAITING;
				}
			}
		}.runTaskTimer(plugin, 0, 20);
	}

	public void start()
	{
		state = State.RUNNING;
	}

	public void stop()
	{
		state = State.WAITING;
	}

	public Map getMap()
	{
		return map;
	}

	public State getState()
	{
		return state;
	}

	public HashSet<UUID> getPlayers()
	{
		return players;
	}

	public HashSet<UUID> getSpectators()
	{
		return spectators;
	}

	public boolean isPlayer(Gamer gamer)
	{
		return players.contains(gamer.getUniqueId());
	}

	public boolean isSpectator(Gamer gamer)
	{
		return spectators.contains(gamer.getUniqueId());
	}

	public void setPlayer(Gamer gamer)
	{
		if (isSpectator(gamer))
			spectators.remove(gamer.getUniqueId());

		if (isPlayer(gamer))
			return;

		players.add(gamer.getUniqueId());
	}

	public void setSpectator(Gamer gamer)
	{
		if (isPlayer(gamer))
			players.remove(gamer.getUniqueId());

		if (isSpectator(gamer))
			return;

		spectators.add(gamer.getUniqueId());
	}

	public int getCountdown()
	{
		return countdown;
	}
}
