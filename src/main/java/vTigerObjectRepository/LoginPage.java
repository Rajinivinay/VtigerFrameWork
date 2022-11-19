package vTigerObjectRepository;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

	

	public class LoginPage{
		@FindBy(name="user_name")
		private WebElement userNameEdt;
		
		@FindBy(name="user_password")
		private WebElement passwordEdt;
		
		@FindBy(id = "submitButton")
		private WebElement loginBtn;
		
		//rule 3: Create a constructor to tialise these variables
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//rule 4: Provide getter methods to access these variables
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}
		public WebElement getpassworsEdt() {
			return passwordEdt;
		}

		public WebElement getPasswordEdt() { 
			return loginBtn;
		}

		//Business Library
		
		/**
		 * This method will perform login opertation
		 * param username
		 * @param password
		 */
		public void loginToApp(String username, String password)
		{
			userNameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click( );;
		}
		

}
