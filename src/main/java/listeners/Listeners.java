package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners  extends Base implements ITestListener {
	 public WebDriver driver;
	 ExtentReports extentReport = ExtentReporter.getextentReport();
	 ExtentTest extentTest;
	 ThreadLocal<ExtentTest> extentTestthread=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		 extentTest = extentReport.createTest(testName);
		 extentTestthread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		//extentTest.log(Status.PASS, testName);//replacing to make thread safe
		extentTestthread.get().log(Status.PASS, testName);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 driver = null;
		String testName = result.getName();
		//extentTest.fail(result.getThrowable());
		extentTestthread.get().fail(result.getThrowable());
		
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
				}catch (Exception e) {
					e.printStackTrace();
					
				}
	
		try {
			String screenshort=takeScreenShot(testName,driver);
			extentTestthread.get().addScreenCaptureFromPath(screenshort, testName);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	
	
	
	
	

}
