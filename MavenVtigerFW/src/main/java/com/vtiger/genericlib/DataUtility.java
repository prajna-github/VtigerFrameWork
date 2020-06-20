package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	public String getDataFromProperty(String key) throws IOException
	{
		String propertyfilePath = "./src/test/resources/commonData.properties";
		FileInputStream fis = new FileInputStream(propertyfilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	public String getDataFromExcel(String sheetname , int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		String excelfilepath = "./src/test/resources/TestData.xlsx";
		FileInputStream fis1 = new FileInputStream(excelfilepath);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetname);
		String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
	}

}
