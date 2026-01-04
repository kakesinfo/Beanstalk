package eu.beanstalk.api.enums;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import eu.beanstalk.api.API;
import eu.beanstalk.api.libs.Particle;
import eu.beanstalk.api.libs.Sound;

public enum Railgun
{

	BASIC("Basic Railgun", Material.WOOD_HOE, 1.5);
	
	private String name;
	private Material material;
	private double trigger;

	private Railgun(String name, Material material, double trigger)
	{	
		this.name = name;
		this.material = material;
		this.trigger = trigger;
	}

	public String getName()
	{
		return name;
	}

	public Material getMaterial()
	{
		return material;
	}

	public double getTrigger()
	{
		return trigger;
	}
	
	public void shoot(Player player) {
		if (player.getExp() != 0F)
			return;
		reload(player);

		Location l = player.getLocation();
		Vector v = l.getDirection().normalize();

		Sound.ENTITY_BLAZE_HURT.broadcast(3f, 1f);

		List<Player> gibbed = new ArrayList<>();

		for (double i = 1; i < 20; i += 0.5) {
			double x = v.getX() * i;
			double y = (v.getY() * i) + 1.5;
			double z = v.getZ() * i;

			l.add(x, y, z);
			Particle.FIREWORKS_SPARK.display(0, 0, 0, 0, 16, l, 32);
			gibbed.addAll(detect(player, l));
			l.subtract(x, y, z);
		}
	}
	
	private void reload(Player player) {
		float originalXp = player.getExp();
		double ticks = trigger * 21;
		float division = (float) (1F / ticks);

		player.setExp(1F);
		
		new BukkitRunnable() {
			public void run() {
				player.setExp(player.getExp() - division);
				if (player.getExp() <= 0f)
					cancel();
			}
		}.runTaskTimer(API.getPlugin(), 0L, 1L);
		
		new BukkitRunnable()
		{			
			@Override
			public void run()
			{
				player.setExp(originalXp);
			}
		}.runTaskLater(API.getPlugin(), (long) (ticks + 2));
	}

	private List<Player> detect(Player player, Location location) {
		List<Player> gibbed = new ArrayList<>();
		
		for (Entity e : location.getWorld().getEntities()) {
			if (e instanceof Player && !e.equals(player) && e.getLocation().distance(location) < 1.75) {
				gibbed.add((Player) e);
			}
		}
		
		return gibbed;
	}

}
