package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.pages.HomePage;
import io.duotech.pages.ProductPage;

public class ProductPrintedDressStepDefs {
	
	@When("I click on Printed Dress")
	public void i_click_on_Printed_Dress() {
	   HomePage hPage = new HomePage();
	   
	   hPage.printedDress.click();
	   
		
	}

	@Then("The product page should also display Printed Dress")
	public void the_product_page_should_also_display_Printed_Dress() {
	   ProductPage pPage = new ProductPage();
	   HomePage hPage = new HomePage();	
		assertEquals(hPage.printedDress.getText(), pPage.productNamePrintedDress.getText());
		
	}


}
