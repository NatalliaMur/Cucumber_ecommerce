package io.duotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(className = "login")
	public WebElement signInButton;
	
	@FindBy(xpath = "(//a[@title='Blouse'])[2]")
	public WebElement blouse;
	
	public WebElement getProduct(String name ) {
	String customXpath = "(//a[@title='"+name+"'])[2]";	
	return Driver.getDriver().findElement(By.xpath(customXpath));
	}
	
	@FindBy(xpath = "(//h5[@itemprop='name']//a[@title='Printed Dress'])[1]")
	public WebElement printedDress;
	
	@FindBy(xpath = "(//a[@class='sf-with-ul'])[4]")
	public WebElement dressesLink;
	
	@FindBy(linkText = "Women")
	public WebElement womenLink;
}
