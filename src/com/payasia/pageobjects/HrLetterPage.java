package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.payasia.generic.WaitStatementLib;



public class HrLetterPage {
	
	@FindBy(xpath="//button[@class='sidebar-toggle']")
	private WebElement menu;
	@FindBy(xpath="//a[@class='dashboard']//span[contains(text(),'HRIS')]")
	private WebElement hris;
	@FindBy(xpath="//span[contains(text(),'HR Letters')]")
	private WebElement hrlink;	
	@FindBy(xpath="//h1[contains(text(),'HR Letters')]")
	private WebElement hrlabel;
	@FindBy(xpath="//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']")
	private WebElement sel;
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement srchtxt;
	@FindBy(xpath="//button[@class='search-btn btn']")
	private WebElement srchbtn;
	@FindBy(xpath="//button[@class='action-icon generatehrletter']")
	private WebElement action;
	@FindBy(xpath="//ul[@class='ui-inputtext ui-state-default ui-corner-all']")
	private WebElement cc;
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement check;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement close;
	@FindBy(xpath="//button[contains(text(),'Send')]")
	private WebElement send;
	@FindBy(xpath="//button[contains(text(),'View')]")
	private WebElement view;
	@FindBy(xpath="//span[contains(text(),'test1')]")
	private WebElement test1name;
	@FindBy(xpath="//span[contains(text(),'kiran1')]")
	private WebElement kiran1desc;
	@FindBy(xpath="//span[contains(text(),'subject1')]")
	private WebElement subjec;
	@FindBy(xpath="//p[contains(text(),'body1')]")
	private WebElement body;
	
	

	
	
	
	
          public HrLetterPage(WebDriver driver)
          {
	          PageFactory.initElements(driver, this);

          }
	
	    public void hrLetter(WebDriver driver)
	     {
	    	String expMsg="HR Letter send successfully";
	    	String expMsg1="HR Letters";	    	
	    	String expMsg2="test1";
	    	String expMsg3="kiran1";
	    	String expMsg4="subject1";
	    	String expMsg5="body1";
	    	WaitStatementLib.explicitWaitForClickable(driver, 20, menu);
	    	menu.click();
		    WaitStatementLib.explicitWaitForClickable(driver, 5, hris);
		    hris.click();
		    WaitStatementLib.explicitWaitForClickable(driver, 5, hrlink);
		    hrlink.click();	
		    WaitStatementLib.iSleep(5);
		    menu.click();
		    WaitStatementLib.explicitWaitVisibility(driver, 5 , hrlabel);
		    String actMsg1=hrlabel.getText();
		    Assert.assertEquals(actMsg1, expMsg1);  //screen name compared
		    srchbtn.click();
		    WaitStatementLib.iSleep(3);
		    
		    sel.click();  // click on the Select drop down & Name filter set
			WaitStatementLib.iSleep(2);
			driver.findElement(By.xpath("//span[contains(text(),'Name')]")).click(); // Name option selected in  the Select drop down
			WaitStatementLib.iSleep(2);
			srchtxt.sendKeys("test1"); //test1 enter in the Search field
			srchbtn.click();
			WaitStatementLib.iSleep(3);
			String actMsg2= test1name.getText();
			Assert.assertEquals(actMsg2,expMsg2); // 'test1' hr letter name compared
			
			
			sel.click();  // click on the Select drop down & Description filter set
			WaitStatementLib.iSleep(2);
			driver.findElement(By.xpath("//span[contains(text(),'Description')]")).click(); // Description option selected in  the Select drop down
			WaitStatementLib.iSleep(2);
			srchtxt.sendKeys("kiran1"); //kiran1 enter in the Search field
			srchbtn.click();
			WaitStatementLib.iSleep(3);
			String actMsg3= kiran1desc.getText();
			Assert.assertEquals(actMsg3,expMsg3); // 'kiran1' hr letter Description compared
			
			
			
			sel.click();  // click on the Select drop down & Subject filter set
			WaitStatementLib.iSleep(2);
			driver.findElement(By.xpath("//span[contains(text(),'Subject')]")).click(); // Subject option selected in  the Select drop down
			WaitStatementLib.iSleep(2);
			srchtxt.sendKeys("subject1"); //subject1 enter in the Search field
			srchbtn.click();
			WaitStatementLib.iSleep(3);
			String actMsg4= subjec.getText();
			Assert.assertEquals(actMsg4,expMsg4); // 'subject1' hr letter Subject compared		
			
			//Action button click to View the HR letter
			action.click();			
			WaitStatementLib.iSleep(2);
			String actMsg5=body.getText();
			Assert.assertEquals(actMsg5,expMsg5);			
			check.click();
			send.click();			
			WaitStatementLib.iSleep(2);
			WebElement ele=driver.findElement(By.xpath("//div[@class='ui-toast-detail']"));	
			WaitStatementLib.explicitWaitVisibility(driver,6,ele );
			String actMsg=ele.getText();
			Assert.assertEquals(actMsg,expMsg);	 //successful message verified after send is clicked
			
		    
		    // need to handle the screen open after clicking VIEW button of 'Preview Hr Letter'.
		    
		    Reporter.log("HR Letter screen verified", true);
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
		
	     }

}
