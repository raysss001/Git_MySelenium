package com.payasia.scripts;
import org.testng.annotations.Test;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.LoginPage;
import com.payasia.pageobjects.MyRequestPage;

public class MyRequestTest extends BaseLib{
	

	@Test
	public void  myRequest() 
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);
		MyRequestPage mr =new MyRequestPage(driver);
		mr.mRequest(driver);
		
		
		
	}
	
	
	

}
