package eu.beanstalk.hub.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.beanstalk.api.builders.InventoryBuilder;
import eu.beanstalk.api.builders.ItemBuilder;
import eu.beanstalk.api.models.Server;
import eu.beanstalk.hub.Hub;

public class HubSelectorMenu extends InventoryBuilder
{

	public HubSelectorMenu(Hub plugin)
	{
		super("Hub Selector", 1);

		int currentPort = plugin.getServerPort();

		for (Server server : plugin.getHubsHandler().getServers())
		{
			if (!server.isConnection())
				continue;

			boolean current = currentPort == server.getSocket().getPort();

			Material material = current ? Material.MAP : Material.EMPTY_MAP;
			String playersInfo = server.getOnlinePlayers() + "/" + server.getMaximumPlayers();
			String id = server.getName().split("-")[1];

			ItemBuilder item = new ItemBuilder(material).withName("&e&lHub " + id).withLore("").withLore("&7Players: §f" + playersInfo).withLore("");

			if (current)
			{
				item.withLore("&c&l" + "×" + "&c Already connected.");
			}
			else
			{
				item.withLore("&a> Click to be teleported.");
			}

			addItem(item);
		}
	}

	@Override
	public void click(Player player, ItemStack item)
	{
		
	}

}
