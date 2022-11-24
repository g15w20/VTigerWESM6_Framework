package vtiger.objectRepositery;

import java.text.StringCharacterIterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//1.create a seperate java  class for every web page
	
	//2.identify the elements using @FindBy,@FindAll,@FindBys
	@FindBy(name="user_name")
     private	WebElement userNameEdt;
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	 private WebElement passWordEdt;
	@FindBy(id="submitButton")
     private	WebElement loginBtn;
	
	//3.create a constructor to initialise these variables
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//4.provide a getter method to axcess these variables
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPassWordEdt() {
		return passWordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Business Library
	/**
	 * This method will perform Login Operation
	 * @param username
	 * @param password
	 */
	public void logToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
}
