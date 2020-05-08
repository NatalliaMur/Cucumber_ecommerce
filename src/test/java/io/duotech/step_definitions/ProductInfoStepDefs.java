package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.duotech.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.pages.DressesPage;
import io.duotech.pages.HomePage;
import io.duotech.pages.ProductPage;
import io.duotech.utilities.LoggerUtils;

public class ProductInfoStepDefs {
	String homePageName;
	Integer globalTimes;
	DressesPage dressPage;
		
	Logger logger = LoggerUtils.getLogger(ProductInfoStepDefs.class);
	
	
		@When("I click on Blouse")
	public void i_click_on_Blouse() {
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
	    
		HomePage homepage = new HomePage();
		
		WebElement elementToClick = Driver.getDriver().findElement(By.xpath("(//a[@title='Blouse'])[2]"));
	    ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
		((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].checked = true;", elementToClick);
//	   
		homePageName = homepage.blouse.getText();
	    
//		try {
//			homePageName = homepage.blouse.getText();
//			logger.info("Blouse getText passed");
//		}
//		catch (NoSuchElementException e) {
//			logger.info("Blouse getText failed", e);
//			logger.info(e.toString());
//			throw e;
//		}
		
		
		homepage.blouse.click();
		
	}

	@Then("The product page should also display Blouse")
	public void the_product_page_should_also_display_Blouse() {
	   ProductPage productPage = new ProductPage();
	   String productPageName= productPage.productName.getText();
	   
	   assertEquals(productPageName, homePageName);
	}
	
	@Then("I land on product page")
	public void i_land_on_product_page() {
		String actual = Driver.getDriver().getTitle();
		String expected = "Blouse - My Store";
		
		logger.info("Verifying title \"Blouse - My Store\" ");		
		assertEquals(actual, expected);
	    
	}

	@Then("The default quantity for the product should be {int}")
	public void the_default_quantity_for_the_product_should_be(Integer expected) {
	   ProductPage productPage = new ProductPage();
	   String actual = productPage.quantityBox.getAttribute("value");
	   assertEquals(actual, expected.toString());
	}
	
	@Then("I click on {word} button {int} times")
	public void i_click_on_plus_button_times(String word, Integer times) {
		ProductPage productPage = new ProductPage();
		for (int i = 0; i < times; i++) {
			if(word.equalsIgnoreCase("plus")) {
			productPage.plusButton.click();
			}else {
				productPage.minusButton.click();
				}
			}
		globalTimes = ++times;
	}

	@Then("The quantity should be correct")
	public void the_quantity_should_be_correct() {
		ProductPage productPage = new ProductPage();
		String actual = productPage.quantityBox.getAttribute("value");
		assertEquals(actual, globalTimes.toString());
	}

	@Given("The first step")
	public void the_first_step() {
	    System.out.println("1");
	}

	@When("I do second step")
	public void i_do_second_step() {
		 System.out.println("2");
	}

	@Then("I verify third step")
	public void i_verify_third_step() {
		 System.out.println("3");
	}
	
	@When("I click on Dresses link")
	public void i_click_on_Dresses_link() {
	   HomePage hp = new HomePage();
	   hp.dressesLink.click();
	}

	@Then("The Casual Dresses subcategory should be displayed")
	public void the_Casual_Dresses_subcategory_should_be_displayed() {
	   DressesPage dp = new DressesPage();
	   
	   assertTrue(dp.casualDresses.isDisplayed());
	}

	@Then("The following subcategories should be displayed")
	public void the_following_subcategories_should_be_displayed( List<String> subcategories) {
	    System.out.println(subcategories);
	    dressPage = new DressesPage();
	    
	    for (String dress : subcategories) {
	    	assertTrue(dressPage.getSubcategory(dress).isDisplayed());
		}
	    
//	    assertTrue(dp.getSubcategory(subcategories.get(1)).isDisplayed());
	 }
	@Then("The following colors should be displayed")
	public void the_following_colors_should_be_displayed(List<String> colors) {
		dressPage= new DressesPage();
	
	for (String eachcolor : colors) {
		assertTrue(dressPage.getColorElement(eachcolor).isDisplayed());
		System.out.println(eachcolor);
	}
	
	}
	@When("I click on {string}")
	public void i_click_on(String product) {
		HomePage homepage = new HomePage();
		
		homepage.getProduct(product).click();
	}

	@Then("The product page should also display {string}")
	public void the_product_page_should_also_display(String name) {
	   ProductPage prodPage = new ProductPage();
	   String actualName =prodPage.productName.getText();
	   assertEquals(actualName, name);
	   
	}

	@Then("The product price should be {double}")
	public void the_product_price_should_be(Double expectedPrice) {
		ProductPage prodPage = new ProductPage();
		 
		Double actualPrice = Double.parseDouble(prodPage.price.getText().substring(1));
		   
		 assertEquals(actualPrice, expectedPrice);
	}
	
		
	


	
	
	

}
