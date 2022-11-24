package vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericLibrary.BaseClass;
import vtiger.objectRepositery.CreateNewOrganizationPage;
import vtiger.objectRepositery.HomePage;
import vtiger.objectRepositery.OrganizationInfoPage;
import vtiger.objectRepositery.OrganizationsPage;

public class AssertCreateOrg extends BaseClass {
	@Test()
	public void createOrg() throws Exception
	{
		String ORGNAME = eLib.readDataFromExcel("organization", 4, 2)+jLib.getRandomNumber();
		
		
		        HomePage hp=new HomePage(driver);
				hp.clickonOrganizationLnk();
				
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrganizationImg();
				
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.CreateNewOrganization(ORGNAME);
				
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String ORGHEADER = oip.getOrganizationHeader();
				Assert.assertTrue(ORGHEADER.contains(ORGNAME), "Organization Created");
				
			
			
				
		
	}

}
