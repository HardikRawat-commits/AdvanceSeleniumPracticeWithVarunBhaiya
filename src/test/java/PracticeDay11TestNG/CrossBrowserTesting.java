package PracticeDay11TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;

public class CrossBrowserTesting {
	
	//Configuration annotations
	
	WebDriver driver=null;
	
	@BeforeSuite
	public void configRep() {
		//This is done by the senior position employee
		//we don't need to do this
		System.out.println("DB connectivity + Report configurations");
	}
	
	@BeforeTest
	public void preConditions() {
		//This is done by the senior position employee
		//we don't need to do this
		System.out.println("Pre conditions + Prior data ");
	}
	
	@Parameters("browser")
	@BeforeClass
	public void openBro(String bro) {
		
	
		String BROWSER=bro;
		System.out.println("Open the browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login");
		
		
		driver.get("http://49.249.28.218:8888/");
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserName().sendKeys("admin");
		lp.getPassword().sendKeys("admin");
		lp.getLoginButton().click();
		
	}
	
	@Test
	public void case1Test() throws InterruptedException {
		System.out.println("Organization created and verified successfully!!!");
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("logout");
		}
	
	@AfterClass
	public void closeBro() throws InterruptedException {
		System.out.println("close the browser");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void postCon() {
		System.out.println("Post condition");
	}
	
	@AfterSuite
	public void repBackup() {
		System.out.println("DB close + Report Backup");
	}

	
	
}
