package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.duotech.utilities.Driver;

import io.cucumber.java.en.Then;
import io.duotech.pages.HomePage;
import io.duotech.pages.ProductPage;
import io.duotech.utilities.ExcelUtils;

public class PromotedProduct {
	
	@Then("Promoted product should be display")
	public void promoted_product_should_be_display() {
		//Get the promoted products from excel file
		//Veryfy if they are displayd
		HomePage homePage = new HomePage();
		
		ExcelUtils sheet = new ExcelUtils("src/test/resources/io/duotech/test-data/1.xlsx", "Sheet1");
		
		List<Map<String, String>> allRows = sheet.getDataAsList();
		System.out.println(allRows);
		
		for (int i = 0; i < allRows.size(); i++) {
			Map<String, String> row = allRows.get(i);
			
			if(row.get("Execute").equalsIgnoreCase("Y")) {
				String expectedProduct = row.get("Product");
				assertTrue(homePage.getProduct(expectedProduct).isDisplayed());
			}
		}
	   
	}

	@Then("The details of the product should be correct")
	public void the_details_of_the_product_should_be_correct() {
		HomePage homePage = new HomePage();
		ProductPage prodPage = new ProductPage();
		
		ExcelUtils sheet = new ExcelUtils("src/test/resources/io/duotech/test-data/1.xlsx", "Sheet1");
		
		List<Map<String, String>> allRows = sheet.getDataAsList();
		System.out.println(allRows);
		
		for (int i = 0; i < allRows.size(); i++) {
			Map<String, String> row = allRows.get(i);
			
			if(row.get("Execute").equalsIgnoreCase("Y")) {
				String expectedProduct = row.get("Product");
				
				homePage.getProduct(expectedProduct).click();
				
				String expectedPrice = row.get("Price");
				String expectedModel = row.get("Model");
				String expectedComposition = row.get("Composition");
				String expectedStyle = row.get("Styles");
				
				String actualPrice = prodPage.price.getText();
				String actualModel = prodPage.model.getText();
				String actualComposition = prodPage.composition.getText();
				String actualStyle = prodPage.style.getText();
				
				assertEquals(actualPrice, expectedPrice);
				assertEquals(actualModel, expectedModel);
				assertEquals(actualComposition, expectedComposition);
				assertEquals(actualStyle, expectedStyle);
				
				sheet.setCellData("passed", "Status", i+1);
				Driver.getDriver().navigate().back();
			}else {
				sheet.setCellData("skipped", "Status", i+1);
			}
				
		}
	}
	
	
	

}
