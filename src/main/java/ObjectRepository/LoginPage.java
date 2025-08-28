package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//POM[Page Object Model]
	
	//(1)Initialize the web element
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//(2)Locate all the webelements with the help of @findBy annotations
	@FindBy(name = "user_name")
	private WebElement UserName;
	
	@FindBy(name = "user_password")
	private WebElement Password;


	@FindBy(id = "submitButton")
	private WebElement LoginButton;	
	

	//(3)Generate getters 
	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
}