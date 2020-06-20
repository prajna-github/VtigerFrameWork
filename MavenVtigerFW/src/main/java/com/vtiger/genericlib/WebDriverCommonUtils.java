package com.vtiger.genericlib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.vtiger.genericlib.BaseClass;

public class WebDriverCommonUtils {
	String mainBrowserSessionID = null;
	
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectItemFromList(WebElement element , String itemToBeSelect)
	{
		Select s = new Select(element);
		s.selectByVisibleText(itemToBeSelect);
	}

	public boolean checkMultipleList(WebElement element)
	{
		Select s = new Select(element);
		return s.isMultiple();
	}
	
	public void keepMouseOnElement(WebElement element)
	{
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	
	public void MoveObjectAtRequiredPlace(WebElement source , WebElement target)
	{
		Actions act = new Actions(BaseClass.driver);
		act.dragAndDrop(source, target).perform();
	}
	
	public void acceptAlert()
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	
	public void validateAlertMessage(String expectedAlertText)
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		String actualAlertText = alt.getText();
		
		Assert.assertEquals(actualAlertText, expectedAlertText);
		System.out.println("Alert Validation Pass");
	}
	
	public void rejectAlert()
	{
		Alert alt = BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void switchToNewWindow()
	{
		mainBrowserSessionID = BaseClass.driver.getWindowHandle();
		Set<String> allId = BaseClass.driver.getWindowHandles();
		
		for(String id : allId)
		{
			if(!id.equals(mainBrowserSessionID))
			{
				BaseClass.driver.switchTo().window(id);
			}
		}
	}
	
	public void switchToMainWindow()
	{
		BaseClass.driver.switchTo().window(mainBrowserSessionID);
	}
	
	public void switchToRequiredFrame(WebElement element)
	{
		BaseClass.driver.switchTo().frame(element);
	}
	
	public void switchToDefaultScreen()
	{
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void fileUploadToApplication(String filePath) throws AWTException
	{
		filePath = filePath.replace("\\", "\\\\");
		StringSelection path = new StringSelection(filePath);
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Clipboard clip = tool.getSystemClipboard();
		clip.setContents(path, null);
		
		Robot r = new Robot();
		// Paste the path
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		// Click on  Enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);		
	}

}
