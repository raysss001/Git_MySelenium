package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


import com.payasia.generic.WaitStatementLib;

public class ChangePasswordPage {

	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	private WebElement chpasslink;
	@FindBy(xpath="//input[@placeholder='Enter Old Password']")
	private WebElement oldpass;
	@FindBy(xpath="//input[@placeholder='Enter New Password']")
	private WebElement newpass;
	@FindBy(xpath="//input[@placeholder='Confirm New Password']")
	private WebElement confirmpass;
	@FindBy(xpath="//button[@class='btn approve-btn']")
	private WebElement okbtn;
	@FindBy(xpath="//button[@class='btn close-btn ng-star-inserted']")
	private WebElement closebtn;
	@FindBy(xpath="//div[@class='col-12 heading-group']//h1")
	private WebElement screenname;
	@FindBy(xpath="//div[@class='ui-toast-detail' and contains(text(),'Password has been changed')]")
	private WebElement changesuc;
	@FindBy(xpath="//span[@class='ui-message-text' and contains(text(),'Current password should not be same as previous password')]")
	private WebElement changeLastSuc;
	@FindBy(xpath="//span[text()='Login']")
	private WebElement log;
	
	
	
	
	
	
	public ChangePasswordPage(WebDriver driver)
	{  
		
		PageFactory.initElements(driver, this);		
		
	}
		
	
	public static void changepassClear(WebElement ele)
	{
		ele.clear();		
		
	}
	
	

