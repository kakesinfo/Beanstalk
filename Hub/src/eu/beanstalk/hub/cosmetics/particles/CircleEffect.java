package eu.beanstalk.hub.cosmetics.particles;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import eu.beanstalk.api.libs.Particle;
import eu.beanstalk.hub.Hub;

public class CircleEffect extends ParticleEffect
{

	public CircleEffect()
	{
		super(Particle.FIREWORKS_SPARK, 1);
	}

	@Override
	public void run(Hub plugin)
	{
		new BukkitRunnable()
		{
			double a = 0;
			double r = 0.8;

			@Override
			public void run()
			{
				if (entities.size() == 0)
					return;

				a += Math.PI / 8;

				double x = r * Math.sin(a);
				double z = r * Math.cos(a);

				for (UUID uuid : entities.keySet())
				{
					Entity entity = entities.get(uuid);

					if (entity instanceof Player)
					{
						if (!((Player) entity).isOnline())
						{
							remove(entity);
							continue;
						}
					}

					if (entity.isDead())
					{
						remove(entity);
						continue;
					}

					Location location = entity.getLocation().add(0, 2, 0);

					location.add(x, 0, z);
					particle.display(0, 0, 0, 0, 5, location, 16);
					location.subtract(x, 0, z);
				}
			}
		}.runTaskTimer(plugin, 0, (long) speed);
	}

}
