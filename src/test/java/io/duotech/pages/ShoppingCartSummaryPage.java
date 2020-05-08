package io.duotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utilities.Driver;

public class ShoppingCartSummaryPage {
	
	public ShoppingCartSummaryPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//td[@class='cart_description']//p[@class='product-name']//a")
	public WebElement productName;
	
	//td[@class='cart_unit']//span[@class='price']//span[@class='price']
	@FindBy(id = "product_price_1_1_304382")
	public WebElement unitPrace;
	
	@FindBy(name = "quantity_1_1_0_304382")
	public WebElement quantity;
	
	@FindBy(id = "total_product")
	public WebElement priceBefore;
	
	@FindBy(id = "total_price_without_tax")
	public WebElement priceAfter;
	

}
