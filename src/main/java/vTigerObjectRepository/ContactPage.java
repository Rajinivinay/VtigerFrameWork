package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.WebDriverLibrary;

public class ContactPage extends WebDriverLibrary {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactlookupImg;
 public ContactPage(WebDriver driver) {
	 PageFactory.initElements( driver,this);
 }
public WebElement getCreateContactlookupImg() {
	return createContactlookupImg;
}
 public void ClickonCreateContactImg() {
	 createContactlookupImg.click();
 }

}
