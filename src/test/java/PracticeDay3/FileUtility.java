package PracticeDay3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	//DDT utility concept
	//These are two methods one is extracting file from properties file
	//and other one is extracting from excel file 
	
	public String getDataFromPropertiesFile(String key) throws IOException {
//		Get the data from properties file
		FileInputStream fis1 = new FileInputStream(
				"C:\\Selenium\\src\\test\\resources\\FileUtility\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis1);
		String value = pObj.getProperty(key);
		return value;
	}
	
	public String getDataFromExcelFile(String orgName, int RowIndex, int CellIndex  ) throws EncryptedDocumentException, IOException {
		//Get the data from excel file
		FileInputStream fis2=new FileInputStream(
				"C:\\Selenium\\src\\test\\resources\\FileUtility\\TestScript.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis2);
		
		Sheet sh=wb.getSheet(orgName);
		
		Row row=sh.getRow(RowIndex);
		
		Cell cell=row.getCell(CellIndex);
		
	 String Value =cell.getStringCellValue();
		
	 return Value;
	}
	
}