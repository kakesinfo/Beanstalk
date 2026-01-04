package eu.beanstalk.api.abstracts;

import org.bukkit.entity.Player;

public abstract class AbstractCommand
{
	private String name;
	private String usage;

	public AbstractCommand(String name, String usage)
	{
		this.name = name;
		this.usage = usage.replace("&", "§");
	}

	public abstract boolean process(String command, String[] args, Player sender);

	public String getName()
	{
		return name;
	}

	public String getUsage()
	{
		return usage;
	}

}
