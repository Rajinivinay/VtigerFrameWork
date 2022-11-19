 package vTigerContactsTests;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.ContactInfoPage;
import vTigerObjectRepository.ContactPage;
import vTigerObjectRepository.CreateNewContactPage;
import vTigerObjectRepository.HomePage;
import vTigerObjectRepository.LoginPage;
import vtiger.GenericLibrary.BaseClass;
import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaLibraries;
import vtiger.GenericLibrary.PropertyFileLibrary;
import vtiger.GenericLibrary.WebDriverLibrary;
@Listeners(vtiger.GenericLibrary.ListnerImplimentationLibrary.class)
public class CreateContactTest extends BaseClass {
	@Test(groups="regressionSuite")
	public void createCintactTest() throws IOException {
		
	String LASTNAME=eLib.readDataFromExcel("contact",4,3)+jLib.getRandomNumber();
	     HomePage hp=new HomePage (driver);
	     hp.ClickContactLink();
	     ContactPage cp=new  ContactPage(driver);
	     cp.ClickonCreateContactImg();
	     CreateNewContactPage ccp=new CreateNewContactPage(driver);
	     ccp.CreateNewContact(LASTNAME);
	     ContactInfoPage cip=new ContactInfoPage(driver);
	     
		String contactHeader=cip.getContactHeader();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME), "contact created");
		
		
		
		
	}
	@Test(groups={"smokeSuite","regressionSuite"})
	public void createContactTest() {
		//System.out.println("demo tets");
		Reporter.log("contact created sucessfully",true);
	}
	@Test()
	public void createContactWithLeadSource() {
		//System.out.println("lead source");
		Reporter.log("created contact with lead source sucessfully",true);
		Assert.fail();
	}
	@Test()
	public void createContactWithLeadSourceAndOrg() {
		//System.out.println("leadsource with org");
		Reporter.log(" create contact with leadsource and organisation sucessfully",true);
	}
	

}
