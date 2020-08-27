package com.payasia.scripts;

import org.testng.annotations.Test;

import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.AdminHrLetterPage;
import com.payasia.pageobjects.LoginPage;

public class AdminHrLetterTest extends BaseLib{
	
	
	@Test
	public void HRLetter()
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 2, 1);
		String password= ExcelUtils.readData("Login", 2, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(4);
		AdminHrLetterPage ahlp=new AdminHrLetterPage(driver);
		ahlp.swithUser();	
		WaitStatementLib.iSleep(5);
		ahlp.addHRLetter("NAME1", "description1", "subject1", "body1",driver);		
		ahlp.sendHRLetter("NAME1", driver, "body1");
		ahlp.editHRLetter("NAME1","New description value",driver);
		ahlp.deleteHRLetter("NAME1",driver);
	
		
		
	}
	
	
	
	
	
	
	
	

}