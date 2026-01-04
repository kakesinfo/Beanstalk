package eu.beanstalk.hub.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import eu.beanstalk.api.API;
import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.builders.ItemBuilder;
import eu.beanstalk.api.economy.Currency;
import eu.beanstalk.api.economy.Economy;
import eu.beanstalk.api.libs.Spigboard;
import eu.beanstalk.api.models.Gamer;
import eu.beanstalk.api.models.Rank;
import eu.beanstalk.hub.Hub;

public class PlayerJoinQuit extends AbstractListener
{

	private Hub  plugin;
	
	public PlayerJoinQuit(Hub plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();

		AttributeInstance ai = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
		if (ai != null)
			ai.setBaseValue(16);

		player.getInventory().clear();

		new ItemBuilder(Material.COMPASS).withName("&e&lChoose Game &7(Right-click)").give(player, 1);
		new ItemBuilder(Material.CHEST).withName("&e&lCollectibles &7(Right-click)").give(player, 4);
		new ItemBuilder(Material.BOOK).withName("&e&lHub Selector &7(Right-click)").give(player, 7);

		player.setGameMode(GameMode.ADVENTURE);

		player.teleport(plugin.getMap().getSpawn());
		event.setJoinMessage("");
		
		Gamer gamer = API.getPlugin().getGamer(player);
		int coins = Economy.getMoney(gamer, Currency.COINS);
		int crates = gamer.getCrates();
		Rank rank = gamer.getRank();
		
		Spigboard board = new Spigboard("&e&lBEANSTALK");
		board.add(player);
		
		board.add("§5 ", 10);
		board.add("rank", "§fRank: " + (rank.getColor() + rank.getName()), 9);
		
		board.add("§8 ", 8);
		board.add("coins", "§fCoins: §a" + coins, 7);
		
		board.add("§1 ", 6);		
		board.add("crates", "§fCrates: §a" + crates, 5);		
		
		board.add("§2 ", 4);
		board.add("server", "§fServer: §a" + plugin.getServer().getServerName(), 3);
		
		board.add("§6 ", 2);
		board.add("§6 ", "§e play.beanstalk.eu", 1);
		
		gamer.setBoard(board);
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		event.setQuitMessage("");
	}

}
