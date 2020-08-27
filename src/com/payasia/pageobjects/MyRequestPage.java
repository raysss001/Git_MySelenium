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

public class MyRequestPage {

	@FindBy(xpath="//button[@class='sidebar-toggle']")
	private WebElement menu;
	@FindBy(xpath="//a[@class='dashboard']//span[contains(text(),'HRIS')]")
	private WebElement hris;
	@FindBy(xpath="//span[contains(text(),'HRIS My Request')]")
	private WebElement myreqLink;
	@FindBy(xpath="//button[@class='search-btn btn']")
	private WebElement srch;
	@FindBy(xpath="/html[1]/body[1]/payasia-root[1]/app-employee[1]/div[1]/div[1]/app-hris[1]/app-my-request[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/div[3]/span[1]")
	private WebElement reqdrop;
	@FindBy(xpath="//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']")
	private WebElement sel;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement srchbox;





	public MyRequestPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		

	}




	public void mRequest(WebDriver driver)
	{
		String expMsg1="My HRIS Request";
		String expMsg2="Select a Request Type";
		String expMsg3="Preview Change Request";
		String expMsg5="Withdrawn";
		WaitStatementLib.explicitWaitForClickable(driver, 20, menu);
		menu.click();
		WaitStatementLib.iSleep(3);
		hris.click();
		WaitStatementLib.iSleep(3);
		myreqLink.click();
		WaitStatementLib.iSleep(3);
		menu.click();
		WaitStatementLib.iSleep(5);	
		String actMsg1=driver.findElement(By.xpath("//h1[contains(text(),'My HRIS Request')]")).getText();
		Assert.assertEquals(actMsg1,expMsg1);		
		srch.click();
		WaitStatementLib.iSleep(2);
		WebElement ele=driver.findElement(By.xpath("//div[@class='ui-toast-detail']"));
		WaitStatementLib.explicitWaitVisibility(driver,6,ele );
		String actMsg2=ele.getText();
		Assert.assertEquals(actMsg2,expMsg2);
		WaitStatementLib.iSleep(3);

		// WITHDRAWN CHECK
		reqdrop.click();
		WaitStatementLib.iSleep(3);
		driver.findElement(By.xpath("//span[contains(text(),'Withdrawn')]")).click();
		WaitStatementLib.iSleep(3);
		sel.click();
		WaitStatementLib.iSleep(3);
		driver.findElement(By.xpath("//span[contains(text(),'Field')]")).click();
		WaitStatementLib.iSleep(3);
		srchbox.sendKeys("check2");
		WaitStatementLib.iSleep(3);
		srch.click();
		WaitStatementLib.iSleep(3);
		String a1= driver.findElement(By.xpath("//span[contains(text(),'check2')]")).getText();
		Assert.assertEquals(a1, "check2");
		driver.findElement(By.xpath("//button[@class='action-icon viewRequest']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg3=driver.findElement(By.xpath("//h2[contains(text(),'Preview Change Request')]")).getText();
		Assert.assertEquals(actMsg3,expMsg3);
		driver.findElement(By.xpath("//button[@class='btn close-btn']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg5=driver.findElement(By.xpath("//h1[contains(text(),'My HRIS Request')]")).getText();
		Assert.assertEquals(actMsg5,expMsg1);	


		// REJECTED CHECK
		reqdrop.click();
		driver.findElement(By.xpath("//span[contains(text(),'Rejected')]")).click();
		WaitStatementLib.iSleep(2);
		srchbox.clear();
		srchbox.sendKeys("Mobile Number");
		srch.click();
		WaitStatementLib.iSleep(3);
		String a2= driver.findElement(By.xpath("//span[contains(text(),'Mobile Number')]")).getText();
		Assert.assertEquals(a2, "Mobile Number");
		driver.findElement(By.xpath("//button[@class='action-icon viewRequest']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg6=driver.findElement(By.xpath("//h2[contains(text(),'Preview Change Request')]")).getText();
		Assert.assertEquals(actMsg6,expMsg3);
		driver.findElement(By.xpath("//button[@class='btn close-btn']")).click();
		WaitStatementLib.iSleep(2);
		String actMsg7=driver.findElement(By.xpath("//h1[contains(text(),'My HRIS Request')]")).getText();
		Assert.assertEquals(actMsg7,expMsg1);



		// APPROVED CHECK
		reqdrop.click();
		driver.findElement(By.xpath("//span[contains(text(),'Approved')]")).click();
		WaitStatementLib.iSleep(2);
		srchbox.clear();
		srchbox.sendKeys("checkbox1");
		srch.click();
		WaitStatementLib.iSleep(3);
		String a3= driver.findElement(By.xpath("//span[contains(text(),'checkbox1')]")).getText();
		Assert.assertEquals(a3, "checkbox1");
		driver.findElement(By.xpath("//button[@class='action-icon viewRequest']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg8=driver.findElement(By.xpath("//h2[contains(text(),'Preview Change Request')]")).getText();
		Assert.assertEquals(actMsg8,expMsg3);
		driver.findElement(By.xpath("//button[@class='btn close-btn']")).click();
		WaitStatementLib.iSleep(2);
		String actMsg9=driver.findElement(By.xpath("//h1[contains(text(),'My HRIS Request')]")).getText();
		Assert.assertEquals(actMsg9,expMsg1);




		// SUBMITTED CHECK
		reqdrop.click();
		driver.findElement(By.xpath("//span[contains(text(),'Submitted')]")).click();
		WaitStatementLib.iSleep(5);
		srchbox.clear();
		srchbox.sendKeys("Address");
		srch.click();
		WaitStatementLib.iSleep(5);
		String a4= driver.findElement(By.xpath("//span[contains(text(),'Address')]")).getText();
		Assert.assertEquals(a4, "Address");
		driver.findElement(By.xpath("//button[@class='action-icon viewRequest']")).click();
		WaitStatementLib.iSleep(3);
		String actMsg10=driver.findElement(By.xpath("//h2[contains(text(),'Preview Change Request')]")).getText();
		Assert.assertEquals(actMsg3,expMsg3);
		driver.findElement(By.xpath("//button[@class='btn approve-btn ng-star-inserted']")).click();
		WaitStatementLib.iSleep(5);
		String actMsg11=driver.findElement(By.xpath("//h1[contains(text(),'My HRIS Request')]")).getText();
		Assert.assertEquals(actMsg5,expMsg1);
		Reporter.log("HRIS My Request page verified", true);   



	}














}
