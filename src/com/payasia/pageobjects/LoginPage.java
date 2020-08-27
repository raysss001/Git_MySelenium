package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


import com.payasia.generic.WaitStatementLib;

public class LoginPage {

	@FindBy(name="username")
	private WebElement unTxtBx;
	@FindBy(name="password")
	private WebElement pwdTxtBx;
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(),'Invalid username or password')]")
	private WebElement invalidLoginMsg;
	@FindBy(xpath="//span[contains(text(),'Username is required.')]")
	private WebElement invalidLoginMsg6;
	@FindBy(xpath="//span[contains(text(),'Password is required.')]")
	private WebElement invalidLoginMsg7;
	@FindBy(xpath="//span[contains(text(),'Switch to Classic View')]")
	private WebElement swichclassic;
	@FindBy(linkText="Can't access your account ?")            //a[contains(text(),"Can't access your account ?")]    //  //div[@class='cannot-access']/a[contains(text(),'access your account')]
	private WebElement cantAccessAcc;
//	@FindBy(id="forgot_password")
//	private WebElement forgetPass;
//	@FindBy(name="usernameOrEmailOrPassword")
//	private WebElement forgetPassText;
//	@FindBy(xpath="//button[@class='submit-button']")
//	private WebElement forgetPassSubmit;		
//	@FindBy(xpath="//span[contains(text(),'An email has been sent to your registered email address. Please check your email for password reset instructions.')]")
//	private WebElement forgetPassMail;
//	@FindBy(xpath="//span[contains(text(),'Please enter Username or Email or Full Name]")
//	private WebElement nousername; // when user name not set in forgot password text field	
//	@FindBy(xpath="//span[contains(text(),'There were no matching accounts found with the information you provided.']")
//	private WebElement invalidUserName; // when user name not set in forgot password text field	
//	@FindBy(id="forgot_username")
//	private WebElement forgetUser;
//	@FindBy(xpath="//button[@class='submit-button']")
//	private WebElement forgetUserSubmit;
//	@FindBy(name="emailOrPassword")
//	private WebElement forgetUserText;
//	@FindBy(name="captcha")
//	private WebElement capcha;
//	@FindBy(xpath="//span[contains(text(),'Invalid captcha text')]")
//	private WebElement invalidcapcha;
//	@FindBy(xpath="//span[contains(text(),'Please enter Email or Full Name')]")
//	private WebElement nouseremail;
//	@FindBy(xpath="//span[contains(text(),'Captcha can not be empty.')]")
//	private WebElement emptycapcha;
	
		
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
		
	}
		
	public WebElement getInvalidLoginMsg()
	{		
		return invalidLoginMsg;
	
	}
	
	
	public WebElement getInvalidLoginMsg6()
	{		
		return invalidLoginMsg6;
	
	}
	
	
	public WebElement getInvalidLoginMsg7()
	{		
		return invalidLoginMsg7;
	
	}
	
	
	public void login(String username, String password)
	{   
		WaitStatementLib.iSleep(10);		
	   	unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);		
		loginBtn.click();		
	}
	
	
	public void verifyInvalidLoginMsg() 
	{		
		String expMsg ="Invalid username or password";
		String actMsg=getInvalidLoginMsg().getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Invalid Login Msg is Verified",true);		
		
	}
	
	public void verifyValidLoginMsg() 
	{		
		String expMsg ="Switch to Classic View";
		String actMsg=swichclassic.getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Login is Verified",true);		
		
	}
	
	
	public void verifyInvalidLoginMsg6() 
	{		
		String expMsg ="Username is required.";
		String actMsg=getInvalidLoginMsg6().getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Invalid Login Msg is Verified",true);		
		
	}
	
	public void verifyInvalidLoginMsg7() 
	{		
		String expMsg ="Password is required.";
		String actMsg=getInvalidLoginMsg7().getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Invalid Login Msg is Verified",true);		
		
	}
	
	
	public void forgetPass(String username, String invalidusername, WebDriver driver) 
	{		
		String expMsg1 ="An email has been sent to your registered email address. Please check your email for password reset instructions.";
		String expMsg2="Please enter Username or Email or Full Name";
		String expMsg3="There were no matching accounts found with the information you provided.";
	    cantAccessAcc.click();
		WaitStatementLib.iSleep(3);
		driver.findElement(By.id("forgot_password")).click();
		WaitStatementLib.iSleep(5);
		driver.findElement(By.xpath("//button[@class='submit-button']")).click();	
		WaitStatementLib.iSleep(4);
		String actMsg2= driver.findElement(By.xpath("//span[text()='Please enter Username or Email or Full Name']")).getText();
		Assert.assertEquals(expMsg2, actMsg2);			
		driver.findElement(By.name("inputField1")).sendKeys(invalidusername);
		driver.findElement(By.xpath("//button[@class='submit-button']")).click();
		WaitStatementLib.iSleep(4);
		String actMsg3=driver.findElement(By.xpath("//span[text()='There were no matching accounts found with the information you provided.']")).getText();
		Assert.assertEquals(actMsg3,expMsg3);			
		driver.findElement(By.name("inputField1")).clear();
		driver.findElement(By.name("inputField1")).sendKeys(username);
		driver.findElement(By.xpath("//button[@class='submit-button']")).click();
		WaitStatementLib.iSleep(8);
		String actMsg1= driver.findElement(By.xpath("//span[contains(text(),'An email has been sent to your registered email address. Please check your email for password reset instructions.')]")).getText();
		Assert.assertEquals(actMsg1,expMsg1);	
		
		WaitStatementLib.iSleep(30);
		driver.navigate().to("https://owa.motherson.com/");
		WaitStatementLib.iSleep(5);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("mind\\kiransingh");
		driver.findElement(By.id("password")).sendKeys("Mind@123");
		driver.findElement(By.className("signinTxt")).click();
		WaitStatementLib.iSleep(10);		
		driver.findElement(By.xpath("//a[contains(text(),'demoemp Your HR Portal Online Pa...')]")).click();
		WaitStatementLib.iSleep(5);	
		
		
		
		String actMsg4=driver.findElement(By.xpath("//td[@class='sub']")).getAttribute("innerHTML");
        actMsg4=actMsg4.trim();		
		String expMsg4="demoemp Your HR Portal Online Password Reset Request";
		Assert.assertEquals(actMsg4,expMsg4);
		
//      BELOW CODE IS ALSO CORRECT 		
//		String actMsg4=new String(driver.findElement(By.xpath("//td[@class='sub']")).getAttribute("innerHTML"));
//		actMsg4=actMsg4.trim();
//		Assert.assertEquals(actMsg4, expMsg4);	
		
		
		Reporter.log("Forgot Password verified",true);		
		
	}
	
	
	
	public void forgetUser(String username,String invalidcap,WebDriver driver) 
	{		
		String expMsg1 ="Please enter Email or Full Name";
		String expMsg2="Captcha can not be empty.";
		String expMsg3="Invalid captcha text";
	    cantAccessAcc.click();
		WaitStatementLib.iSleep(3);
		driver.findElement(By.id("forgot_username")).click();
		WaitStatementLib.iSleep(5);
		driver.findElement(By.xpath("//button[@class='submit-button']")).click();	
		WaitStatementLib.iSleep(3);
		String actMsg1= driver.findElement(By.xpath("//span[text()='Please enter Email or Full Name']")).getText();
		Assert.assertEquals(expMsg1, actMsg1);			
		driver.findElement(By.name("inputField2")).sendKeys(username);
		driver.findElement(By.xpath("//button[@class='submit-button']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg2=driver.findElement(By.xpath("//span[text()='Captcha can not be empty.']")).getText();
		Assert.assertEquals(actMsg2,expMsg2);			
		driver.findElement(By.name("captcha")).sendKeys(invalidcap);
		driver.findElement(By.xpath("//button[@class='submit-button']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg3= driver.findElement(By.xpath("//span[contains(text(),'Invalid captcha text')]")).getText();
		Assert.assertEquals(actMsg3,expMsg3);		
		Reporter.log("Forgot Username verified",true);
		
				
	}
	
	
	
	
	

	

}
