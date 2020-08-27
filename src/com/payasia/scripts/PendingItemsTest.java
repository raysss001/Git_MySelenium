package com.payasia.scripts;
import org.testng.annotations.Test;
import com.payasia.generic.BaseLib;
import com.payasia.generic.ExcelUtils;
import com.payasia.generic.WaitStatementLib;
import com.payasia.pageobjects.LoginPage;
import com.payasia.pageobjects.MyRequestPage;
import com.payasia.pageobjects.PendingItemsPage;

public class PendingItemsTest extends BaseLib {
	
	
	@Test
	public void  pendingItems() 
	{
		LoginPage lp=new LoginPage(driver);
		String username= ExcelUtils.readData("Login", 1, 1);
		String password= ExcelUtils.readData("Login", 1, 2);
		lp.login(username, password);
		WaitStatementLib.iSleep(10);
		PendingItemsPage pend =new PendingItemsPage(driver);
		pend.pendItems(driver);
		
		
		
	}
	
	
	
	

}
