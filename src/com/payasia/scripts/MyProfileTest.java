package com.payasia.scripts;
import java.io.IOException;

import org.testng.annotations.Test;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.LoginPage;
import com.payasia.pageobjects.MyProfilePage;
import com.payasia.pageobjects.MyRequestPage;

public class MyProfileTest extends BaseLib{
	
	@Test
	public void  myProfile() 
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(8);
		MyProfilePage mp =new MyProfilePage(driver);
		try {
			mp.myPro(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	

    }

	
	
}