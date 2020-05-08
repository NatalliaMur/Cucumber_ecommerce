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

public class PractisWithExcel {
	
	@Then("Promoted products should be displayed")
	public void promoted_products_should_be_displayed() {
		//Get the promoted products from excel file
		//Veryfy if they are displayd
		
		ExcelUtils sheet = new ExcelUtils("src/test/resources/io/duotech/test-data/1.xlsx", "Sheet1");
		
		HomePage homePage = new HomePage();
		
		List<Map<String, String>> allRows = sheet.getDataAsList(); // I take info from my excel file as List of Maps(name of column and value)
		
		System.out.println(allRows);
		
		for (int i = 0; i < allRows.size(); i++) {
			
			Map<String, String> eachRow = allRows.get(i); // I recognise each row in Excel file
			
			if(eachRow.get("Execute").equalsIgnoreCase("Y")) { // I am checking in Excel if each row from column "Execute" is equal "Y"
				
				String expectedProduct = eachRow.get("Product"); // I am taking each product from Excel from column "Product"
				assertTrue(homePage.getProduct(expectedProduct).isDisplayed()); // Checking if each product from Excel is displayd in the website
				  															   // using getProduct method	
			}
		}
	}

	@Then("The details of the products should be correct")
	public void the_details_of_the_products_should_be_correct() {
		ExcelUtils sheet = new ExcelUtils("src/test/resources/io/duotech/test-data/1.xlsx", "Sheet1");
		
		HomePage homePage = new HomePage();
		ProductPage prodPage = new ProductPage();
		
		List<Map<String, String>> allRows = sheet.getDataAsList(); // I take info from my excel file as List of Maps(name of column and value)
		
		System.out.println(allRows);
		
		for (int i = 0; i < allRows.size(); i++) {
			
			Map<String, String> eachRow = allRows.get(i); // I recognise each row in Excel file
			
			if(eachRow.get("Execute").equalsIgnoreCase("Y")) { // I am checking in Excel if each row from column "Execute" is equal "Y"
				
				String expectedProduct = eachRow.get("Product"); // I am taking each product from Excel from column "Product"
				
				homePage.getProduct(expectedProduct).click(); // I am clicking on each product to see each poduct details
				
				String expectedPrice = eachRow.get("Price"); // I need to get each Price from Excel
				String expectedModel = eachRow.get("Model"); // I need to get each Model from Excel
				String expectedComposition = eachRow.get("Composition"); // I need to get each Composition from Excel
				String expectedStyle = eachRow.get("Styles"); // I need to get each Style from Excel
				
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
				sheet.setCellData("skiped", "Status", i+1);
			}
			
		}
		
		
		
		
	}

}
