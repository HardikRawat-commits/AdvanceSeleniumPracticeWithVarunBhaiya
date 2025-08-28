package PracticeDay1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchDataFromProperties {
public static void main(String[] args) throws IOException {
	
	//Fetch the data from properties-DESERIALIZATION
	FileInputStream fis=new FileInputStream(
			"C:\\Selenium\\src\\test\\resources\\FileUtility\\CommonData.properties");
	
	Properties pObj=new Properties();
	pObj.load(fis);
	
	String URL=pObj.getProperty("url");
	String UN=pObj.getProperty("username");
	String PWD=pObj.getProperty("password");
	String BROWSER=pObj.getProperty("browser");
	
	WebDriver driver=null;
	
	switch (BROWSER) {
	case "chrome":
		driver=new ChromeDriver();
		break;
	case "firefox":
		driver=new FirefoxDriver();
	
	default:
		driver=new ChromeDriver();
		break;
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(URL);
	
  	}
}
