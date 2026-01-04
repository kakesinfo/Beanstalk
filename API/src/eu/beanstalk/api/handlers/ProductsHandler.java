package eu.beanstalk.api.handlers;

import eu.beanstalk.api.API;
import eu.beanstalk.api.models.Handler;
import eu.beanstalk.api.products.CoinsProduct;
import eu.beanstalk.api.products.Product;

public class ProductsHandler extends Handler<API, Product>
{
	
	public ProductsHandler(API core)
	{
		super(core);
	}

	@Override
	protected void run()
	{
		add("coins.25", new CoinsProduct(25));
		add("coins.25", new CoinsProduct(50));
		add("coins.25", new CoinsProduct(100));
		add("coins.25", new CoinsProduct(250));
	}

}
