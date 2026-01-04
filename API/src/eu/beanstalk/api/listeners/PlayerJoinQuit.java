package eu.beanstalk.api.listeners;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.beanstalk.api.API;
import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.models.Gamer;
import eu.beanstalk.api.models.Rank;
import eu.beanstalk.api.sql.Database;

public class PlayerJoinQuit extends AbstractListener
{

	private API plugin;

	public PlayerJoinQuit(API plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) throws SQLException
	{
		Player player = event.getPlayer();

		boolean hasAccount = this.checkAccount(player);
		
		Gamer gamer = null;
		
		if (hasAccount)
		{
			ResultSet result = Database.query("SELECT * FROM players WHERE uuid='" + player.getUniqueId() + "';");
			gamer = new Gamer(player);

			try
			{
				result.next();

				gamer.setCoins(result.getInt("coins"));
				gamer.setCrates(result.getInt("crates"));
				gamer.setRank(Rank.valueOf(result.getString("rank")));

				System.out.println("Successfull registered " + player.getName());
			}
			catch (Exception e)
			{
				gamer.setCoins(0);
				gamer.setCrates(0);
				gamer.setRank(Rank.DEFAULT);

				System.err.println("Not Successfull registered " + player.getName());
			}

			plugin.getGamerHandler().addGamer(gamer);
		}
		
		player.setCustomName(gamer.getRank().getColor() + gamer.getRank().getPrefix() + player.getName());
		player.setCustomNameVisible(true);
		player.setPlayerListName(gamer.getRank().getColor() + gamer.getRank().getPrefix() + player.getName());
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
		
		Gamer gamer = plugin.getGamer(player);	
		gamer.updateDatabase();
	}

	public boolean checkAccount(Player player)
	{
		if (Database.exist("SELECT * FROM players WHERE uuid='" + player.getUniqueId() + "';"))
		{
			return true;
		}
		else
		{
			Database.execute("INSERT INTO players (uuid, pseudo, rank, coins, crates) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
					+ "', '" + Rank.DEFAULT + "', '" + 0 + "', '" + 0 + "');");
			return checkAccount(player);
		}
	}

	public API getPlugin()
	{
		return plugin;
	}

}
