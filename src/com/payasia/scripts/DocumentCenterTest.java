package com.payasia.scripts;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;


import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.DocumentCenterPage;
import com.payasia.pageobjects.LoginPage;

public class DocumentCenterTest extends BaseLib{
	

	@Test
	public void  DocumentCenter() // can't access account
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		WaitStatementLib.iSleep(10);
		DocumentCenterPage doc=new DocumentCenterPage(driver);
		doc.docCent(driver);
		
		
		
	}
	
	
	

}
