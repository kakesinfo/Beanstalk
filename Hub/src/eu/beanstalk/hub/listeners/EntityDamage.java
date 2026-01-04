package eu.beanstalk.hub.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.hub.Hub;

public class EntityDamage extends AbstractListener
{
	private Hub plugin;	
	
	public EntityDamage(Hub plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event)
	{
		Entity entity = event.getEntity();
		DamageCause cause = event.getCause();

		if (entity instanceof Player)
		{
			Player player = (Player) entity;
			if (cause == DamageCause.VOID)
			{
				player.teleport(plugin.getMap().getSpawn());
			}
		}

		event.setCancelled(true);
	}
}
