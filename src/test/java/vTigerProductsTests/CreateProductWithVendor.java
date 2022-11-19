package vTigerProductsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericLibrary.BaseClass;
import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaLibraries;
import vtiger.GenericLibrary.PropertyFileLibrary;
import vtiger.GenericLibrary.WebDriverLibrary;

public class CreateProductWithVendor  {
	public static void main(String[] args) throws IOException {
		JavaLibraries jLib= new JavaLibraries();
		ExcelFileLibrary elib=new ExcelFileLibrary();
		WebDriverLibrary wLib=new WebDriverLibrary();
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		String BROWSER=pLib.readDtaFromPropertyFile("browser");
		String URL=pLib.readDtaFromPropertyFile("url");
		String USERNAME=pLib.readDtaFromPropertyFile("username");
		String PASSWORD=pLib.readDtaFromPropertyFile("password");
		String   PRODUCTNAME = elib.readDataFromExcel("product", 1, 2) + jLib.getRandomNumber();
		String VENDER= elib.readDataFromExcel("product", 1, 3)+jLib.getRandomNumber();
		WebDriver driver=null;
	 if(BROWSER.equalsIgnoreCase("chrome")) {
		  WebDriverManager .chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  else if(BROWSER.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  else {
		  System.out.println("inavild browser");
	  }
	  wLib.maximiseWindow(driver);
	  wLib.waitForPageLoad(driver);
	  driver.get(URL);
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		WebElement element=driver.findElement(By.xpath("//a[.='More']"));
		wLib.mouseHoverOn(driver, element);
		
		driver.findElement(By.xpath("//a[.='Vendors']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		driver.findElement(By.name("vendorname")).sendKeys(VENDER);
		driver.findElement(By.name("button")).click();
		String venHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if( venHeader.contains(VENDER)) {
			System.out.println("vender created");
		}
		else {
			System.out.println("vender creation failed");
		}
		
        driver.findElement(By.xpath("//a[.='Products']")).click();
        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
        driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
        driver.findElement(By.xpath("//img[@alt='Select']")).click();
        wLib.switchToWindow(driver, "Vendors" );
        driver.findElement(By.name("search_text")).sendKeys(VENDER);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath("//a[@class='listFormHeaderLinks']")).click();
        wLib.switchToWindow(driver, "Products");
        driver.findElement(By.name("button")).click();
		String productHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(productHeader);
		if(productHeader.contains (PRODUCTNAME)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		WebElement adminimg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, adminimg);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		 
	    
	    

	}
	}
		
