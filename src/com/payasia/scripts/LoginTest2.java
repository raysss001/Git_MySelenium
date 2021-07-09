package com.payasia.scripts;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.FunctionsLib;
import com.payasia.generic.WaitStatementLib;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.payasia.pageobjects.LoginPage;



@Listeners(com.payasia.generic.ListenerReport.class)
public class LoginTest2 extends FunctionsLib{
	
	
	@Test
	public void  validLoginTest() // valid username, valid password
	{
		System.out.print("LOGIN TEST 2- BROWSER NAME PASSED FROM JENKINS IS ================= ");
		System.out.println(System.getProperty("BrowserName"));
		System.out.print("LOGIN TEST 2- TESTNG FILE PASSED FROM JENKINS IS ================= ");
		System.out.println(System.getProperty("suiteXmlFile"));
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		iSleep(10);
		lp.verifyValidLoginMsg();	
			
	}
	
	@Test
	public void  invalidLoginTest1() // valid username, invalid password
	{
		System.out.print("LOGIN TEST 2- BROWSER NAME PASSED FROM JENKINS IS ================ ");
		System.out.println(System.getProperty("BrowserName"));
		System.out.print("LOGIN TEST 2- TESTNG FILE PASSED FROM JENKINS IS ================= ");
		System.out.println(System.getProperty("suiteXmlFile"));
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 1);
		lp.login(username, password);
		iSleep(10);
		lp.verifyValidLoginMsg();	
		
		
	}
	
	
	

}
