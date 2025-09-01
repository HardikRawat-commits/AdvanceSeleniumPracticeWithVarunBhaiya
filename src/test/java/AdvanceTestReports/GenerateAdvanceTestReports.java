package AdvanceTestReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateAdvanceTestReports {

	@Test
	public void addReports() {
//	(1)
	ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Selenium\\src\\test\\resources\\ErrorShots\\Report1.html");
	spark.config().setDocumentTitle("title");
	spark.config().setReportName("report");
	spark.config().setTheme(Theme.STANDARD);
	
//	(2)
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("Browser", "chrome");
	
//	(3)
	ExtentTest test=report.createTest("test");
	test.log(Status.PASS, "Test is pass");
	
	report.flush();
	
	}	
}