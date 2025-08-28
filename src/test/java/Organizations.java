import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.LoginPage;
import PracticeDay3.FileUtility;
import PracticeDay3.WebDriverUtility;

public class Organizations {
	
	public static void main(String[] args) throws IOException {
		
		//FileUtility ka object creation jisse data fetch karna hai
		//Excel and properties file
		FileUtility fileUtil=new FileUtility();
		
		String URL= fileUtil.getDataFromPropertiesFile("url");
		String UN= fileUtil.getDataFromPropertiesFile("username");
		String PWD= fileUtil.getDataFromPropertiesFile("password");
		String BROWSER= fileUtil.getDataFromPropertiesFile("browser");
		
		WebDriver driver=null;
		
		switch (BROWSER) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default:
			driver=new ChromeDriver();
			break;
		}
		
		//WebdriverUtility ka object create kiya hai
		//taaki uske resuable methods ko use kar sake 
		WebDriverUtility wdUtil=new WebDriverUtility(driver);
		
		wdUtil.maximizeWindow();
		wdUtil.waitForPageLoad();
	    
		driver.get(URL);
		
		//Yaha par hamne POM page ko access kiya hai 
		//or implement kiya hai
		LoginPage lp=new LoginPage(driver);
		lp.getUserName().sendKeys(UN);
		lp.getPassword().sendKeys(PWD);
		lp.getLoginButton().click();
		
		//Now we have to login to the V-Tiger
		//Access the login page
		wdUtil.DeadWait(5000);
		wdUtil.closeBrowser();
		
		
	}
	
}