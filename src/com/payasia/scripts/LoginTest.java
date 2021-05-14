package com.payasia.scripts;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.FunctionsLib;
import com.payasia.generic.WaitStatementLib;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.payasia.pageobjects.LoginPage;



@Listeners(com.payasia.generic.ListenerReport.class)
public class LoginTest extends FunctionsLib{
	
	
	@Test
	public void  validLoginTest() // space username, space password
	{
		System.out.println("BrowserName");
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		iSleep(10);
		lp.verifyValidLoginMsg();	
		System.out.println("BrowserName");
		
	}
	
	/*@Test
	public void  invalidLoginTest1() // valid username, invalid password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 1);
		lp.login(username, password);
		iSleep(10);
		lp.verifyValidLoginMsg();	
		
		
	}*/
	
	
	

}
