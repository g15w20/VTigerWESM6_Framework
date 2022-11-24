package vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractise {
	@Test()
	public void createCustomer()
	{
		
		System.out.println("customer Created");
	}

	@Test()
	public void modifyCustomer()
	{
		
		System.out.println("customer Modified");
	}

	@Test()
	public void deleteCustomer()
	{
		System.out.println("customer Deleted");
	}

}
