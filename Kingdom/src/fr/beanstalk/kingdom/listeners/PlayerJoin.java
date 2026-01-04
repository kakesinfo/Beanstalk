package fr.beanstalk.kingdom.listeners;

import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import fr.beanstalk.kingdom.core.*;
import fr.beanstalk.kingdom.models.*;

public class PlayerJoin extends Listener<PlayerJoinEvent>
{
	public PlayerJoin(Kingdom kingdom)
	{
		super(kingdom);
	}

	@EventHandler
	public void onEvent(PlayerJoinEvent event)
	{
		ItemBuilder builder = new ItemBuilder(Material.STONE);
		builder.withName("§7ok...").withLore("caca").withLore("§6§bI love caca");
		
		builder.give(event.getPlayer());		
	}
}
