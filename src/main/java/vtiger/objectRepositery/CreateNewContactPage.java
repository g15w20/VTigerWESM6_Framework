package vtiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.webdriverLibrary;

public class CreateNewContactPage extends webdriverLibrary {
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img[@title='Select']")
	private WebElement origanizationImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
     @FindBy(xpath = "//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;

	//initialization
     public CreateNewContactPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getOriganizationImg() {
		return origanizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
     
     
     
     
     
     //BusinessClass
	
	/**
	 * this method will create new contact
	 * @param lastname
	 */
	public void  CreateNewContact(String lastname)
	{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	public void CreateNewContact(String lastname,String leadsourceValue)
	{
		lastNameEdt.sendKeys(lastname);
		handleDropDown(leadsourceDropDown, leadsourceValue);
		
		saveBtn.click(); 
	}
	


}
