package com.payasia.scripts;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentDemo {

@Test
public void extentReportsDemo() {
	//reporter = new ExtentHtmlReporter("D:\\My_Selenium\\Report\\extent_report_"+sdf.format(new Date())+".html");
	//ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/learn_automation.html");
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\My_Selenium\\Report\\extent_report.html");
	ExtentReports extent = new ExtentReports();  
	extent.attachReporter(reporter);
	ExtentTest logger = extent.createTest("LoginTest");
	logger.log(Status.INFO,"EXTENT DEMO- Login to Amazon");
	logger.log(Status.PASS,"EXTENT DEMO- Title Verified");
	extent.flush();
	
	
	/*reporter.config().setDocumentTitle("Extent Report");
	reporter.config().setChartVisibilityOnOpen(true);
	reporter.config().setReportName("Test Report");
	reporter.config().setTestViewChartLocation(ChartLocation.TOP);
	reporter.config().setTheme(Theme.STANDARD);
	reporter.config().setEncoding("utf-8");	
	
	System.out.println("onStart-ITestContext");
	
	String key="webdriver.chrome.driver";
	String value="C:\\Users\\kiran\\eclipse-workspace\\Payasia\\exe\\chromedriver.exe";
	System.setProperty(key, value);
	driver=new ChromeDriver();		
	Reporter.log("Chrome Launched",true);	
	 driver.manage().window().maximize();
     driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
     //driver.manage().window().setPosition(new Point(0, -2000));
     Reporter.log("Navigating to URL",true);
	
	System.out.println("ready to flush");
	report.flush();*/

}


}