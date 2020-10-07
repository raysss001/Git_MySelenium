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
	
	
	/*@Test
	public void addAdminTest() {
		LoginPage lp = new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		lp.addAdmin(username, password);
		
	}*/
	
	/*@Test
	public void  invalidLoginTest() // valid username, invalid password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 2, 1);
		String password= ExcelUtils.readData("Login", 2, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg();		
		
		
	}
	
	
	
	/*@Test
	public void  invalidLoginTest1() // empty username, valid password
	{
		LoginPage lp=new LoginPage(driver);
		//String username= ExcelUtils.readData("Login", 7, 1);
		String password= ExcelUtils.readData("Login", 7, 2);
		lp.login("", password);
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg1();		
		
		
	}
	
	
	@Test
	public void  invalidLoginTest2() // valid username, empty password
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 8, 1);
		//String password= ExcelUtils.readData("Login", 8, 2);
		lp.login(username, "");
		WaitStatementLib.iSleep(10);
		lp.verifyInvalidLoginMsg2();		
		
		
	}
	
	*/
	
	
	
	
	

}
