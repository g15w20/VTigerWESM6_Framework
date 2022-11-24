package vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractiSoft {
	
	@Test()
	public void demo()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		sa.assertEquals(true, true);
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();
	}
	
	@Test()
	public void demo1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		sa.assertEquals(false, true);
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();
	}
	
	@Test()
	public void demo2()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		sa.assertEquals(false, true);
		System.out.println("Step4");
		System.out.println("Step5");
	
	}
	
	@Test()
	public void demo3()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		sa.assertTrue(true);
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();
	}
	
	@Test()
	public void demo4()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		sa.assertTrue(false);
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();
	}
	
	@Test()
	public void demo5()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertTrue(false);
		System.out.println("Step3");
		sa.assertEquals(true, true);
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();
	}
	
	@Test()
	public void demo6()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertTrue(false);
		System.out.println("Step3");
		sa.assertEquals(true, true);
		System.out.println("Step4");
		System.out.println("Step5");
		
	}

}
