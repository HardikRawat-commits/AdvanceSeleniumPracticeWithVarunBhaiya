package PracticeDay12TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithHardAssert {
		
	@Test
	public void case1() {
		
		String a="Hardik";
		String b="Hardik";
		String c="Varun";
		
//		Hard Assert All 6 Methods:-
//		Assert.assertEquals(a, b);
//		Assert.assertNotEquals(a, c);		
//		Assert.assertTrue(a.equals(b));
//		Assert.assertFalse(a.equals(c));
//		Assert.assertNull(obj1);
//		Assert.assertNotNull(obj2);

		
		Assert.assertEquals(a, b);
		Assert.assertNotEquals(a, c);
		System.out.println("Assert equals method done");
	
		Assert.assertTrue(a.equals(b));
		Assert.assertFalse(a.equals(b));
//		Assert.assertFalse(a.equals(b));
		Assert.assertFalse(a.equals(c));
		System.out.println("Assert boolean methods done");
		
		Object obj1=null;
		Object obj2=new Object();
		
		Assert.assertNull(obj1);
		Assert.assertNotNull(obj2);
		System.out.println("Assert null methods done");
		
		
		
	}
}
