package eu.beanstalk.api.portal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import eu.beanstalk.api.API;

public class Portal
{

	private static String prefix = "&3Portal &7» &e".replace("&", "§");

	public static void teleport(Player player, String server)
	{
		if (Bukkit.getServerName().toLowerCase().equalsIgnoreCase(server.toLowerCase()))
		{
			player.sendMessage(
					prefix + "&cYou're already connected to that server.".replace("&", "§"));
			return;
		}

		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);

		try
		{
			out.writeUTF("Connect");
			out.writeUTF(server);
		}
		catch (IOException e)
		{
			return;
		}
		
		player.sendPluginMessage(API.getPlugin(), "BungeeCord", b.toByteArray());

		player.sendMessage(
				new String(prefix + "You've been send to &e" + server + "&a.").replace("&", "§"));
	}

	public static void teleport(Player player, Location location)
	{
		player.teleport(location);
	}

}
