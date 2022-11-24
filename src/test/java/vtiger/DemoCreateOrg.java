package vtiger;

import org.testng.annotations.Test;

import vtiger.GenericLibrary.BaseClass;

public class DemoCreateOrg extends BaseClass {
	@Test()
	public void createOrg()
	{
		System.out.println("Org created");
	}
	@Test()
	public void orgNameCreated()
	{
		System.out.println("Org name is created");
	}

}
