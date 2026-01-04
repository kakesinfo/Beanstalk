package fr.beanstalk.kingdom.listeners;

import org.bukkit.event.*;

import fr.beanstalk.kingdom.core.*;

public abstract class Listener<__TYPE> implements org.bukkit.event.Listener
{
	private Kingdom _kingdom;

	public Listener(Kingdom kingdom)
	{
		this._kingdom = kingdom;
	}

	@EventHandler
	public abstract void onEvent(__TYPE event);

	public Kingdom getKingdom()
	{
		return _kingdom;
	}
}
