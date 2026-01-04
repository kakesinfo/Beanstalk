package fr.beanstalk.kingdom.modules.factions;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.*;

public class Faction
{
	private List<Player> players;
	private List<Chunk> claims;

	private String name;
	private ChatColor color;
	
	private boolean joinable;

	public Faction(String name, ChatColor color)
	{
		this(name, color, true);
	}

	
	public Faction(String name, ChatColor color, boolean joinable)
	{
		this.name = name;
		this.color = color;
		this.joinable = joinable;
		
		players = new ArrayList<>();
		claims = new ArrayList<>();
	}

	public void join(Player player)
	{
		players.add(player);
	}

	public void quit(Player player)
	{
		players.remove(player);
	}

	public boolean hasPermission(Player player)
	{
		return players.contains(player);
	}

	public void claim(Location location)
	{
		claims.add(location.getChunk());
	}

	public void unclaim(Location location)
	{
		claims.remove(location.getChunk());
	}
	
	public boolean isClaim(Location location)
	{
		return claims.contains(location.getChunk());
	}

	public List<Player> getPlayers()
	{
		return players;
	}	
	
	public List<Chunk> getClaims()
	{
		return claims;
	}

	public String getName()
	{
		return name;
	}

	public ChatColor getColor()
	{
		return color;
	}
	
	public boolean isJoinable()
	{
		return joinable;
	}
}
