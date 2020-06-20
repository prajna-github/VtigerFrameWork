package com.vtiger.objectrepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadInfoPageElements {
	@FindBy(xpath = "//span[contains(text(),'Lead Information')]")
	private WebElement successMsg;
	
	public WebElement getSuccessMsg()
	{
		return successMsg;
	}
}
