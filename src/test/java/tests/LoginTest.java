package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

//import Base from resources>>importing Base from main java	
	public WebDriver driver;
	Logger log;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {

		

		LandingPage landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("clicked on MyAccount dropdown ");
		landingpage.loginOption().click();
		log.debug("clicked on login option");
Thread.sleep(3000);
		LoginPage loginpage = new LoginPage(driver);
		// loginpage.emailfield().sendKeys("vijay2@gmail.com");
		loginpage.emailfield().sendKeys(email);
		log.debug("entered email ");
		loginpage.passwordField().sendKeys(password);
		log.debug("entred password");
		loginpage.loginButton().click();
		AccountPage accountpage = new AccountPage(driver);

		String actualResult = null;

		try {
			if (accountpage.conformation().isDisplayed()) {
				log.debug("user logged sucessfull ");
				actualResult = "sucessfull";
			}
		} catch (Exception e) {
			log.debug("user didnt log in ");
			actualResult = "failure";
		}

		Assert.assertEquals(actualResult, expectedStatus);

	}

	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("browser launched");
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void teardown() {
		driver.close();
		log.debug("driver closed");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "vijay2@gmail.com", "123456", "sucessfull" },
				 };
		//{ "viajayyy@gmail.com", "1234555", "failure" }
		return data;
	}

}
