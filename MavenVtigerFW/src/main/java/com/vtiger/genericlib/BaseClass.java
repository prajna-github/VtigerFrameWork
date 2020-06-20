package com.vtiger.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.genericlib.DataUtility;
import com.vtiger.genericlib.WebDriverCommonUtils;
import com.vtiger.objectrepositary.HomePageElements;
import com.vtiger.objectrepositary.LoginPageElements;

public class BaseClass {


	public static WebDriver driver ;
	public DataUtility data = new DataUtility();
	public WebDriverCommonUtils wlib = new WebDriverCommonUtils();
	@BeforeSuite
	public void configBS()
	{
		System.out.println("---------------Database connect----------------");
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("-----------Browser Launching starts------------");
		String browser = data.getDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(data.getDataFromProperty("url"));
		System.out.println("-----------Browser Launching ends------------");
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("------------Login Starts--------------");
		LoginPageElements login = PageFactory.initElements(driver, LoginPageElements.class);
		
		login.loginToApp(data.getDataFromProperty("username"), data.getDataFromProperty("password"));
		
		System.out.println("------------Login ends--------------");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("-------------Logout starts-------------");
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		hp.logoutFromApp();
		System.out.println("-------------Logout ends------------");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("-------------Close Browser------------");
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("------------Database Disconnect--------------");
	}

}
