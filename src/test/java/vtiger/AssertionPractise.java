package vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPractise {
	@Test()
	public void testScript()
	{
		Assert.assertEquals(true, true);
       System.out.println("Script");		
	}
	
	@Test()
	public void testScript1()
	{
		Assert.assertEquals(false, true);
       System.out.println("Script1");		
	}
	
	@Test()
	public void testScript2()
	{
		Assert.assertTrue(true);
       System.out.println("Script2");		
	}
	
	@Test()
	public void testScript3()
	{
		Assert.assertTrue(false);
       System.out.println("Script3");		
	}
	

}
