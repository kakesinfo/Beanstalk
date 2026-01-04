package eu.beanstalk.hub;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import eu.beanstalk.api.commands.CommandHandler;
import eu.beanstalk.api.enums.Gamerule;
import eu.beanstalk.api.handlers.InventoryHandler;
import eu.beanstalk.hub.command.CoinsCommand;
import eu.beanstalk.hub.command.CratesCommand;
import eu.beanstalk.hub.handlers.ServerHandler;
import eu.beanstalk.hub.inventories.ChooseGameMenu;
import eu.beanstalk.hub.inventories.CosmeticsMenu;
import eu.beanstalk.hub.listeners.EntityDamage;
import eu.beanstalk.hub.listeners.InventoryClick;
import eu.beanstalk.hub.listeners.InventoryDrop;
import eu.beanstalk.hub.listeners.PlayerInteract;
import eu.beanstalk.hub.listeners.PlayerJoinQuit;
import eu.beanstalk.hub.listeners.PlayerStarve;
import eu.beanstalk.hub.listeners.WeatherChange;
import eu.beanstalk.hub.models.HubMap;

public class Hub extends JavaPlugin
{
	private static Hub plugin;

	private HubMap map;
	private ServerHandler hubsHandler;
	private InventoryHandler inventories;
	private CommandHandler commandHandler;

	public void onEnable()
	{
		plugin = this;

		this.map = new HubMap(Bukkit.getWorld("world"));
		this.map.setGameRule(Gamerule.DO_DAYLIGHT_CYCLE, false);
		this.map.setGameRule(Gamerule.DO_MOB_LOOT, false);
		this.map.setGameRule(Gamerule.KEEP_INVENTORY, true);

		this.hubsHandler = new ServerHandler(this);
		this.hubsHandler.run();

		this.inventories = new InventoryHandler();
		this.inventories.addMenu(0, new ChooseGameMenu());
		this.inventories.addMenu(1, new CosmeticsMenu());

		this.commandHandler = new CommandHandler();
		this.commandHandler.addCommand(new CoinsCommand("coins", "/coins <add/remove> <player> <value>"));
		this.commandHandler.addCommand(new CratesCommand("crates", "/crates <add/remove> <player> <value>"));

		new PlayerJoinQuit(this).register();
		new PlayerInteract(this).register();
		new PlayerStarve(this).register();

		new EntityDamage(this).register();

		new InventoryClick(this).register();
		new InventoryDrop(this).register();

		new WeatherChange(this).register();
	}

	public static Hub getPlugin()
	{
		return plugin;
	}

	public HubMap getMap()
	{
		return map;
	}

	public InventoryHandler getInventories()
	{
		return inventories;
	}

	public ServerHandler getHubsHandler()
	{
		return hubsHandler;
	}

	public int getServerPort()
	{
		return getServer().getPort();
	}
}
