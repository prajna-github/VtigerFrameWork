package com.vtiger.objectrepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLeadPageElements {
	@FindBy(name = "lastname")
	private WebElement lastnametb;
	
	@FindBy(name = "company")
	private WebElement companyNametb;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	public WebElement getLastNameTb()
	{
		return lastnametb;
	}
	
	public WebElement getCompanyNameTb()
	{
		return companyNametb;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}

}
