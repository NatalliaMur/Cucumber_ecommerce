package io.duotech.step_definitions;

import static org.junit.Assert.*;
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.language.Nysiis;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.duotech.utilities.Driver;
import com.github.javafaker.Faker;

import io.duotech.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.duotech.beans.User;
import io.duotech.pages.CreateAccountPage;
import io.duotech.pages.HomePage;
import io.duotech.pages.LoginPage;
import io.duotech.pages.MyAccountPage;
import io.duotech.utilities.LoggerUtils;

public class LoginStepDefs {
	
	Logger logger = LoggerUtils.getLogger(LoginStepDefs.class);

	@Given("I am on a homepage")
	public void i_am_on_a_homepage() {
		Driver.getDriver().manage().timeouts()
				.implicitlyWait(Long.parseLong(ConfigReader.getConfiguration("implicitTimeout")), TimeUnit.SECONDS);
		Driver.getDriver().get(ConfigReader.getConfiguration("url"));
		logger.info("Navigating to a homepage");
		System.out.println("First connect with remote server");
	}

	@When("I click on Sign in")
	public void i_click_on_Sign_in() {
		HomePage homepage = new HomePage();
		
		logger.info("Cliccking on sign in");
		homepage.signInButton.click();
		

	}

	@Then("The login page title should be Login - My Store")
	public void the_login_page_title_should_be_Login_My_Store() {
		
		logger.info("Getting page title");
		String actual = Driver.getDriver().getTitle();
		String expected = "Login - My Store";
		
		logger.info("Verifying page title");
		assertEquals(actual, expected);
		logger.error("Verification failed");
	}

	@Then("I should be able to see email, password and Sign in button")
	public void i_should_be_able_to_see_email_password_and_Sign_in_button() {
		LoginPage loginPage = new LoginPage();
		assertTrue(loginPage.emailInputBox.isDisplayed());
		assertTrue(loginPage.passwordInputBox.isDisplayed());
		assertTrue(loginPage.signInButton.isDisplayed());
	}

	@When("I enter duotech@gmail.com as email, dt123 as rassword, and click login")
	public void i_enter_duotech_gmail_as_email_dt123_as_rassword_and_click_login() {
		LoginPage loginPage = new LoginPage();

		loginPage.emailInputBox.sendKeys("duotech@gmail.com");
		
		loginPage.passwordInputBox.sendKeys("dt123");
		
		loginPage.signInButton.click();
	}

	@When("I enter {string} as email, {string} as rassword, and click login")
	public void i_enter_as_email_as_rassword_and_click_login(String email, String password) {
		LoginPage loginPage = new LoginPage();

		loginPage.emailInputBox.sendKeys(email);
		
		loginPage.passwordInputBox.sendKeys(password);
		
		loginPage.signInButton.click();
	}

	@Then("I should be able to land on welcome page and read Welcome message")
	public void i_should_be_able_to_land_on_welcome_page_and_read_Welcome_message() {
		MyAccountPage myAccPage = new MyAccountPage();
		String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
		assertEquals(myAccPage.welcomeMessage.getText(), welcomeMessage);
	}

	@When("I enter the following credentials, I should be login")
	public void i_enter_the_following_credentials_I_should_be_login(Map<String, String> combinations) {
		LoginPage loginPage = new LoginPage();
		MyAccountPage myAccPage = new MyAccountPage();
		Set<Entry<String, String>> entrySet = combinations.entrySet();

		for (Entry<String, String> entry : entrySet) {
			String email = entry.getKey();
			String password = entry.getValue();
			loginPage.emailInputBox.sendKeys(email);
			loginPage.passwordInputBox.sendKeys(password);
			loginPage.signInButton.click();

			i_should_be_able_to_land_on_welcome_page_and_read_Welcome_message();

			myAccPage.logMeOut.click();
		}
	}

	@When("I enter valid email and click Create Account")
	public void i_enter_valid_email_and_click_Create_Account() {
		LoginPage loginPage = new LoginPage();
		loginPage.emailCreateAccount.sendKeys(new Faker().internet().emailAddress());
		loginPage.createAccountButton.click();
	}

	@When("I should be able to pass the following data and click on register and see the name")
	public void i_should_be_able_to_pass_the_following(List<User> list) {
		CreateAccountPage cp = new CreateAccountPage();

		cp.firstName.sendKeys(list.get(0).getFirstName());
		cp.lastName.sendKeys(list.get(0).getLastName());
		cp.password.sendKeys(list.get(0).getPassword());
		cp.selectDOB();

		cp.address.sendKeys(list.get(0).getAddress());
		cp.city.sendKeys(list.get(0).getCity());
		cp.selectState();
		cp.zip.sendKeys(list.get(0).getZip());
		cp.phoneNo.sendKeys(list.get(0).getPhone());

		cp.registerButton.click();

		String expected = list.get(0).getFirstName() + " " + list.get(0).getLastName();
		String actual = new MyAccountPage().customerName.getText();
		assertEquals(expected, actual);

		for (User user : list) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getAddress() + " "
					+ user.getCity() + " " + user.getZip() + " " + user.getPhone());
		}
		MyAccountPage myAccPage = new MyAccountPage();
	    myAccPage.logMeOut.click();
	}
	
	@When("I enter valid {string} and click Create Account")
	public void i_enter_valid_and_click_Create_Account(String email) {
		LoginPage loginPage = new LoginPage();
		loginPage.emailCreateAccount.sendKeys(email);
		loginPage.createAccountButton.click();

	}
	

}
	
	
	
