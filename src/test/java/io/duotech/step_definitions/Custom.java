package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.pages.DressesPage;
import io.duotech.pages.HomePage;

public class Custom {
	String homePageName;
	
	@When("I click on Women link")
	public void i_click_on_Women_link() {
	    HomePage homeP = new HomePage();
	    homeP.womenLink.click();
	}

	@Then("The Tops subcategory should be display")
	public void the_Tops_subcategory_should_be_display() {
	    DressesPage dp = new DressesPage();
	    	    
	    assertTrue(dp.tops.isDisplayed());
	}
	
	@Then("The following subcategories should be display")
	public void the_following_subcategories_should_be_display(List<String> subcategories) {
		 DressesPage dp = new DressesPage();
		 
		 for (String clothes : subcategories) {
			 assertTrue(dp.getSubcategoryCustom(clothes).isDisplayed());
			 System.out.println(clothes);
		}
//		 assertTrue(dp.getSubcategoryCustom(subcategories.get(0)).isDisplayed());
//		 System.out.println(subcategories.get(0));
//		assertTrue(dp.getSubcategoryCustom(subcategories.get(1)).isDisplayed());
//		System.out.println(subcategories.get(1));
	   
	}

}
