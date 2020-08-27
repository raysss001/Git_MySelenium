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



public class PendingItemsPage  {

	@FindBy(xpath="//button[@class='sidebar-toggle']")
	private WebElement menu;
	@FindBy(xpath="//a[@class='dashboard']//span[contains(text(),'HRIS')]")
	private WebElement hris;
	@FindBy(xpath="//span[contains(text(),'HRIS Pending Items')]")
	private WebElement pendingItemLink;
	@FindBy(xpath="/html[1]/body[1]/payasia-root[1]/app-employee[1]/div[1]/div[1]/app-hris[1]/app-pending-item[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/label[1]")
	private WebElement sel;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement srchTxt;
	@FindBy(id="filterBtn")
	private WebElement srchBtn;
	@FindBy(xpath="//body[@class='sidebar-mini sidebar-collapse']/payasia-root/app-employee[@class='ng-star-inserted']/div[@class='wrapper']/div[@class='content-wrapper']/app-hris[@class='ng-star-inserted']/app-pending-item[@class='ng-star-inserted']/section[@class='container-fluid']/div[@class='col-12']/div[@class='row']/app-turbotable/div[@id='turbotable']/p-table[@class='customized-sort-icon grid-view-custom']/div[@class='borderless ui-table ui-widget ui-table-responsive ui-table-auto-layout']/div[@class='ui-table-wrapper ng-star-inserted']/table/tbody[@class='ui-table-tbody']/tr[1]/td[8]/span[2]/span[1]/button[1]/i[1]/*[1]")
	private WebElement btn;
	@FindBy(xpath="//button[@class='action-icon reviewchagerequest']")	               
	private WebElement viewBtn;
	@FindBy(xpath="//div[@class='ui-toast-detail' and contains(text(),'HRIS change request Rejected successfully.')]")	               
	private WebElement rejSuc;
	@FindBy(xpath="//div[@class='ui-toast-detail' and contains(text(),'HRIS change request Forwarded successfully.')]")	               
	private WebElement forSuc;
	@FindBy(xpath="//div[@class='ui-toast-detail' and contains(text(),'HRIS change request Approved successfully.')]")	               
	private WebElement aprSuc;
	@FindBy(xpath="//span[contains(text(),'Field')]")
	private WebElement field;
	
	
	
	
	
	
	
	


	public PendingItemsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		

	}

	public void pendItems(WebDriver driver)
	{
		String expMsg1="HRIS Pending Items";
		String expMsg2="Review Change Data";
		String expMsg3="HRIS change request Rejected successfully.";
		String expMsg4="HRIS change request Forwarded successfully.";
        String expMsg5="HRIS change request Approved successfully.";
                     
		
        WaitStatementLib.explicitWaitForClickable(driver, 20, menu);
		menu.click();
		WaitStatementLib.iSleep(4);
		hris.click();
		WaitStatementLib.iSleep(4);
		pendingItemLink.click();
		menu.click();
		WaitStatementLib.iSleep(6);	
		String actMsg1=driver.findElement(By.xpath("//h1[contains(text(),'HRIS Pending Items')]")).getText();
		Assert.assertEquals(actMsg1,expMsg1);
		sel.click();
		WaitStatementLib.iSleep(6);
		driver.findElement(By.xpath("//span[contains(text(),'Field')]")).click();
		WaitStatementLib.iSleep(4);
		srchTxt.sendKeys("Mobile Number");
		srchBtn.click();
		WaitStatementLib.iSleep(7);	
		btn.click();
		WaitStatementLib.iSleep(6);
		viewBtn.click();
		WaitStatementLib.iSleep(6);
		String actMsg2 = driver.findElement(By.xpath("//h2[contains(text(),'Review Change Data')]")).getText();	
		Assert.assertEquals(actMsg2, expMsg2);
		driver.findElement(By.xpath("//button[@class='btn close-btn']")).click();
		WaitStatementLib.iSleep(6);
		String actMsg3 = driver.findElement(By.xpath("//h1[contains(text(),'HRIS Pending Items')]")).getText();	
		Assert.assertEquals(actMsg3, expMsg1);		
		btn.click();
		WaitStatementLib.iSleep(6);
		viewBtn.click();
		WaitStatementLib.iSleep(6);
		String actMsg4 = driver.findElement(By.xpath("//h2[contains(text(),'Review Change Data')]")).getText();
		Assert.assertEquals(actMsg4, expMsg2);
		driver.findElement(By.xpath("//button[contains(text(),'Reject')]")).click();
		WaitStatementLib.explicitWaitVisibility(driver, 20, rejSuc);
		String actMsg5= rejSuc.getText();
		Assert.assertEquals(expMsg3, actMsg5);
		WaitStatementLib.iSleep(6);
		
		
		
		srchTxt.clear();
		srchTxt.sendKeys("Address");
		srchBtn.click();
		WaitStatementLib.iSleep(6);
		btn.click();
		WaitStatementLib.iSleep(5);
		viewBtn.click();
		WaitStatementLib.iSleep(5);
		String actMsg6 = driver.findElement(By.xpath("//h2[contains(text(),'Review Change Data')]")).getText();
		Assert.assertEquals(actMsg6, expMsg2);
		driver.findElement(By.xpath("//button[contains(text(),'Approve and Forward')]")).click();
		WaitStatementLib.explicitWaitVisibility(driver, 20, forSuc);
		String actMsg7= forSuc.getText();
		Assert.assertEquals(expMsg4, actMsg7);
		WaitStatementLib.iSleep(6);
		
		
		
		
		srchTxt.clear();
		srchTxt.sendKeys("Marital Status");
		srchBtn.click();
		WaitStatementLib.iSleep(6);
		btn.click();
		WaitStatementLib.iSleep(5);
		viewBtn.click();
		WaitStatementLib.iSleep(5);
		String actMsg8 = driver.findElement(By.xpath("//h2[contains(text(),'Review Change Data')]")).getText();
		Assert.assertEquals(actMsg8, expMsg2);
		driver.findElement(By.xpath("//button[text()='Approve']")).click();
		WaitStatementLib.explicitWaitVisibility(driver, 20, aprSuc);
		String actMsg9=aprSuc.getText();
		Assert.assertEquals(expMsg5, actMsg9);
		
		
		
		
		Reporter.log("HRIS Pending Items page verified", true);



	}



}
