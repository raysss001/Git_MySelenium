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
		iSleep(10);		
		input(unTxtBx, username, "Username");
		input(pwdTxtBx, password, "Password");
		click(loginBtn, "Login button");			
	}

	public void verifyValidLoginMsg()
	{
		explicitWaitVisibility(driver,10,btn_logout,"Logout Button");
		click(link_Admin, "Admin menu link");
		explicitWaitVisibility(driver,10, btn_AddAdmin,"Admin Button");
		click(btn_AddAdmin, "btn_AddAdmin");

	}





}
