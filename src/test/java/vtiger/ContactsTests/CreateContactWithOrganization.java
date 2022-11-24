package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaFileLibrary;
import vtiger.GenericLibrary.propertyFileLibrary;
import vtiger.GenericLibrary.webdriverLibrary;

public class CreateContactWithOrganization {
	public static void main(String[] args) throws Exception {
		JavaFileLibrary jLib=new JavaFileLibrary();
		propertyFileLibrary pLib=new propertyFileLibrary();
		ExcelFileLibrary eLib=new ExcelFileLibrary();
		webdriverLibrary wLib=new webdriverLibrary();
		
		String BROWSER = pLib.readDataFromPropertiesFile("browser");
		String URL = pLib.readDataFromPropertiesFile("url");
		String USERNAME = pLib.readDataFromPropertiesFile("username");
		String PASSWORD = pLib.readDataFromPropertiesFile("password");
		
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else
		{
			System.out.println("invalid browser");
		}
		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println( orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("organization created");
		}
		else
		{
			System.out.println("organization not created");
			wLib.takeScreenShot(driver, "createContactWithOrganization");
		}
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//input[@name='account_name' ] /following-sibling::img[@language='javascript']")).click();
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		wLib.switchToWindow(driver, "Contacts");
		
		driver.findElement(By.xpath("  //input[@title='Save [Alt+S]']")).click();
		String contactHeader = driver.findElement(By.xpath("  //span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		WebElement adminImg = driver.findElement(By.xpath("  //img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminImg);
		driver.findElement(By.xpath("  //a[text()='Sign Out']")).click();
	}

}
