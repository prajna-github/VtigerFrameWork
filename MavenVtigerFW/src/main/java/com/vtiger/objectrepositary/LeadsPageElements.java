package com.vtiger.objectrepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPageElements {


	@FindBy(css = "img[title='Create Lead...']")
	private WebElement creatLead;
	
	public WebElement getCreateLead()
	{
		return creatLead;
	}

}
