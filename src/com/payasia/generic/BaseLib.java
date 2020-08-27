package com.payasia.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.ITestResult;
import org.openqa.selenium.Point;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseLib {
	public WebDriver driver;	
	@BeforeMethod
	@Parameters("browser")
	public void setUp1(String browserName)
	{	if(browserName.equalsIgnoreCase("FIREFOX"))
		{   String key ="webdriver.gecko.driver";
			String value="C:\\Users\\kiran\\eclipse-workspace\\Payasia\\exe\\geckodriver.exe";
			System.setProperty(key, value);
			driver=new FirefoxDriver();
			//driver.manage().window().setPosition(new Point(0, -2000));
			Reporter.log("Firefox Launched.",true);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{	String key="webdriver.chrome.driver";
			String value="C:\\Users\\kiran\\eclipse-workspace\\Payasia\\exe\\chromedriver.exe";
			System.setProperty(key, value);
			driver=new ChromeDriver();			
			Reporter.log("Chrome Launched",true);		
		} 
	
	
		/*else if(browserName.equalsIgnoreCase("IE"))
		{	System.setProperty("webdriver.ie.driver","E:\\QA-Dev\\IO_S08I_PayAsiaQA\\PayAsiaAutomation\\drivers\\IEDriverServer.exe");
            InternetExplorerDriver driver=new InternetExplorerDriver();
            Reporter.log("Internet Explorer Launched",true);		
		} 
	
	
		else if(browserName.equalsIgnoreCase("edge"))
		{   System.setProperty("webdriver.edge.driver","E:\\QA-Dev\\IO_S08I_PayAsiaQA\\PayAsiaAutomation\\drivers\\MicrosoftWebDriver.exe");
		 //// DesiredCapabilities capabilities = DesiredCapabilities.edge();
		    driver = new EdgeDriver();
		    //driver.manage().window().setPosition(new Point(0, -2000));
		    Reporter.log("Microsoft Edge Launched",true);		
		}
	
	
	
		else if(browserName.equalsIgnoreCase("safari"))
		{	WebDriver driver = new SafariDriver();
		    Reporter.log("Microsoft Edge Launched",true);		
		}
	*/
	
	
           driver.manage().window().maximize();
	       driver.get("https://minddemo.test-hronline-payasia.asia/beta#/login");
	       //driver.manage().window().setPosition(new Point(0, -2000));
	       Reporter.log("Navigating to URL",true);
		
		
		
	}
	
	
//	public WebDriver drive()
//	{			
//		return driver;
//		
//	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{   
		if(result.isSuccess())
		{
			Reporter.log("Script Passed",true);			
		}
		
		else
		{
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
			Reporter.log("Script Failed",true);
			String fileName = result.getMethod().getMethodName();
			fileName=browserName+"_"+fileName+".jpg";
			ScreenshotLib slib= new ScreenshotLib();
			slib.takeScreenshot(driver,fileName);
			Reporter.log("Screenshot has been taken.",true);	
			
		}
		
		
		driver.close();
		Reporter.log("Browser is closed",true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
