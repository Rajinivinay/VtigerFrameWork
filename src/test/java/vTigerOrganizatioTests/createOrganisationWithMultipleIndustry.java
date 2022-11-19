package vTigerOrganizatioTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class createOrganisationWithMultipleIndustry extends BaseClass {
	// Step 1: Create Object of all the libraries
	JavaLibraries jLib = new JavaLibraries();
	PropertyFileLibrary pLib = new PropertyFileLibrary();
	ExcelFileLibrary eLib = new ExcelFileLibrary();
	WebDriverLibrary wLib = new WebDriverLibrary();

	
	@Test(dataProvider = "MultipleOrganizations")
	public void createMultipleOrgTest(String orgName, String indType) throws IOException
	{
		String Org = orgName+jLib.getRandomNumber();

				// Step 2: read all the required data
				String BROWSER = pLib.readDtaFromPropertyFile("browser");
				String URL = pLib.readDtaFromPropertyFile("url");
				String USERNAME = pLib.readDtaFromPropertyFile("username");
				String PASSWORD = pLib.readDtaFromPropertyFile("password");
				
				WebDriver driver = null;

				// Step 3: launch the browser
				if (BROWSER.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else {
					System.out.println("invalid browser name");
				}

				wLib.maximiseWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(URL);

				// Step 4: Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//Step 5: Navigate to Organizations link
				HomePage hp = new HomePage(driver);
				hp.ClickOrganizationlnk();
				
				//Step 6: Navigate to create Organizations look up image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickonCreateOrganizationimg();
				
				//Step 7: Create new organization and save
				CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
				cnop.CreateNewOrganisation(Org,indType); //failed - exception
				
				//Step 8: Validate
				organizationInfoPage oip = new organizationInfoPage(driver);
				String orgHeader = oip.getorganisationHeaderText();
				if(orgHeader.contains(Org))
				{
					System.out.println(orgHeader);
					System.out.println("pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
				//Step 9: Logout
				hp.SignoutofApp(driver);
				
	}

	@DataProvider(name = "MultipleOrganizations")
	public Object[][] getData() throws Throwable {
		
		Object[][] data = eLib.multipleData("multipleorganizations");
		
		return data;

	}

}


