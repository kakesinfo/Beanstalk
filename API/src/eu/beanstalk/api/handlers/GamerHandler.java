package eu.beanstalk.api.handlers;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import eu.beanstalk.api.models.Gamer;

public class GamerHandler
{

	private HashMap<UUID, Gamer> gamers;

	public GamerHandler()
	{
		gamers = new HashMap<>();
	}

	public void addGamer(Player player)
	{
		addGamer(new Gamer(player));
	}

	public void addGamer(Gamer gamer)
	{
		gamers.put(gamer.getUniqueId(), gamer);
	}

	public void removeGamer(Player player)
	{
		removeGamer(new Gamer(player));
	}

	public void removeGamer(Gamer gamer)
	{
		gamers.remove(gamer.getUniqueId());
	}

	public Gamer getGamer(Player player)
	{
		return gamers.get(player.getUniqueId());
	}

}
