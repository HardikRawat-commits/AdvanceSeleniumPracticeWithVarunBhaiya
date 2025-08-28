package PracticeDay2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Fetch data from excel file
		FileInputStream fis=new FileInputStream(
				"C:\\Selenium\\src\\test\\resources\\FileUtility\\TestScript.xlsx");
	    //"create" will not create anything , it will open the workbook in readable mode
		Workbook wb=WorkbookFactory.create(fis);
		//this will open the particular sheet in workbook 
		//here sheet name is "organizations"
		Sheet sh=wb.getSheet("organizations");
		//it will load the particular row 
		//whose index is mentioned and index starts from 0
		Row row=sh.getRow(2);
		//it will load the particular cell 
		//whose index is mentioned and index starts from 0
		Cell cell=row.getCell(0);
		//it will fetch the cell data
		//here in .getStringCellValue() , String is the return type of cell value
		//which is stored in same return type 
		String cellValue=cell.getStringCellValue();
		System.out.println(cellValue);
		
	}
}
