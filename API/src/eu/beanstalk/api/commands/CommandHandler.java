package eu.beanstalk.api.commands;

import java.util.Collection;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import eu.beanstalk.api.API;
import eu.beanstalk.api.abstracts.AbstractCommand;
import eu.beanstalk.api.abstracts.AbstractListener;
import eu.beanstalk.api.models.Gamer;

public class CommandHandler extends AbstractListener
{

	private HashMap<Object, AbstractCommand> commands;

	public CommandHandler()
	{
		this.commands = new HashMap<>();

		this.register();
	}

	public Collection<AbstractCommand> getCommands()
	{
		return commands.values();
	}

	public void addCommand(AbstractCommand command)
	{
		commands.put(command.getName(), command);
	}

	public AbstractCommand getCommand(Object key)
	{
		return commands.get(key);
	}

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event)
	{
		Player sender = (Player) event.getPlayer();
		Gamer gamer = API.getPlugin().getGamer(sender);
		String command = event.getMessage().split(" ")[0].replace("/", "");
		String[] args = event.getMessage().split(" ");

		event.setCancelled(true);

		if (gamer.getRank().getModerationLevel() < 2)
		{
			sender.sendMessage("&c&lHey! &7Sorry, try asking an [OP] for help.".replace("&", "§"));
			return;
		}
		else
		{
			for (AbstractCommand cmd : commands.values())
			{
				if (cmd.getName().equalsIgnoreCase(command))
				{
					event.setCancelled(true);

					if (args.length > 1)
					{
						cmd.process(command, args, sender);
					}
					else
					{
						sender.sendMessage("Use: " + cmd.getUsage());
					}					
				}
			}
		}
		
	}

}
