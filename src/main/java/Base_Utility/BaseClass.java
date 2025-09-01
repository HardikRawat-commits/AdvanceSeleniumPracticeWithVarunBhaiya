package Base_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.LoginPage;

public class BaseClass {
	//Global variable declaration
	WebDriver driver;

	public static WebDriver sdriver;
	
	@BeforeSuite
	public void reportConfig() {
		System.out.println("DB connection + Report Configuration");
	}
	
	@BeforeTest
	public void preCondition(){
		System.out.println("Pre conditions");
	}
	
	@BeforeClass
	public void openBrowser() {
		System.out.println("Open the browser");
		driver=new ChromeDriver();
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
			
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserName().sendKeys("admin");
		lp.getPassword().sendKeys("password");
		lp.getLoginButton().click();
	
	}
	
	@Test
	public void vtiger() throws InterruptedException {
		System.out.println("run");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close the browser");
		driver.quit();
		
	}
	
	@AfterTest
	public void postCondition() {
		System.out.println("Post conditions");
	}
	
	@AfterSuite
	public void reportBackup() {
		System.out.println("DB connection close + Report Backup");
	}

	
}