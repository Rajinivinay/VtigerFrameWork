package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyFilePractice {

	public static void main(String[] args) throws IOException, InterruptedException {
		 
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER =pobj.getProperty("browser");
		System.out.println(BROWSER);
		String URL =pobj.getProperty("url");
		System.out.println(URL);
		
	
		
				

	}

}
