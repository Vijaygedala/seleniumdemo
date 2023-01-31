package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	WebDriver driver;
	static ExtentReports extentReport;
	
	
	@BeforeMethod
	// we are making method static so we can use with classname.staticmethod()
	public static ExtentReports getextentReport() {
		
		String path = System.getProperty("user.dir")+"\\reports\\vijay.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Tutorial ninja Automation results");
		report.config().setDocumentTitle("Test Reports");
		
		extentReport =new ExtentReports();
		extentReport.attachReporter(report);
		extentReport.setSystemInfo("operating system","windows 10");
		extentReport.setSystemInfo("tested by","vijay ");
		
 return extentReport;
}
}