package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class createContactWithDDT {
	public static <WebElement> void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		
		WebDriver driver=null;
	
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("===browser"+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			System.out.println("===browser"+BROWSER);
		}
		else
		{
			System.out.println("no such browser");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	     driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	     driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	     
	     driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	     driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ammu");
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
	}

}
