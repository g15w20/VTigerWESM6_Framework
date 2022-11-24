package vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericLibrary.BaseClass;
import vtiger.objectRepositery.ContactInfoPage;
import vtiger.objectRepositery.ContactsPage;
import vtiger.objectRepositery.CreateNewContactPage;
import vtiger.objectRepositery.HomePage;

public class AssertCreateCon extends BaseClass{
	@Test()
	public void createContact() throws Exception
	{
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLnk();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String CONHEADER = cip.getContactHeader();
		Assert.assertTrue(CONHEADER.contains(LASTNAME));
		
		
		
	}
	@Test()
	public void createName()
	{
		System.out.println("Gowtham");
		Assert.fail();
		System.out.println("9666669901");
	}
	
	@Test()
	public void createPerson()
	{
		System.out.println("Person Created");
	}
	
	
	@Test()
	public void createPersonWithPhoneNum()
	{
		System.out.println("Person Created and Phone number Created");
	}

}
