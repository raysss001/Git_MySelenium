package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


import com.payasia.generic.WaitStatementLib;

public class PayslipPage {

	@FindBy(xpath="//button[@class='sidebar-toggle']")
	private WebElement menu;
	@FindBy(xpath="//a[@class='dashboard']//span[contains(text(),'HRIS')]")
	private WebElement hris;
	@FindBy(xpath="//a[@class='pointer']//span[contains(text(),'Payslip')]")  
	private WebElement paysliplink;
	
	
	
	
	
	public PayslipPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
		
	}
		
	
	

	public void payslp(WebDriver driver)
	{
		String exp1="Payslip";
		WaitStatementLib.explicitWaitForClickable(driver, 20, menu);
		menu.click();
		WaitStatementLib.iSleep(2);
	    hris.click();
	    WaitStatementLib.iSleep(2);	    
	    WebElement link= driver.findElement(By.xpath("//a[@class='pointer']//span[contains(text(),'Payslip')]"));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(link ).build().perform();
	    link.click();
	    WaitStatementLib.iSleep(5);
	    String act1=driver.findElement(By.xpath("//a[@class='pointer']//span[contains(text(),'Payslip')]")).getText();
	    Assert.assertEquals(act1,exp1);	 // check for screen name 'Payslip'
	   	     
	    //NEED TO CREATE SCRIPT FOR CHANGE OF YEAR AND MONTH 
	    
//	    WaitStatementLib.iSleep(5);
//	    System.out.println("0");
//	    WebElement dropdown=driver.findElement(By.className("ng-tns-c8-270 ui-inputwrapper-filled ng-untouched ng-pristine ng-valid"));
//	    System.out.println("1");
//	    Select sel= new Select(dropdown);
//	    System.out.println("2");
//	    sel.selectByIndex(2);
//	    System.out.println("3");
	    
	    
	    
	    
	     
	    	    
	    WaitStatementLib.iSleep(5);		    
	    driver.findElement(By.xpath("//button[@class='action-icon downloadPayslip']")).click(); // download button of top first payslip
	    driver.findElement(By.xpath("//button[@class='action-icon viewPayslip']")).click(); //view button of top first payslip
	    WaitStatementLib.iSleep(5);	    
	    driver.findElement(By.xpath("//button[@class='btn close-btn']")).click();//close button
	    Assert.assertEquals(act1,exp1);	//check again for 'Payslip' screen name
	    Reporter.log("Payslip page verified", true);   
	    
	    
		
	}
	

		
	
	
	
	
	
	
	
	

	

}
