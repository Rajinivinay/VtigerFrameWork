package vtiger.practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.LoginPage;

public class LoginPractice {

	public static void main(String[] args) {
	    WebDriverManager.chromedriver().setup();
	    	WebDriver driver=new ChromeDriver();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	    	LoginPage lp=new LoginPage(driver);
	    	//lp.getUserNameEdt();
	    	//lp.getpassworsEdt();
	    	lp.loginToApp("admin", "admin");
	}

}
