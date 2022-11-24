package vtiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;
	
	//initialization
	public ContactInfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	}
  
	//utilization
	 
	public WebElement getContactHeaderTxt() {
		return ContactHeaderTxt;
	}
	
	//BusinessClss
	
	
	/**
	 * This method will return the HeaderText to the caller
	 * @return
	 */
	public String getContactHeader() {
		return ContactHeaderTxt.getText();
	}
	
	
	
}
