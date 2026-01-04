package eu.beanstalk.hub.cosmetics.particles;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Entity;

import eu.beanstalk.api.libs.Particle;
import eu.beanstalk.hub.Hub;

public abstract class ParticleEffect
{

	protected HashMap<UUID, Entity> entities;
	protected Particle particle;
	protected float speed;
	
	public ParticleEffect(Particle particle, float speed)
	{
		this.particle = particle;
		this.entities = new HashMap<>();
		this.speed = speed;
	}

	public void give(Entity entity)
	{
		entities.put(entity.getUniqueId(), entity);
	}

	public void remove(Entity entity)
	{
		entities.remove(entity.getUniqueId());
	}

	public boolean has(Entity entity)
	{
		return entities.containsKey(entity.getUniqueId());
	}
	
	public abstract void run(Hub plugin);

	public HashMap<UUID, Entity> getEntities()
	{
		return entities;
	}

	public Particle getParticle()
	{
		return particle;
	}

	public float getSpeed()
	{
		return speed;
	}
	
}
