package eu.beanstalk.api.products;

import eu.beanstalk.api.crates.CrateLootType;
import eu.beanstalk.api.products.interfaces.ICoinsProduct;

public class CoinsProduct extends Product implements ICoinsProduct
{	
	private int amount;

	public CoinsProduct(int amount)
	{
		super(CrateLootType.COINS, "coins." + amount);
		
		this.amount = amount;
	}

	public int getAmount()
	{
		return amount;
	}
}
