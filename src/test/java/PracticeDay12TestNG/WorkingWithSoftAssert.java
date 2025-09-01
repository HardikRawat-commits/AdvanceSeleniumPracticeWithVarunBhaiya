package PracticeDay12TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithSoftAssert {
		
	
		//	Soft Assert All 6 Methods:-
		//	Assert.assertEquals(a, b);
		//	Assert.assertNotEquals(a, c);		
		//	Assert.assertTrue(a.equals(b));
		//	Assert.assertFalse(a.equals(c));
		//	Assert.assertNull(obj1);
		//	Assert.assertNotNull(obj2);
		//	Assert.assertAll();
	@Test
	public void case1() {
		
		SoftAssert sa=new SoftAssert();
		String a="Hardik";
		String b="Hardik";
		String c="Nikhil";
		
		sa.assertEquals(a, b);
		sa.assertNotEquals(a, b);
		System.out.println("Assert equals methods done");
		
		sa.assertTrue(a.equals(b));
		sa.assertFalse(a.equals(b));
		sa.assertTrue(a.equals(c));
		sa.assertFalse(a.equals(c));
		System.out.println("Assert boolean methods done");
		
		Object obj1=null;
		Object obj2=new Object();
		
		sa.assertNull(obj1);
		sa.assertNotNull(obj2);
		System.out.println("Assert null methods done");
		
//		It should be always last line of the code
		sa.assertAll();

		
	}
	
}