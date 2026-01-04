package eu.beanstalk.api.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import eu.beanstalk.api.API;
import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.models.Gamer;

public class PlayerChat extends AbstractListener
{
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {		
		Player player = event.getPlayer();
		Gamer gamer = API.getPlugin().getGamer(player);
		
		event.setFormat(gamer.getRank().getColor() + gamer.getRank().getPrefix() + "%s" + ChatColor.GRAY + " » " + ChatColor.WHITE + "%s");
	}

}
