package com.payasia.scripts;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import org.testng.annotations.Test;
import com.payasia.pageobjects.LoginPage;


public class LoginTest extends BaseLib{
	
	
	
	@Test
	public void  validLoginTest() // space username, space password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		lp.verifyValidLoginMsg();		
		
		
	}
	
	
	@Test
	public void  invalidLoginTest1() // valid username, invalid password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 2, 1);
		String password= ExcelUtils.readData("Login", 2, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg();		
		
		
	}
	
	
	@Test
	public void  invalidLoginTest2() // invalid username, valid password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 3, 1);
		String password= ExcelUtils.readData("Login", 3, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg();		
		
		
	}
	
	
	@Test
	public void  invalidLoginTest3() // space username, empty password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 4, 1);
		String password= ExcelUtils.readData("Login", 4, 2);
		lp.login(" ", password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg6();		
		
		
	}
		

	

	@Test
	public void  invalidLoginTest4() // valid username, space password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 5, 1);
		String password= ExcelUtils.readData("Login", 5, 2);
		lp.login(username, " ");
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg7();		
		
		
	}
	
	
	@Test
	public void  invalidLoginTest5() // space username, valid password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 6, 1);
		String password= ExcelUtils.readData("Login", 6, 2);
		lp.login(" ", password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg6();		
		
		
	}
	
	@Test
	public void  invalidLoginTest6() // empty username, valid password
	{
		LoginPage lp=new LoginPage(driver);
		//String username= ExcelUtils.readData("Login", 7, 1);
		String password= ExcelUtils.readData("Login", 7, 2);
		lp.login("", password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg6();		
		
		
	}
	
	
	@Test
	public void  invalidLoginTest7() // valid username, empty password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 8, 1);
		//String password= ExcelUtils.readData("Login", 8, 2);
		lp.login(username, "");
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg7();		
		
		
	}
	
	
	
	@Test
	public void  forgotPassword() // can't access account
	{
		LoginPage lp=new LoginPage(driver);
		WaitStatementLib.iSleep(5);
		String username= ExcelUtils.readData("Login", 9, 1);
		String invalidUsername=ExcelUtils.readData("Login", 10, 1);
   	    lp.forgetPass(username,invalidUsername,driver);
				
		
	}
	
	@Test
	public void  forgotUsername() // can't access account
	{
		LoginPage lp=new LoginPage(driver);
		WaitStatementLib.iSleep(10);
		String username= ExcelUtils.readData("Login", 9, 1);
		String invalidCap="1234"; 
		lp.forgetUser(username,invalidCap,driver);
		
		
	}
	
	
	

}