	public void changePswd(WebDriver driver)
	{
		String expMsg1="Change Password";
		String expMsg2="Old Password can not be empty.";
		String expMsg3="New Password and Confirm Password can not be empty.";
		String expMsg4="New Password and Confirm Password are not same.";
		String expMsg5="New Password and Confirm Password are not same.";
		String expMsg6="Old PassWord does not match, Please Try Again";
		String expMsg7="Password has been changed";	
		String expMsg8="Login";
		WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);
		//WaitStatementLib.iSleep(5);
		//check the screen name.
		chpasslink.click();
		WaitStatementLib.iSleep(3);
		String actMsg1=screenname.getText();
		Assert.assertEquals(actMsg1,expMsg1);		
		//Case:every field is empty and ok button is clicked.
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg2=driver.findElement(By.xpath("//span[@class='ui-message-text']")).getText();
		Assert.assertEquals(actMsg2, expMsg2);
		//Case:Old password is set but other fields are empty.
		oldpass.sendKeys("Mind@1234");
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg3=driver.findElement(By.xpath("//span[text()='New Password and Confirm Password can not be empty.']")).getText();	
		Assert.assertEquals(actMsg3, expMsg3);
		//Case:Old & New password is set but confirm Password field is empty.
		newpass.sendKeys("Mind@1234");
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg4=driver.findElement(By.xpath("//span[text()='New Password and Confirm Password are not same.']")).getText();	
		Assert.assertEquals(actMsg4, expMsg4);
		//Case:New Password and confirm password does not match.
		confirmpass.sendKeys("Mind@12345");
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg5=driver.findElement(By.xpath("//span[text()='New Password and Confirm Password are not same.']")).getText();	
		Assert.assertEquals(actMsg5, expMsg5);
		//Case:New and confirm password are same but invalid Old Password. 
		changepassClear(oldpass);
		changepassClear(newpass);
		changepassClear(confirmpass);
		oldpass.sendKeys("1234");
		newpass.sendKeys("Mind@1234");
		confirmpass.sendKeys("Mind@1234");
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.iSleep(5);
		String actMsg6=driver.findElement(By.xpath("//span[text()='Old PassWord does not match, Please Try Again']")).getText();	
		Assert.assertEquals(actMsg6,expMsg6);
	
		
		//Case: Valid change password
		changepassClear(oldpass);
		changepassClear(newpass);
		changepassClear(confirmpass);
		oldpass.sendKeys("Mind@1234");
		newpass.sendKeys("Mind@1234");
		confirmpass.sendKeys("Mind@1234");
		WaitStatementLib.iSleep(5);
		okbtn.click();		
		WaitStatementLib.explicitWaitVisibility(driver, 20, changesuc);		
		String actMsg7=changesuc.getText();
		Assert.assertEquals(actMsg7,expMsg7);
		WaitStatementLib.iSleep(7);
		String actMsg8=log.getText();
		Assert.assertEquals(actMsg8,expMsg8);		
	    Reporter.log("Change Password screen verified", true); 	    
		
	}
	
	
	
	public void maxCase(WebDriver driver,String op, String np, String cp)
	{	
		WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);
		String expMsg="Maximum Password length should not be exceeded by 10";
		chpasslink.click();
		WaitStatementLib.iSleep(3);		
		oldpass.sendKeys(op);
		newpass.sendKeys(np);
		confirmpass.sendKeys(cp);
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg=driver.findElement(By.xpath("//span[@class='ui-message-text']")).getText();
		Assert.assertEquals(actMsg,expMsg);		
	    Reporter.log("Change Password: Maximum Password length is verified", true);		
		
	}
	
	public void minCase(WebDriver driver,String op, String np, String cp)
	{	WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);	
		String expMsg="Minimum Password length should be 8";
		chpasslink.click();
		WaitStatementLib.iSleep(3);
		oldpass.sendKeys(op);
		newpass.sendKeys(np);
		confirmpass.sendKeys(cp);
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg=driver.findElement(By.xpath("//span[@class='ui-message-text']")).getText();
		Assert.assertEquals(actMsg,expMsg);		
	    Reporter.log("Change Password: Minimum Password length is verified", true);			
		
	}
	
	public void specialCase(WebDriver driver,String op, String np, String cp)
	{
		WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);
		String expMsg="Atleast one special character should be included";
		chpasslink.click();
		WaitStatementLib.iSleep(3);
		oldpass.sendKeys(op);
		newpass.sendKeys(np);
		confirmpass.sendKeys(cp);
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg=driver.findElement(By.xpath("//span[@class='ui-message-text']")).getText();
		Assert.assertEquals(actMsg,expMsg);		
	    Reporter.log("Change Password: Special Character is verified", true);
				
	}
	public void numCase(WebDriver driver,String op, String np, String cp)
	{
		WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);
		String expMsg="Numeric character should be included";
		chpasslink.click();
		WaitStatementLib.iSleep(3);
		oldpass.sendKeys(op);
		newpass.sendKeys(np);
		confirmpass.sendKeys(cp);
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg=driver.findElement(By.xpath("//span[@class='ui-message-text']")).getText();
		Assert.assertEquals(actMsg,expMsg);		
	    Reporter.log("Change Password: Numeric Character is verified", true);
		
	}
	
	public void uplowCase(WebDriver driver,String op, String np, String cp)
	{
		WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);
		String expMsg="Not a combination of Lower and Upper case";
		chpasslink.click();
		WaitStatementLib.iSleep(3);
		oldpass.sendKeys(op);
		newpass.sendKeys(np);
		confirmpass.sendKeys(cp);
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.iSleep(3);
		String actMsg=driver.findElement(By.xpath("//span[@class='ui-message-text']")).getText();
		Assert.assertEquals(actMsg,expMsg);		
	    Reporter.log("Change Password: Upper Lower Character is verified", true);	
		
		
	}
	
	
	public void lastCase(WebDriver driver,String op, String np, String cp)
	{
		WaitStatementLib.explicitWaitForClickable(driver, 30, chpasslink);
		String expMsg="Current password should not be same as previous password";
		chpasslink.click();
		WaitStatementLib.iSleep(3);
		oldpass.sendKeys(op);
		newpass.sendKeys(np);
		confirmpass.sendKeys(cp);
		WaitStatementLib.iSleep(5);
		okbtn.click();
		WaitStatementLib.explicitWaitVisibility(driver, 20, changeLastSuc);
		String actMsg=changeLastSuc.getText();
		Assert.assertEquals(actMsg,expMsg);		
	    Reporter.log("Change Password: Last Password case is verified", true);	
		
		
	}
	
	
	public static void setValue()
	{   // SET '1' VALUE SET IN LAST PASSWORD TEXT FIELD
		String key="webdriver.chrome.driver";
		String value="E:\\NewDevWorkspaces\\Payasia\\exe\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
        driver.get("https://minddemo.test-hronline-payasia.asia/");
        driver.manage().window().maximize();
        driver.findElement(By.id("loginNameId")).sendKeys("demoemp");
        driver.findElement(By.id("passwordId")).sendKeys("Mind@1234");
        driver.findElement(By.id("submitLoginButton")).click();
        WaitStatementLib.iSleep(15);
        driver.findElement(By.xpath("//a[@class='homeButton homeButton-blue'][contains(text(),'Switch Role')]")).click();
        WaitStatementLib.iSleep(8);
        driver.findElement(By.xpath("//a[contains(text(),'System')]")).click();
        
        Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'System')]"))).build().perform();
	    builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Preferences')]"))).build().perform();  
	    builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Password Policy')]"))).build().perform(); 
	    driver.findElement(By.xpath("//a[contains(text(),'Password Policy')]")).click(); //  Password Policy clicked
	    WaitStatementLib.iSleep(5);
	    driver.findElement(By.id("canNOtSameAsLastPwd")).clear();
	    driver.findElement(By.id("canNOtSameAsLastPwd")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='Save']")).click();
	    WaitStatementLib.iSleep(5);
	    driver.close();
		
	}
	
	
	public static void removeValue()
	{     // REMOVE VALUE SET IN LAST PASSWORD TEXT FIELD
		String key="webdriver.chrome.driver";
		String value="E:\\NewDevWorkspaces\\Payasia\\exe\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
        driver.get("https://minddemo.test-hronline-payasia.asia/");
        driver.manage().window().maximize();
        driver.findElement(By.id("loginNameId")).sendKeys("demoemp");
        driver.findElement(By.id("passwordId")).sendKeys("Mind@1234");
        driver.findElement(By.id("submitLoginButton")).click();
        WaitStatementLib.iSleep(10);
        driver.findElement(By.xpath("//a[@class='homeButton homeButton-blue'][contains(text(),'Switch Role')]")).click();
        WaitStatementLib.iSleep(8);
        driver.findElement(By.xpath("//a[contains(text(),'System')]")).click();
        
        Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'System')]"))).build().perform();
	    builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Preferences')]"))).build().perform();  
	    builder.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Password Policy')]"))).build().perform(); 
	    driver.findElement(By.xpath("//a[contains(text(),'Password Policy')]")).click(); //  Password Policy clicked
	    WaitStatementLib.iSleep(5);
	    driver.findElement(By.id("canNOtSameAsLastPwd")).clear();
	    driver.findElement(By.id("canNOtSameAsLastPwd")).sendKeys("0");
	    driver.findElement(By.xpath("//input[@value='Save']")).click();
	    WaitStatementLib.iSleep(5);
	    driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}