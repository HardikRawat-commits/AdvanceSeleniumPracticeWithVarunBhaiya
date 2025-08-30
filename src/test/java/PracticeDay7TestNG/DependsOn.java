package PracticeDay7TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOn {
		@Test(dependsOnMethods = "test2()")
		public void test1() {
			Reporter.log("This test will run after test 2");
		}
		
		@Test
		public void test2() {
			Reporter.log("This test will run first");
		}
}
