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

public class CreateContact {
	public static void main(String[] args) throws Exception {
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
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactheader);
		if(contactheader.contains(LastName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("Fail");
			
		}
		WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverOn(driver, adminimg);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	}
	

}
