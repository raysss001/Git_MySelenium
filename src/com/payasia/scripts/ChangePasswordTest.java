package com.payasia.scripts;
import org.testng.annotations.Test;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.ChangePasswordPage;
import com.payasia.pageobjects.LoginPage;

public class ChangePasswordTest extends BaseLib{
	

	@Test
	public void  changePassword() // Change Password screen
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);			
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.changePswd(driver);		
		
	}
	
	
	
	
	@Test
	public void  ChangePassMax() // Change Password Maximum case
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		String op1= ExcelUtils.readData("Change Password", 1, 3);
		String np1= ExcelUtils.readData("Change Password", 1, 4); 
		String cp1= ExcelUtils.readData("Change Password", 1, 5);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);				
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.maxCase(driver, op1, np1, cp1);				
		
	}
	
	
	
	@Test
	public void  ChangePassMin() // Change Password Minimum Case
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		String op2= ExcelUtils.readData("Change Password", 2, 3);
		String np2= ExcelUtils.readData("Change Password", 2, 4); 
		String cp2= ExcelUtils.readData("Change Password", 2, 5);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);			
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.minCase(driver, op2, np2, cp2);
		
	}
	
	
	
	@Test
	public void  ChangePassSpecial() // Change Password Special Character Case
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		String op3= ExcelUtils.readData("Change Password", 3, 3);
		String np3= ExcelUtils.readData("Change Password", 3, 4); 
		String cp3= ExcelUtils.readData("Change Password", 3, 5);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);			
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.specialCase(driver, op3, np3, cp3);
		
	}
	
	
	
	@Test
	public void  ChangePassNum() // Change Password Numeric Case
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		String op4= ExcelUtils.readData("Change Password", 4, 3);
		String np4= ExcelUtils.readData("Change Password", 4, 4); 
		String cp4= ExcelUtils.readData("Change Password", 4, 5);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);			
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.numCase(driver, op4, np4, cp4);
		
	}
	
	
	@Test
	public void  ChangePassUpLow() // Change Password Upper & Lower character Case
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		String op5= ExcelUtils.readData("Change Password", 5, 3);
		String np5= ExcelUtils.readData("Change Password", 5, 4); 
		String cp5= ExcelUtils.readData("Change Password", 5, 5);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);			
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.uplowCase(driver, op5, np5, cp5);
		
	}
	
	@Test
	public void  ChangePassLast() // Change Password Last Password Case
	{
		ChangePasswordPage.setValue();
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		String op6= ExcelUtils.readData("Change Password", 6, 3);
		String np6= ExcelUtils.readData("Change Password", 6, 4); 
		String cp6= ExcelUtils.readData("Change Password", 6, 5);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);			
		ChangePasswordPage change=new ChangePasswordPage(driver);
		change.lastCase(driver, op6, np6, cp6);
		ChangePasswordPage.removeValue();
		
		
		
		
	}
	
	
	

}
