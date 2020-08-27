package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


import com.payasia.generic.WaitStatementLib;

public class DocumentCenterPage {

	@FindBy(xpath="//button[@class='sidebar-toggle']")
	private WebElement menu;
	@FindBy(xpath="//a[@class='dashboard']//span[contains(text(),'HRIS')]")
	private WebElement hris;
	@FindBy(xpath="//span[contains(text(),'Document Center')]")
	private WebElement doclink;
	@FindBy(xpath="//h1[contains(text(),'Document Center')]")
	private WebElement doclabel;	
	@FindBy(xpath="//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']")
	private WebElement selDrp;	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement txtfield;
	@FindBy(xpath="//button[@class='search-btn btn']")
	private WebElement serch;
	@FindBy(xpath="/html[1]/body[1]/payasia-root[1]/app-employee[1]/div[1]/div[1]/app-hris[1]/app-document-center[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/label[1]")
	private WebElement catgry;
	@FindBy(xpath="//div[@class='ui-toast-detail']")
	private WebElement ele;
	
	
	
	
	
	
	public DocumentCenterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
		
	}
		
	
	

	public void docCent(WebDriver driver)
	{
		String expMsg1="Document Center";
		String expMsg2="Please select category";
		WaitStatementLib.explicitWaitForClickable(driver, 20, menu);
	    menu.click();
	    WaitStatementLib.explicitWaitForClickable(driver, 5, hris);
	    hris.click();
	    WaitStatementLib.explicitWaitForClickable(driver, 5, doclink);
	    doclink.click();
	    WaitStatementLib.iSleep(5);
	    menu.click();
	    WaitStatementLib.explicitWaitVisibility(driver, 5 , doclabel);
	    String actMsg1=doclabel.getText();
	    Assert.assertEquals(actMsg1, expMsg1);  //screen name compared
	    WaitStatementLib.iSleep(3);
	    serch.click();
	    WaitStatementLib.explicitWaitVisibility(driver,6,ele );
		String actMsg2=ele.getText();
		Assert.assertEquals(actMsg2,expMsg2);
		WaitStatementLib.iSleep(5);	
		
		// Document Name for General Category is checked and downloaded
		
		catgry.click();  // click on the Category drop down
		WaitStatementLib.iSleep(2);
		driver.findElement(By.xpath("//span[contains(text(),'General')]")).click();
		WaitStatementLib.iSleep(2);		
		selDrp.click();  // select drop down clicked
		WaitStatementLib.iSleep(2);
		driver.findElement(By.xpath("//span[contains(text(),'Document Name')]")).click();
		WaitStatementLib.iSleep(2);
		txtfield.sendKeys("demo");
		serch.click();
		WaitStatementLib.iSleep(3);
		driver.findElement(By.xpath("//button[@class='action-icon downloadDocument']")).click();  // download button of first row is clicked	
		WaitStatementLib.iSleep(2);
		String actMsg3=doclabel.getText();
		Assert.assertEquals(actMsg3, expMsg1);  //screen name compared again	
		
		// Document Description for Payslip Category checked and downloaded
		
				WaitStatementLib.iSleep(2);	
				catgry.click();  // click on the Category drop down
				WaitStatementLib.iSleep(2);
				driver.findElement(By.xpath("//li[@role='option']/span[text()='Payslip']")).click();
				WaitStatementLib.iSleep(2);		
				selDrp.click();  // select drop down clicked
				WaitStatementLib.iSleep(2);
				driver.findElement(By.xpath("//span[contains(text(),'Document Description')]")).click();
				WaitStatementLib.iSleep(2);
				txtfield.clear();
				txtfield.sendKeys("Kiran_1");
				serch.click();
				WaitStatementLib.iSleep(3);
				driver.findElement(By.xpath("//button[@class='action-icon downloadDocument']")).click();  // download button of first row is clicked	
				WaitStatementLib.iSleep(2);
				String actMsg6=doclabel.getText();
				Assert.assertEquals(actMsg6, expMsg1);  //screen name compared again	
				
				
				
		//Year for  Payslip Category checked and downloaded
				
				WaitStatementLib.iSleep(3);	
				catgry.click();  // click on the Category drop down
				WaitStatementLib.iSleep(2);
				driver.findElement(By.xpath("//li[@role='option']/span[text()='Payslip']")).click();
				WaitStatementLib.iSleep(2);		
				selDrp.click();  // select drop down clicked
				WaitStatementLib.iSleep(2);
				driver.findElement(By.xpath("//span[contains(text(),'Year')]")).click();
				WaitStatementLib.iSleep(2);
				txtfield.clear();
				txtfield.sendKeys("2019");
				serch.click();
				WaitStatementLib.iSleep(3);
				driver.findElement(By.xpath("//button[@class='action-icon downloadDocument']")).click();  // download button of first row is clicked	
				WaitStatementLib.iSleep(2);
				String actMsg5=doclabel.getText();
				Assert.assertEquals(actMsg5, expMsg1);  //screen name compared again			
				
				
		
		
		//Type PDF and Category payslip is checked and downloaded

		WaitStatementLib.iSleep(2);	
		catgry.click();  // click on the Category drop down
		WaitStatementLib.iSleep(3);
		driver.findElement(By.xpath("//li[@role='option']/span[text()='Payslip']")).click();
		WaitStatementLib.iSleep(2);		
		selDrp.click();  // select drop down clicked
		WaitStatementLib.iSleep(2);
		driver.findElement(By.xpath("//span[contains(text(),'Type')]")).click();
		WaitStatementLib.iSleep(2);
		txtfield.clear();
		txtfield.sendKeys("PDF");
		serch.click();
		WaitStatementLib.iSleep(3);
		driver.findElement(By.xpath("//button[@class='action-icon downloadDocument']")).click();  // download button of first row is clicked	
		WaitStatementLib.iSleep(2);
		String actMsg4=doclabel.getText();
		Assert.assertEquals(actMsg4, expMsg1);  //screen name compared again		
		
		
		
        Reporter.log("Document Center page verified", true);    
		
	}	

	

}
