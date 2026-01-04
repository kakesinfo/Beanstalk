package eu.beanstalk.hub.models.map;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.models.Hologram;
import eu.beanstalk.api.portal.Portal;
import eu.beanstalk.hub.Hub;
import eu.beanstalk.hub.cosmetics.particles.CircleEffect;

public class TeleportPad extends AbstractListener
{
	private Location location;
	private UUID uniqueId;
	private ArmorStand armorstand;
	private CircleEffect particle;

	private Hologram hologram;

	public TeleportPad(Location location)
	{
		this.location = location;
		this.uniqueId = UUID.randomUUID();
		this.armorstand = null;
		this.particle = null;

		this.hologram = null;

		this.register();
	}

	public TeleportPad bind(Hologram hologram)
	{
		this.hologram = hologram;

		return this;
	}

	public void spawn()
	{
		armorstand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		armorstand.setVisible(false);
		armorstand.setInvulnerable(true);
		armorstand.setSilent(true);
		armorstand.setCanPickupItems(false);

		particle = new CircleEffect();
		particle.run(Hub.getPlugin());

		particle.give(armorstand);

		location.subtract(0, 1, 0).getBlock().setType(Material.SEA_LANTERN);

		if (hologram != null)
		{
			hologram.spawn(location.add(0, 1, 0));
		}
	}

	@EventHandler
	public void onEvent(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();

		if (player.getLocation().distance(location) < 0.5)
		{
			Portal.teleport(player, "hub-1");
		}
	}

	public Location getLocation()
	{
		return location;
	}

	public UUID getUniqueId()
	{
		return uniqueId;
	}

	public ArmorStand getArmorstand()
	{
		return armorstand;
	}

}
