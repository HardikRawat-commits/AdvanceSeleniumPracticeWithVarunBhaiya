package PracticeDay7TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	@Test(enabled = false)
	public void thisTestWillNotRun() {
		Reporter.log("This test will not run");
	}
	
	@Test(enabled = true)
	public void thisTestWillRun() {
		Reporter.log("This test will run");
	}
	
}
