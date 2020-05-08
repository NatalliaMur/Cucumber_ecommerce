package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.beans.ShoppingCart;
import io.duotech.pages.ProductPage;
import io.duotech.pages.ShoppingCartSummaryPage;

public class ShoppingCartStepDefs {
	
	@When("I increase the quantity to {int} and add them to cart")
	public void i_increase_the_quantity_to_and_add_them_to_cart(Integer times) {
	    ProductPage prodPage = new ProductPage();
	    
	    for (int i = 0; i < times-1; i++) {
				
	    prodPage.plusButton.click();
	    } 
	    prodPage.addToCart.click();
	    prodPage.proceedButton.click();
	}

	@Then("The shopping cart details have to be as following")
	public void the_shopping_cart_details_have_to_be_as_following(List<ShoppingCart> carts) {
		ShoppingCartSummaryPage cartSumPage = new ShoppingCartSummaryPage();
		
		for (ShoppingCart cart : carts) {
			assertEquals(cartSumPage.productName.getText(), cart.getDescription());
			assertEquals(cartSumPage.quantity.getText(), cart.getQuantity());	
			assertEquals(cartSumPage.unitPrace.getAttribute("value"), cart.getUnitPrace());	
			assertEquals(cartSumPage.priceBefore.getText(), cart.getPriceBefore());	
			assertEquals(cartSumPage.priceAfter.getText(), cart.getPriceAfter());	
		}
		 
// expected comes from feature file	
//actual comes from webpage		


	}

	
	
	
	

}
