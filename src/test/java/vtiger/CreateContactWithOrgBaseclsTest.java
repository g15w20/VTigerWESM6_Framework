package vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericLibrary.BaseClass;
import vtiger.objectRepositery.ContactInfoPage;
import vtiger.objectRepositery.ContactsPage;
import vtiger.objectRepositery.CreateNewContactPage;
import vtiger.objectRepositery.CreateNewOrganizationPage;
import vtiger.objectRepositery.HomePage;
import vtiger.objectRepositery.OrganizationInfoPage;
import vtiger.objectRepositery.OrganizationsPage;

public class CreateContactWithOrgBaseclsTest extends BaseClass{
	@Test(groups = "regressionSuite")
	public void createContactWithOrgTest() throws Exception, Exception
	{
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationLnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrganizationImg();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrganization(ORGNAME);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("organization created sucessfully");
		}
		else
		{
			System.out.println("organization not created");
		}
		hp.clickonContactsLnk();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
	    ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		
		
		
		if(contactHeader.contains(LASTNAME)) {
			System.out.println(contactHeader);
			System.out.println("pass");
			
		}
		else
		{
			System.out.println();
		}
		
		
				
		
	}

}
