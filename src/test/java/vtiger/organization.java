package vtiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class organization {

	public static void main(String[] arg )throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		//step1:launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//step 2:load the application
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		//step3:login to application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type=\'password\']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//step4:navigate to organization link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//step5:create organization with mandatory field
		driver.findElement(By.xpath("//img[@alt=\'Create Organization...\']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("ab");
		
		//step6:save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	//logout
      driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
