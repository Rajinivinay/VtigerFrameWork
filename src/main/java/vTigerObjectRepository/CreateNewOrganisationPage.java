package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganisationPage extends WebDriverLibrary {
	@FindBy(name="accountname")
	private WebElement organisationname;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	@FindBy(name="button")
	private WebElement saveBtn;
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	public WebElement getOrganisationname() {
		return organisationname;
	}
		public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
		
		public WebElement getTypeDropDown() {
			return typeDropDown;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
	public void CreateNewOrganisation(String orgname) {
		organisationname.sendKeys(orgname);
		
		saveBtn.click();
	}
	public void CreateNewOrganisation(String org, String indType) {
		organisationname.sendKeys(org);
		handleDropDown(indType,industryDropDown);
		saveBtn.click();
		}
	public void CreateNewOrganisation(String orgName,String indType,String type) {
		organisationname.sendKeys(orgName);
		handleDropDown(indType,industryDropDown);
		handleDropDown(type,typeDropDown);
		
	}

	
		
	

}
