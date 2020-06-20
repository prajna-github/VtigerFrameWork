package com.vtiger.testscripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;

public class CreateOrganisationTest extends BaseClass{
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException
	{
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		String orgName = data.getDataFromExcel("OrganisationData", 2, 1);
		Random r = new Random();
		int num = r.nextInt(9999);
		orgName  = orgName + num;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		// Window popup handling
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wlib.switchToNewWindow();
		driver.findElement(By.linkText("Tech m")).click();
		wlib.acceptAlert();
		wlib.switchToMainWindow();
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actOrgMsg = driver.findElement(By.xpath
								("//span[contains(text(),'Organization Information')]")).getText();
		
		if(actOrgMsg.contains(data.getDataFromExcel("OrganisationData", 2, 2)))
		{
			Reporter.log("Organisation craeted successfully" , true);
		}else{
			Reporter.log("Organisation craetion fails" , true);
		}
	}
}
