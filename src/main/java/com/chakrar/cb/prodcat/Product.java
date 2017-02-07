package com.chakrar.cb.prodcat;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static String TYPE = "Product";
	
	private String id;
	
	private String description;
	
	private String price;
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

}
