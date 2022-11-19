package vtiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileLibrary {
	public String readDataFromExcel(String sheetName ,int rowNo,int celNo) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsLibrary.excelFilePth);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNo);
		Cell c=rw.getCell(celNo);
		String value=c.getStringCellValue();
		wb.close();
		return value;
		
	}
	public int getRowCount(String sheetName) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsLibrary.excelFilePth);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		wb.close();
		return rowCount;
		
		}
	public void writeDataIntoExcel(String sheetName,int rowNo,int celNo,String value) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsLibrary.excelFilePth);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNo);
		Cell c=rw.getCell(celNo);
		c.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantsLibrary.excelFilePth);
		wb.write(fos);
		wb.close();
		System.out.println("Data written sucessfully");
		
	}
	public Object[][] multipleData(String sheetName) throws Throwable{
		FileInputStream fis=new FileInputStream(IConstantsLibrary.excelFilePth);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
			
		}
		
		return data;
		
	}
}
