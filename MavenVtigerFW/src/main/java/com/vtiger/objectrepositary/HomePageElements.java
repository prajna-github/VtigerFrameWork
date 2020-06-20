package com.vtiger.objectrepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;

public class HomePageElements extends BaseClass{
	@FindBy(linkText = "Leads")
	private WebElement leads;
	
	@FindBy(linkText = "Organizations")
	private WebElement organization;
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(xpath = "//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement signoutDD;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	public WebElement getLeads()
	{
		return leads;
	}
	public WebElement getOrganization()
	{
		return organization;
	}
	public WebElement getProduct()
	{
		return product;
	}
	public WebElement getSignOutDD()
	{
		return signoutDD;
	}
	public WebElement getSignoutLink()
	{
		return signoutLink;
	}
	
	public void logoutFromApp()
	{
		wlib.keepMouseOnElement(signoutDD);
		signoutLink.click();
	}
}
