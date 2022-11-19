package vtiger.practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationusinDDT {
	public static void main(String[] args) throws IOException, Throwable {
	
	FileInputStream  fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties ");
	Properties p=new Properties();
     p.load(fis);
	
	 String BROWSER	=p.getProperty("browser");
	 String URL=p.getProperty("url");
	 String USERNAME=p.getProperty("username");
	 String PASSWORD =p.getProperty("password");
	 FileInputStream  fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb= WorkbookFactory.create(fis1);
	Sheet s=wb.getSheet("organisation");
	Row r=s.getRow(1);
	Cell c=r.getCell(2);
	String organisation=c.getStringCellValue();
	
    
	 WebDriver driver=null;
		 if(BROWSER.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 System.out.println(BROWSER);
	   }
	 else if(BROWSER.equalsIgnoreCase("firefox")){
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 System.out.println(BROWSER);
		 
	 }
	 else {
		 System.out.println("invalid browser");
	 }
	 driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organisation);
		driver.findElement(By.name("button")).click();

			Thread.sleep(8000);
		
		Alert a=driver.switchTo().alert();
		a.accept();
		
		Actions ac=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		ac.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();
	 
	 


}}
