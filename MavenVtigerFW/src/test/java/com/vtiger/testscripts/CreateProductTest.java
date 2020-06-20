package com.vtiger.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;

public class CreateProductTest extends BaseClass{
	
	@Test
	public void createProduct() throws EncryptedDocumentException, IOException
	{
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("img[title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(data.getDataFromExcel
																("ProductData", 2, 1));
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actProductMsg = driver.findElement(By.xpath
								("//span[contains(text(),'Product Information')]")).getText();
		
		if(actProductMsg.contains(data.getDataFromExcel("ProductData", 2, 2)))
		{
			Reporter.log("Product craeted successfully" , true);
		}else{
			Reporter.log("Product craetion fails" , true);
		}
	}
}
