package PracticeDay13Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_Utility.BaseClass;

@Listeners(ListenersUtility.ListenersImplementation.class)


public class DemoTest extends BaseClass {

	WebDriver sdriver;
	@Test
	public void vtiger() {
		Assert.assertTrue(false);
	}

	@Test
	public void vtiger2() {
		Assert.assertTrue(true);
	}

	@Test
	public void vtiger3() {
		Assert.assertTrue(true);
	}
}
