package io.duotech.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.pages.LoginPage;
import io.duotech.pages.MyAddressPage;
import io.duotech.utilities.DatabaseUtils;

public class VerifyUserInfoFromDatabaseStepDefs {
	
//	@Given("I have connected to the database")
//	public void i_have_connected_to_the_database() {
//	    DatabaseUtils.createConnection();
//	    System.out.println("Connection succes!");
//	}

	@When("I click on My Address book")
	public void i_click_on_My_Address_book() {
		LoginPage logPage = new LoginPage();
		logPage.myAddress.click();
	  
	}

	@Then("user info related to the email {string} should match the info in the database")
	public void user_info_related_to_the_email_should_match_the_info_in_the_database(String string) {
// Grab info from UI
		
		MyAddressPage myAddrPage = new MyAddressPage();
		System.out.println(myAddrPage.firstName.getText());
		String actualFirstName = myAddrPage.firstName.getText();
		String actualLastName = myAddrPage.lastName.getText();
		String actualAddress = myAddrPage.address.getText();
		String actualCity = myAddrPage.city.getText().replace(",", "");
		String actualState = myAddrPage.state.getText();
		String actualZip = myAddrPage.zip.getText();
		
//Expected from Database
//Actual from UI		
		
		// I need to send query to DB
		// I don't work with DB directly. I can get the info from DB and save into a List of Maps
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap("select * from users where email = '"+string+"'");
		System.out.println(queryResultMap);											// I need to indicate which exactly email is interested for me
		
// This just for test		
//		for (Map<String, Object> map : queryResultMap) { //comes fron DB
//			if(map.get("email").equals(string)) {
//				
//			assertEquals(map.get("first_name"), actualFirstName);
//			assertEquals(map.get("last_name"), actualLastName);
//			assertEquals(map.get("address"), actualAddress);
//			assertEquals(map.get("city"), actualCity);
//			assertEquals(map.get("state"), actualState);
//			assertEquals(map.get("zip").toString(), actualZip);
//			}
//		}
		
		System.out.println(queryResultMap.get(0)); // This is Map, because of this I should start from 0 index!!! Not with index 1
		
		Map<String, Object> row = queryResultMap.get(0);
		
		assertEquals(row.get("first_name"), actualFirstName);
		assertEquals(row.get("last_name"), actualLastName);
		assertEquals(row.get("address"), actualAddress);
		assertEquals(row.get("city"), actualCity);
		assertEquals(row.get("state"), actualState);
		assertEquals(row.get("zip").toString(), actualZip);
	}
	
	

}
