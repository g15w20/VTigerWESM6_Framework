package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 Sheet sh = wb.getSheet("Contacts");
		 
		 Row rw = sh.getRow(4);
		
		Cell ce = rw.getCell(2);
		
		String value = ce.getStringCellValue();
		System.out.println(value);
	}

}
