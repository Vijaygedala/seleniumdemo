package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	 public WebDriver driver;
	@Test
	public void three() throws IOException, InterruptedException {
		System.out.println("threeeeee");
		  driver=initializeDriver();
		 driver.get("http://www.tutorialsninja.com/demo/");
		 Thread.sleep(2000);
	driver.close();	
	}

}
