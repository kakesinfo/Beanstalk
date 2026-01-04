package eu.beanstalk.hub.command;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import eu.beanstalk.api.API;
import eu.beanstalk.api.abstracts.AbstractCommand;
import eu.beanstalk.api.models.Gamer;

public class CratesCommand extends AbstractCommand
{
	
	public CratesCommand(String name, String usage)
	{
		super(name, usage);
	}

	@Override
	public boolean process(String command, String[] args, Player sender)
	{
		if (args.length > 2 && args[1] != null && args[2] != null && args[3] != null)
		{
			String action = args[1];
			Gamer target = API.getPlugin().getGamer(Bukkit.getPlayer(args[2]));
			int value = Integer.valueOf(args[3]);

			if (action.equalsIgnoreCase("add"))
			{
				target.addCrates(value);
			}
			else if (action.equalsIgnoreCase("remove"))
			{
				target.removeCrates(value);
			}
			else
			{
				sender.sendMessage("&cUse: ".replace("&", "§") + getUsage());
			}
		}
		else
		{
			sender.sendMessage("Use: " + getUsage());
		}
		
		return true;
	}

}
