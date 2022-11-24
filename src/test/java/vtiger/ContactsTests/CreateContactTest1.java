package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericLibrary.BaseClass;
import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaFileLibrary;
import vtiger.GenericLibrary.propertyFileLibrary;
import vtiger.GenericLibrary.webdriverLibrary;
import vtiger.objectRepositery.ContactInfoPage;
import vtiger.objectRepositery.ContactsPage;
import vtiger.objectRepositery.CreateNewContactPage;
import vtiger.objectRepositery.HomePage;
import vtiger.objectRepositery.LoginPage;

public class CreateContactTest1{
	@Test()
	public void createContact()throws Exception {
		JavaFileLibrary jlib=new JavaFileLibrary();
		propertyFileLibrary plib=new propertyFileLibrary();
		webdriverLibrary wlib=new webdriverLibrary();
		ExcelFileLibrary elib=new ExcelFileLibrary();
		
	String BROWSER = plib.readDataFromPropertiesFile("browser");
		String URL = plib.readDataFromPropertiesFile("url");
		String USERNAME = plib.readDataFromPropertiesFile("username");
		String PASSWORD = plib.readDataFromPropertiesFile("password");
		String LastName = elib.readDataFromExcel("Contacts", 4, 2);
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else
		{
			System.out.println("invalid browser");
		}
		wlib.maximiseWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
				lp.logToApp(USERNAME, PASSWORD);
		
		
		HomePage hp=new HomePage(driver);
				hp.clickonContactsLnk();
		
		ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactImg();
		
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
				ccp.CreateNewContact(LastName);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
				String contactheader = cip.getContactHeader();


		if(contactheader.contains(LastName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("Fail");
			
		}
		hp.signOutOfApp(driver);
	}
	


}
