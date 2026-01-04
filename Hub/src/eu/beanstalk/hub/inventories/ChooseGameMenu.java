package eu.beanstalk.hub.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.beanstalk.api.builders.InventoryBuilder;
import eu.beanstalk.api.builders.ItemBuilder;
import eu.beanstalk.api.portal.Portal;
import eu.beanstalk.hub.Hub;

public class ChooseGameMenu extends InventoryBuilder
{

	public ChooseGameMenu()
	{
		super("Choose Game", 3);
	}

	public void init()
	{
		setMinigameItem(12, "Quake", "Shooter", Material.IRON_HOE,
				"Even if you're not a farmer, shoot your ennemies with your hoe !");
		setMinigameItem(13, "Wings Brawl", "Competitive", Material.BLAZE_POWDER, "Coming soon ...");
		setMinigameItem(14, "Build'in survival", "Building 1v1", Material.WORKBENCH,
				"Create a build based on a theme in 15 minutes, while searching requiered blocks in a special wild area.");
	}

	private void setMinigameItem(int slot, String name, String type, Material material,
			String description)
	{

		ItemBuilder item = new ItemBuilder(material).withName("&c&lSOON &e&l" + name).hideFlags()
				.withLore("&8" + type).withLore("");

		String builder = "";
		int index = 0;
		for (String lore : description.replace(" ", "¤").split("¤"))
		{
			if (index > 24)
			{
				index = 0;
				builder += "¤";
			}

			String prefix = "";
			if (index > 0)
				prefix = " ";
			builder += prefix + lore;
			index += lore.length();
		}

		for (String lore : builder.split("¤"))
			item.withLore("&7" + lore);

		item.withLore("").withLore("&a> Click to join &n" + name + "&a lobby.");

		setItem(slot, item);
	}

	@Override
	public void click(Player player, ItemStack item)
	{
		Material material = item.getType();

		if (material == Material.DIAMOND_HOE)
		{
			player.closeInventory();
			Portal.teleport(player, Hub.getPlugin().getMap().QUAKE_LOBBY);
		}
	}

}
