package eu.beanstalk.api.economy;

import eu.beanstalk.api.models.Gamer;

public class Economy
{

	public static int getMoney(Gamer gamer, Currency currency)
	{
		switch (currency)
		{
			case COINS:
				return gamer.getCoins();
			default:
				return 0;
		}
	}

	public static void setMoney(Gamer gamer, Currency currency, int value)
	{
		switch (currency)
		{
			case COINS:
				gamer.setCoins(value);
			default:
				break;
		}
	}

	public static void addMoney(Gamer gamer, Currency currency, int value)
	{
		setMoney(gamer, currency, getMoney(gamer, currency) + value);
	}

	public static void removeMoney(Gamer gamer, Currency currency, int value)
	{
		setMoney(gamer, currency, getMoney(gamer, currency) - value);
	}

}