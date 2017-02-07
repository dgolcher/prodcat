package com.chakrar.cb.prodcat;

public class ProductUtil {

	public static Product getProduct(long nextIdNumber) {
		Product product = new Product ();
		product.setId("Product "+ nextIdNumber);
		product.setDescription("This is a utility product");
		product.setPrice("20");
		return product;
	}

}
