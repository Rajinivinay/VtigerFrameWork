package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet("organisation");
	Row r=sh.getRow(4);
	 Cell c=r.getCell(3);
	String value=c. getStringCellValue();
	System.out.println(value);

	}

}
