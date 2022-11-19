package vTigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	@FindBy(name="leadsource")
    private WebElement leadSourceDropDown;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement organisationImg;
	@FindBy(name="search_text")
	private WebElement searchEdt;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	public WebElement getOrganisationImg() {
		return organisationImg;
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
	public void CreateNewContact(String lastname) {
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	public void CreateNewContact(String lastname,String leadSourcevalue) {
		lastNameEdt.sendKeys(lastname);
		handleDropDown(leadSourceDropDown,leadSourcevalue);
		saveBtn.click();
		
		
	}
	public void CreateNewContact(String lastname,String orgName,WebDriver driver) {
		lastNameEdt.sendKeys(lastname);
		organisationImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		
		
		
	}
	
}
