package PracticeDay2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Write data into properties
		//this FileInputStream is locating the file address and loading it
		FileInputStream fis=new FileInputStream(
				"C:\\Selenium\\src\\test\\resources\\FileUtility\\TestScript.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("organizations");
		
		Row row=sh.getRow(0);
		
		//Jab cell bana hua hai tab getCell() ka use karenge 
		//lekin jab cell bana nahi hai pehle se to us case me createCell() ka prayog karenge
//		Cell cell=row.getCell(1);
		
		Cell cell=row.createCell(6);
		
		cell.setCellValue("Address");
		
		FileOutputStream fos=new FileOutputStream("C:\\Selenium\\src\\test\\resources\\FileUtility\\TestScript.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
}