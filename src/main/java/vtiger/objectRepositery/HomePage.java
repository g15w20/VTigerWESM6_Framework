package vtiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.webdriverLibrary;

public class HomePage extends webdriverLibrary {
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText ="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdmistractorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	//Utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdmistractorImg() {
		return AdmistractorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//BusinessClass 
	/**
	 * This method will click on organization link
	 */
	public void clickonOrganizationLnk()
	{
		OrganizationsLnk.click();
	}
	/**
	 * This method will click on Contacts Link
	 */
	public void clickonContactsLnk()
	{
		ContactsLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, AdmistractorImg);
		SignOutLnk.click();
	}

	
	
	
	
	
	

}
