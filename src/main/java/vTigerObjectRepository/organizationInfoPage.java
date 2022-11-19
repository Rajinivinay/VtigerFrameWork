package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationHeaderPage;
	public organizationInfoPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	public WebElement getOrganizationHeaderPage() {
		return organizationHeaderPage;
	}
	public String getorganisationHeaderText() {
		return organizationHeaderPage.getText();
		
	}
	

}
