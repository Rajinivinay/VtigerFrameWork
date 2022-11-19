package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
	@FindBy(linkText="Organizations")
	private WebElement organizationlnk;
	@FindBy(linkText="Contacts")
	private WebElement contactlnk;
	@FindBy(linkText="Products")
	private WebElement productlnk;
	@FindBy(linkText="Opportunities")
	private WebElement ooportunitieslnk;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministartorImg;
	@FindBy(linkText="Sign Out")
	private WebElement signoutlnk;
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	public WebElement getOrganizationlnk() {
		return organizationlnk;
	}
	public WebElement getContactlnk() {
		return contactlnk;
	}
	public WebElement getProductlnk() {
		return productlnk;
	}
	public WebElement getOoportunitieslnk() {
		return ooportunitieslnk;
	}
	public WebElement getAdministartorImg() {
		return AdministartorImg;
	}
	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	public void ClickOrganizationlnk() {
		organizationlnk.click();
		}
	public void ClickContactLink() {
		contactlnk.click();
		
	}
	public void SignoutofApp(WebDriver driver) {
		mouseHoverOn(driver,AdministartorImg);
		signoutlnk.click();
	}
	
    
}
