package io.duotech.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private Driver() {
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigReader.getConfiguration("browser"); // I removed this step because my headless 
			switch (browser) {											// have Upercase -->.toLowerCase();
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "headlessChrome":
				WebDriverManager.chromedriver().setup();
				final ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless"); 
				options.addArguments("--disable-gpu");// only for Windows!!! for Mac and Linux doesn't need this option
				driver = new ChromeDriver(options); // my browser is going to run in Chrome mode
				break;
			case "headlessFirefox":
				WebDriverManager.firefoxdriver().setup();
				final FirefoxOptions fireOptions = new FirefoxOptions();
				fireOptions.addArguments("--headless"); 
				driver = new FirefoxDriver(fireOptions); // my browser is going to run in Firefox mode
				break;
			case "phantomJS":
				WebDriverManager.phantomjs().setup();
				driver = new PhantomJSDriver();
				break;
			case "htmlUnit":
				driver = new HtmlUnitDriver(true);// true--> enables Javascript, if you use Javascript it will fail
				break;
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null; // Sets the driver to null explicitly, to be sure that my driver close
		}
	}

}
