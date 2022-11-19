package vTigerOrganizatioTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class CreateOrganisationTest extends BaseClass {
	@Test(groups="smokeSuite")
	public void createOrganisationTest() throws IOException {
		
		String ORGNAME=eLib.readDataFromExcel("organisation", 1, 2)+jLib.getRandomNumber();
		
		     HomePage hp=new HomePage (driver);
		     hp.ClickOrganizationlnk();
		     OrganizationPage op=new OrganizationPage(driver);
		     op.clickonCreateOrganizationimg();
		     CreateNewOrganisationPage cnp=new  CreateNewOrganisationPage(driver);
		     cnp.CreateNewOrganisation(ORGNAME);
		     organizationInfoPage oip=new  organizationInfoPage(driver);
		     String orgHeader=oip.getorganisationHeaderText();
				System.out.println(orgHeader);
				 Assert.assertTrue(orgHeader.contains(ORGNAME),"organisation created");
				
				
				
			}
			
		}
	


