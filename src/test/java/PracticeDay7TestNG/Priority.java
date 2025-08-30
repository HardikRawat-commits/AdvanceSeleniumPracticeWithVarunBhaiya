package PracticeDay7TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {
	//yaha par main class ki jagah @Test annotation ka use ho raha hai
	
		@Test(priority = 2)
		public void stepTwo() {
			Reporter.log("Second test");
		}
		
		@Test(priority = 1)
		public void stepOne() {
			Reporter.log("First test");
		}
		
		@Test(priority = 3)
		public void stepThree() {
			Reporter.log("Third test");
		}
	}