package eu.beanstalk.api.models;

import org.bukkit.ChatColor;

public enum Rank
{
	DEFAULT("Default", "", "", ChatColor.WHITE, 1, true),
	VIP("VIP", "[VIP] ", "", ChatColor.GREEN, 1, false),
	BETA("Beta", "[Beta] ", "", ChatColor.DARK_AQUA, 1, false),
	MODO("Modo", "[Modo] ", "", ChatColor.GOLD, 2, false),
	DEV("Dev", "[Dev] ", "", ChatColor.AQUA, 3, false),
	ADMIN("Admin", "[Admin] ", "", ChatColor.RED, 4, false);
	
	private String name;
	private String prefix;
	private String suffix;
	private ChatColor color;
	private boolean isDefault;
	private int moderationLevel;
	
	Rank(String name, String prefix, String suffix, ChatColor color, int moderationLevel, boolean isDefault){
		this.name = name;
		this.prefix = prefix;
		this.suffix = suffix;
		this.color = color;
		this.isDefault = isDefault;
		this.moderationLevel = moderationLevel;
	}

	public String getName() {
		return name;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public ChatColor getColor() {
		return color;
	}
	
	public boolean isDefault(){
		return isDefault;
	}

	public int getModerationLevel() {
		return moderationLevel;
	}
}
