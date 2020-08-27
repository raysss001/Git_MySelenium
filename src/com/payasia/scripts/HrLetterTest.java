package com.payasia.scripts;


import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import org.testng.annotations.Test;
import com.payasia.pageobjects.LoginPage;
import com.payasia.pageobjects.HrLetterPage;


public class HrLetterTest extends BaseLib{
	
	
	@Test
	public void HrLetter()
	{
		
		LoginPage lp=new LoginPage(driver);
        String username = ExcelUtils.readData("Login", 1, 1);
        String password = ExcelUtils.readData("Login", 1, 2);
        lp.login(username, password);
        WaitStatementLib.iSleep(8);
        HrLetterPage hr= new HrLetterPage(driver);
        hr.hrLetter(driver);
        
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
