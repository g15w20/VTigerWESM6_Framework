package vtiger.GenericLibrary;

import java.io.IOException;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.objectRepositery.HomePage;
import vtiger.objectRepositery.LoginPage;

public class BaseClass {
	       public propertyFileLibrary pLib=new propertyFileLibrary();
	       public JavaFileLibrary jLib=new JavaFileLibrary();
	       public ExcelFileLibrary eLib=new ExcelFileLibrary();
	       public webdriverLibrary wLib=new webdriverLibrary();
	       public WebDriver driver=null;
	       public static WebDriver sDriver=null;
			
			@BeforeSuite()
			public void bsConfig()
			{
				System.out.println("----database connected sucessfully---");
			}
			
			//@Parameters("browser")
			@BeforeClass()
			public void bcConfig(/*String BROWSER*/) throws Exception
			{
				String BROWSER = pLib.readDataFromPropertiesFile("browser");
				String URL = pLib.readDataFromPropertiesFile("url");
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					System.out.println("----Browser launched sucessfully---"+BROWSER+"----");
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					System.out.println("----browser launched sucessfully"+BROWSER+"-----");
					
				}
				else
				{
					System.out.println("invalied Browser");
				}
				sDriver=driver;
				wLib.maximiseWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(URL);
			}
			
				
			@BeforeMethod()
			public void bmConfig() throws Exception 
			{
					String USERNAME = pLib.readDataFromPropertiesFile("username");
					String PASSWORD = pLib.readDataFromPropertiesFile("password");
					LoginPage lp=new LoginPage(driver);
					lp.logToApp(USERNAME, PASSWORD);
					System.out.println("---Login Sucessful---");
			}
			
			
			@AfterMethod()
			public void amConfig()
			{
				HomePage hp=new HomePage(driver);
				hp.signOutOfApp(driver);
				System.out.println("---Sign out Sucessfully----");
			}
			
			
			@AfterClass()
			public void acConfig()
			{
				driver.quit();
				System.out.println("----Browser closed Sucessfully----");
			}
			
			
			@AfterSuite()
			public void asConfig()
			{
				System.out.println("----SignOut from database sucessfully---");
			}
			
			}
			
			
			


