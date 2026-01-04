package eu.beanstalk.api.products;

import eu.beanstalk.api.crates.CrateLootType;

public class Product
{
	
	private CrateLootType type;
	private String name;
	
	public Product(CrateLootType type, String name)
	{
		super();
		this.type = type;
		this.name = name;
	}
	public CrateLootType getType()
	{
		return type;
	}
	public String getName()
	{
		return name;
	}
	
}
