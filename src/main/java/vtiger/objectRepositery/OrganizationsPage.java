package vtiger.objectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationImg;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateOrganizationImg() {
		return createOrganizationImg;
	}
	
	//BusinessClass
	public void clickOnCreateOrganizationImg() {
		createOrganizationImg.click();
	}

}
