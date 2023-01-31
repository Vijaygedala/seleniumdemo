package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;
public class fourTest extends Base{
	public WebDriver driver;
	@Test
	public void Four() throws InterruptedException, IOException {
		System.out.println("karannnn updated this statment");
		System.out.println("fourrrr");
		 driver=initializeDriver();
		 driver.get("http://www.tutorialsninja.com/demo/");
		 Thread.sleep(2000);
		 Assert.assertTrue(false);
	
	}
@AfterMethod
	public void  clouse() {
		driver.close();	
	}
	
	

}
