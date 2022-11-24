package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithDDt1 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contacts");
		Row rw = sh.getRow(4);
		Cell ce = rw.getCell(2);
		String LastName = ce.getStringCellValue();
		
		
	
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
	     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	     
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
