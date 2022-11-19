package vTigerContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.ContactInfoPage;
import vTigerObjectRepository.ContactPage;
import vTigerObjectRepository.CreateNewContactPage;
import vTigerObjectRepository.CreateNewOrganisationPage;
import vTigerObjectRepository.HomePage;
import vTigerObjectRepository.LoginPage;
import vTigerObjectRepository.OrganizationPage;
import vTigerObjectRepository.organizationInfoPage;
import vtiger.GenericLibrary.BaseClass;
import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaLibraries;
import vtiger.GenericLibrary.PropertyFileLibrary;
import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateContactWithOrganisationTest extends BaseClass {
  @Test(groups="smokeSuite")
  public void createContactWithOrganisationTest() throws IOException {
		
	    String LASTNAME = eLib.readDataFromExcel("Contact", 4, 2) + jLib.getRandomNumber();
		String ORGNAME = eLib.readDataFromExcel("Contact", 4, 3)+jLib.getRandomNumber();
	   	    
	   
	    //step2:navigate to organisation link
	    HomePage hp=new HomePage(driver);
	    hp.ClickOrganizationlnk();
	    Reporter.log("organisation link is created",true);
	    //step3:navigate to organisation
	    OrganizationPage op=new OrganizationPage(driver);
	    op.clickonCreateOrganizationimg();
	    Reporter.log("organisation  is created",true);
	    //step4:create new organization and save
	    CreateNewOrganisationPage cop=new CreateNewOrganisationPage(driver);
	    cop.CreateNewOrganisation(ORGNAME);
	    Reporter.log("organisation  is created and saved",true);
	    //step5:validation for organisation
	    organizationInfoPage oip=new organizationInfoPage(driver);
	   String orgHeader= oip.getorganisationHeaderText();
	   Assert.assertTrue(orgHeader.contains(ORGNAME),"organisation created");
	    Reporter.log("organisation  is created sucessfully",true);
	   //steps6:navigate to contact link
	   hp.ClickContactLink();
	   //step7:navigate to create contact lookup img
	   ContactPage cp=new ContactPage(driver);
	   cp.ClickonCreateContactImg();
	   //step8:create cobntact with ,mandatory fields
	   CreateNewContactPage cnp=new CreateNewContactPage(driver);
	   cnp.CreateNewContact(LASTNAME,ORGNAME,driver);
	   //step9:validate for contact
	   ContactInfoPage cip=new ContactInfoPage(driver);
	  String contactHeader=cip.getContactHeader();
	  Assert.assertTrue(contactHeader.contains(LASTNAME),"contact created");
	  
	}}