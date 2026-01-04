package eu.beanstalk.api.models;

import java.util.UUID;

import org.bukkit.entity.Player;

import eu.beanstalk.api.API;
import eu.beanstalk.api.libs.Spigboard;
import eu.beanstalk.api.sql.Database;

public class Gamer
{
	private Player player;
	private UUID uniqueId;

	private Spigboard board;
	private Rank rank;

	private int coins;
	private int crates;

	public Gamer(Player player)
	{
		this.player = player;
		this.uniqueId = player.getUniqueId();
	}

	public Spigboard getBoard()
	{
		return board;
	}

	public void setBoard(Spigboard board)
	{
		this.board = board;
	}

	public Rank getRank()
	{
		return rank;
	}

	public void setRank(Rank rank)
	{
		this.rank = rank;
	}

	public void setCoins(int coins)
	{
		this.coins = coins;
	}

	public void addCoins(int count)
	{
		setCoins(getCoins() + count);
		
		this.updateDatabase();
		this.board.getEntry("coins").update(new String("&fCoins: &a" + coins).replace("&", "§"));
	}

	public void removeCoins(int count)
	{
		setCoins(getCoins() - count);
		
		this.updateDatabase();
		this.board.getEntry("coins").update(new String("&fCoins: &a" + coins).replace("&", "§"));
	}

	public int getCoins()
	{
		return coins;
	}

	public int getCrates()
	{
		return crates;
	}

	public void setCrates(int crates)
	{
		this.crates = crates;
	}

	public void addCrates(int count)
	{
		setCrates(getCrates() + count);
		
		this.updateDatabase();
		this.board.getEntry("crates").update(new String("&fCrates: &a" + crates).replace("&", "§"));
	}

	public void removeCrates(int count)
	{
		setCrates(getCrates() - count);
		
		this.updateDatabase();
		this.board.getEntry("crates").update(new String("&fCrates: &a" + crates).replace("&", "§"));
	}

	public Player getPlayer()
	{
		return player;
	}

	public UUID getUniqueId()
	{
		return uniqueId;
	}

	public void updateDatabase()
	{
		Database.execute("UPDATE players SET coins='" + coins + "', crates='" + crates + "', rank='" + rank + "' WHERE uuid='" + player.getUniqueId() + "';");
		API.getPlugin().getLogger().info("Database updated for player " + player.getName());
	}

}
