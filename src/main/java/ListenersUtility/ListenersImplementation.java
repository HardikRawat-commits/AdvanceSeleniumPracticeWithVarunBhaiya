package ListenersUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base_Utility.BaseClass;

public class ListenersImplementation implements ITestListener,ISuiteListener  {

	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Database conn + rep config");
		
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH-mm-ss__dd-MM-yyyy");
	    String time=now.format(dtf);
	    
//	    (1)
	    ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Selenium\\ErrorShots\\"+time+".html");
	    
	    spark.config().setDocumentTitle("Advance Java Selenium Practice");
	    spark.config().setReportName("Proficient");
	    spark.config().setTheme(Theme.STANDARD);

//	    (2)
	    reports=new ExtentReports();
	    reports.attachReporter(spark);
	    
	    reports.setSystemInfo("Browser", "chrome");
	    reports.setSystemInfo("window", "11");
		reports.setSystemInfo("IDE", "Eclipse");
	    
	
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		
	String methodName=result.getMethod().getMethodName();
	Reporter.log(methodName + "started executing" );
	test=reports.createTest(methodName);
	
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " got passed");
		test.log(Status.PASS, "This is passing");
	
	
	}
	@Override
	public void onTestFailure(ITestResult result) {
	
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName + "Got Failed and need to take the screenshot");
		
		TakesScreenshot tks=(TakesScreenshot) BaseClass.sdriver;
		String ss=tks.getScreenshotAs(OutputType.BASE64);
		test.log(Status.FAIL, "This is failing");
		test.addScreenCaptureFromBase64String(ss,methodName);
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName + "This is skipped");
		
	
	}
	
	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Database close + rep backup");
		reports.flush();
	
	
	}
	
}