package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class OrganizationPage extends WebDriverLibrary {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement lookupicon;
	public  OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLookupicon() {
		return lookupicon;
	}
	public void clickonCreateOrganizationimg() {
		lookupicon.click();
	}
	

}
