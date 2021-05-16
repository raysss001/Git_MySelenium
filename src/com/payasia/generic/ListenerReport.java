package com.payasia.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerReport implements ITestListener, ISuiteListener {

	public WebDriver driver;

	ExtentHtmlReporter reporter; 
	public static ExtentReports extent;
	public static ExtentTest logrepo;

	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss");
	public static Logger log;


	@Override
	public void onFinish(ISuite arg0) {

		System.out.println("onFinish-ISuite");
	}

	@Override
	public void onStart(ISuite arg0) {

		PropertyConfigurator.configure("log4j.properties");
		System.out.println("onStart-ISuite");
	}


	@Override
	public void onFinish(ITestContext Result ) {
		System.out.println("onFinish-ITestContext");
		extent.flush();


	}

	@Override
	public void onStart(ITestContext Result) {
		System.out.println("onStart-ITestContext");
		log= Logger.getLogger(ListenerReport.class);
		reporter = new ExtentHtmlReporter("C:\\My_Selenium\\Report\\extent_report_"+sdf.format(new Date())+".html");
		extent = new ExtentReports();  
		extent.attachReporter(reporter);
		logrepo = extent.createTest("LoginTest");
		logrepo.log(Status.INFO,"Login to Amazon");
		logrepo.log(Status.PASS, "Title Verifiedddddddddd");
		logrepo.log(Status.PASS, System.getProperty("BROWSERNAME"));
		



		/*reporter = new ExtentHtmlReporter("D:\\My_Selenium\\Report\\extent_report_"+sdf.format(new Date())+".html");
		report = new ExtentReports();       
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setReportName("Test Report");
		reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setEncoding("utf-8");	
		report.attachReporter(reporter);
		 */

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {		

	}

	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println("onTestFailure");
		System.out.println("The name of the testcase Failed is : "+ Result.getName());


	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is : "+ Result.getName());

	}

	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println("onTestStart");

	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase Passed is : "+ Result.getName());		
		System.out.println("onTestSuccess");
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp1(String browserName)
	{	if(browserName.equalsIgnoreCase("FIREFOX"))
	{   String key ="webdriver.gecko.driver";
	String value="C:\\Users\\kiran\\eclipse-workspace\\MySelenium\\exe\\geckodriver.exe";
	System.setProperty(key, value);
	driver=new FirefoxDriver();
	//driver.manage().window().setPosition(new Point(0, -2000));
	Reporter.log("Firefox Launched.",true);
	}
	else if(browserName.equalsIgnoreCase("chrome"))
	{	
		System.out.println(System.getProperty("BrowserName"));
		String key="webdriver.chrome.driver";
		String value="C:\\Users\\kiran\\eclipse-workspace\\MySelenium\\exe\\chromedriver.exe";
		System.setProperty(key, value);
		driver=new ChromeDriver();			
		Reporter.log("Chrome Launched",true);		
	} 

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("In @BEFORETest");
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	//driver.manage().window().setPosition(new Point(0, -2000));
	//Reporter.log("Navigating to URL",true);	


	}


	@AfterMethod
	public void tearDown(ITestResult result)
	{   
		System.out.println("Control in TearDown");
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


	public void logTestStep(String msg) {
		log.info(msg);
		logrepo.log(Status.INFO, msg);
	}

	public void logTestInfo(String msg) {
		log.info(msg);
		logrepo.log(Status.INFO, msg);
	}

	public void logTestPass(String msg) {
		log.info(msg);
		logrepo.log(Status.PASS, msg);
	}

	public void logTestPassSnap(String msg) {
		log.info(msg);
		logrepo.log(Status.PASS, msg);

	}

	public void logTestFail(String msg) {
		log.info(msg);
		logrepo.log(Status.FAIL, msg);
		Assert.fail(msg);
	}

	public void logTestFailSnap(String msg) {
		System.out.println("Hello");
		log.info(msg);
		System.out.println("World!");
		logrepo.log(Status.FAIL, msg);
		Assert.fail(msg);
	}



}
