package vtiger;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.objectRepositery.LoginPage;

public class PomPractise {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		LoginPage lp=new LoginPage(driver);
	//	lp.getUserNameEdt().sendKeys("admin");
    //  lp.getPassWordEdt().sendKeys("admin");
	//lp.getLoginBtn().click();
		lp.logToApp("admin","admin");
		
	}

}
