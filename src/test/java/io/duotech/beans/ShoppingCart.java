package io.duotech.beans;

public class ShoppingCart {
	
	private String description;
	private String unitPrace;
	private String quantity;
	private String priceBefore;
	private String priceAfter;
	
	public ShoppingCart(String description, String unitPrace, String quantity, String priceBefore, String priceAfter) {
		super();
		this.description = description;
		this.unitPrace = unitPrace;
		this.quantity = quantity;
		this.priceBefore = priceBefore;
		this.priceAfter = priceAfter;
	}

	public String getDescription() {
		return description;
	}

	public String getUnitPrace() {
		return unitPrace;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getPriceBefore() {
		return priceBefore;
	}

	public String getPriceAfter() {
		return priceAfter;
	}
	
	
	

}
