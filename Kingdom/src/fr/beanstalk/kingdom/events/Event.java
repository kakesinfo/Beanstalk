package fr.beanstalk.kingdom.events;

import org.bukkit.event.*;

import fr.beanstalk.kingdom.core.*;

public class Event extends org.bukkit.event.Event
{	
	private static final HandlerList handlers = new HandlerList();
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}
	
	public static HandlerList getHandlerList()
	{
		return handlers;
	}
	
	private Kingdom kingdom;
	
	public Event(Kingdom kingdom)
	{
		this.kingdom = kingdom;
	}

	public Kingdom getKingdom()
	{
		return kingdom;
	}
}
