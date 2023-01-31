package stepdefinationss;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	AccountPage accountpage;
	
	@Given("^open any browser$")
	public void open_any_browser() throws IOException {
		driver = initializeDriver();

	}

	@And("^navigate to login page$")
	public void navigate_to_login_page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.loginOption().click();
		Thread.sleep(3000);

	}

	@When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\" in ti the fields$")
	public void user_enters_username_as_something_and_password_as_something_in_ti_the_fields(String email,
			String password) {

		 loginpage = new LoginPage(driver);
		loginpage.emailfield().sendKeys(email);
		loginpage.passwordField().sendKeys(password);
		
		
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		loginpage.loginButton().click();

	}

	@Then("^verify user is able to login sucessfully or not$")
	public void verify_user_is_able_to_login_sucessfully_or_not() {
		 accountpage = new AccountPage(driver);

		Assert.assertTrue(accountpage.conformation().isDisplayed());

	}
	@After
	public void closebrowser() {
		driver.close();
		
	}

}