package com.Actitime.GenericLiabrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class is a Generic Class which is having non-static methods to perform Data Driven Testing
 * @author Jitendra Chaudhari
 *
 */

public class FileLibrary {
	
	/**
	 * This Method is a Non-Static Method Which is used to read the data from Property File.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String ReadDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./TestData/CommonData.property.txt");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * This method is a non static method used to read the data from excel sheet.
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String ReadDataFromExcelFile(String sheetname,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream first=new FileInputStream("./TestData/ActiTimeTestData.xlsx");
		Workbook wb= WorkbookFactory.create(first);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}
