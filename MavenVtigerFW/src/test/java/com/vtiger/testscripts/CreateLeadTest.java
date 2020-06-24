package com.vtiger.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;
import com.vtiger.objectrepositary.CreateLeadPageElements;
import com.vtiger.objectrepositary.HomePageElements;
import com.vtiger.objectrepositary.LeadInfoPageElements;
import com.vtiger.objectrepositary.LeadsPageElements;

public class CreateLeadTest extends BaseClass{

	@Test
	public void  createLead() throws IOException {
		
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		LeadsPageElements lp = PageFactory.initElements(driver, LeadsPageElements.class);
		CreateLeadPageElements clp = PageFactory.initElements(driver, CreateLeadPageElements.class);
		LeadInfoPageElements lip = PageFactory.initElements(driver, LeadInfoPageElements.class);
		
		hp.getLeads().click();
		lp.getCreateLead().click();
		clp.getLastNameTb().sendKeys(data.getDataFromExcel("LeadData", 2, 1));
		clp.getCompanyNameTb().sendKeys(data.getDataFromExcel("LeadData", 2, 2));
		clp.getSaveBtn().click();
		String actLeadMsg = lip.getSuccessMsg().getText();
		
		Assert.assertTrue(actLeadMsg.contains(data.getDataFromExcel("LeadData", 2, 3)));
		System.out.println("Lead Creation Pass Successfully");
	}

}
