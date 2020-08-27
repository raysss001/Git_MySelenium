package com.payasia.scripts;
import org.testng.annotations.Test;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.LoginPage;
import com.payasia.pageobjects.PayslipPage;

public class PayslipTest extends BaseLib{
	

	@Test
	public void  viewPayslip() // can't access account
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);
		PayslipPage pay=new PayslipPage(driver);
		pay.payslp(driver);
		
		
		
	}
	
	
	

}
