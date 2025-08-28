package PracticeDay1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoProperties {
	public static void main(String[] args) throws IOException {
		//Write data into properties file-SERIALIZATION
		FileInputStream fis=new FileInputStream(
				"C:\\Selenium\\src\\test\\resources\\FileUtility\\CommonData.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Here we are adding a new data into our properties file
		//Not changing in the existing data 
		pObj.setProperty("username", "admin");
		
		FileOutputStream fos=new FileOutputStream("C:\\Selenium\\src\\test\\resources\\FileUtility\\CommonData.properties");
		pObj.store(fos, "username has been added to the properties");
		fos.close();
		
	}
}
