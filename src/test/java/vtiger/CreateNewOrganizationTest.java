package vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericLibrary.BaseClass;
import vtiger.objectRepositery.CreateNewOrganizationPage;
import vtiger.objectRepositery.HomePage;
import vtiger.objectRepositery.OrganizationInfoPage;
import vtiger.objectRepositery.OrganizationsPage;
@Listeners(vtiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateNewOrganizationTest extends BaseClass{
	
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
				
			 if(ORGHEADER.contains(ORGNAME))
			 {
				 System.out.println("Pass ORGANIZATION");
			 }
			 else
			 {
				 System.out.println("Fail");
			 }
				
				
		
	}

}
