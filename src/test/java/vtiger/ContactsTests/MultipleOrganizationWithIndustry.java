package vtiger.ContactsTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleOrganizationWithIndustry {
	@Test(dataProvider = "org")
	public void addOrgAndInd(String OrgName,String Industry) {
		System.out.println("Organization"+OrgName+"Industry"+Industry);
	}
	@DataProvider(name="org")
	public Object[][] getData()
	{
		Object[][] data=new Object[4][2];
		data[0][0]="Qspiders";
		data[0][1]="Healthcare";
		
		data[1][0]="Allstates";
		data[1][1]="Education";
		
		data[2][0]="Wipro";
		data[2][1]="Energy";
		
		data[3][0]="Infosys";
		data[3][1]="Eletronics";
		
		
		
		return data;
		
	}

}
