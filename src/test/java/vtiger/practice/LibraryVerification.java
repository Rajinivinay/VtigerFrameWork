package vtiger.practice;

import java.io.IOException;

import vtiger.GenericLibrary.ExcelFileLibrary;
import vtiger.GenericLibrary.JavaLibraries;
import vtiger.GenericLibrary.PropertyFileLibrary;

public class LibraryVerification {
	public static void main(String[] args) throws IOException {
		JavaLibraries jLib=new JavaLibraries();
		PropertyFileLibrary pLib=new  PropertyFileLibrary();
		ExcelFileLibrary eLib=new ExcelFileLibrary();
		String date=jLib.getSystemDate();
		System.out.println(date);
		String date1=jLib.getSystemDateInFormat();
		System.out.println(date1);
		String value=pLib.readDtaFromPropertyFile("browser");
		System.out.println(value);
		String value1=pLib.readDtaFromPropertyFile("username");
		System.out.println(value1);
		String val=eLib.readDataFromExcel("organisation", 2, 3);
		System.out.println(val);
		int row=eLib.getRowCount("contacts");
		System.out.println(row);
		eLib.writeDataIntoExcel("organisation", 6, 7, "rajini");
		
	}

}
