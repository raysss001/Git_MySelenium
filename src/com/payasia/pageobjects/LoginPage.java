package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.payasia.generic.BaseLib;
import com.payasia.generic.FunctionsLib;
import com.payasia.generic.WaitStatementLib;

public class LoginPage  extends FunctionsLib{

	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement unTxtBx;
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement pwdTxtBx;
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(),'Invalid credentials')]")
	private WebElement invalidLoginMsg;
	@FindBy(xpath="//span[contains(text(),'Username cannot be empty')]")
	private WebElement invalidLoginMsg1;
	@FindBy(xpath="//span[contains(text(),'Password cannot be empty')]")
	private WebElement invalidLoginMsg2;
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	private WebElement btn_logout;
	@FindBy(xpath="//a[@class='firstLevelMenu']/b[text()='Admin']")
	private WebElement link_Admin;
	@FindBy(xpath="//input[@id='btnAdd']")
	private WebElement btn_AddAdmin;
	


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
		this.driver=driver;

	}

	public WebElement getInvalidLoginMsg()
	{		
		return invalidLoginMsg;

	}


	public WebElement getInvalidLoginMsg1()
	{		
		return invalidLoginMsg1;

	}


	public WebElement getInvalidLoginMsg2()
	{		
		return invalidLoginMsg2;

	}


	public void login(String username, String password)
	{   
		WaitStatementLib.iSleep(10);		
		unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);		
		loginBtn.click();		
	}

	public void verifyValidLoginMsg()
	{
		WaitStatementLib.explicitWaitVisibility(driver, 10,btn_logout );
		click(link_Admin, "Admin menu link");
		WaitStatementLib.explicitWaitVisibility(driver, 10, btn_AddAdmin);
		click(btn_AddAdmin, "btn_AddAdmin");
		
	}


	public void verifyInvalidLoginMsg() 
	{		
		String expMsg ="Invalid username or password";
		String actMsg=getInvalidLoginMsg().getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Invalid Login Msg is Verified",true);		

	}	

	public void verifyInvalidLoginMsg1() 
	{		
		String expMsg ="Username is required.";
		String actMsg=getInvalidLoginMsg1().getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Invalid Login Msg is Verified",true);		

	}

	public void verifyInvalidLoginMsg2() 
	{		
		String expMsg ="Password is required.";
		String actMsg=getInvalidLoginMsg2().getText();
		Assert.assertEquals(actMsg.trim(),expMsg);
		Reporter.log("Invalid Login Msg is Verified",true);		
		
	}

	public void addAdmin(String username, String password) {
		WaitStatementLib.explicitWaitVisibility(driver, 10,btn_logout );
		click(link_Admin, "Admin menu link");
		WaitStatementLib.explicitWaitVisibility(driver, 10, btn_AddAdmin);
		click(btn_AddAdmin, "btn_AddAdmin");
		
		
	}







}
