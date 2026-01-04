package eu.beanstalk.api.products;

import eu.beanstalk.api.crates.CrateLootType;
import eu.beanstalk.api.products.interfaces.IKitProduct;

public class KitProduct extends Product implements IKitProduct
{

	public KitProduct()
	{
		super(CrateLootType.KIT, "kit");
	}

}
