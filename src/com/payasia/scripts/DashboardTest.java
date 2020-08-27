package com.payasia.scripts;

import org.testng.annotations.Test;


import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.DashboardPage;
import com.payasia.pageobjects.LoginPage;

public class DashboardTest extends BaseLib{

	
	
	@Test
	public void Dashboard(){
		
		LoginPage lp= new LoginPage(driver);
		String username = ExcelUtils.readData("Login", 1, 1);
		String password=ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		DashboardPage dp=new DashboardPage(driver);
		dp.verifyDashboard(driver);
		
		
	}
}
