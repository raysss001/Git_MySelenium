package com.payasia.pageobjects;
import java.io.*; 
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.JavascriptExecutor;

import com.payasia.generic.WaitStatementLib;



import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.*;




public class MyProfilePage {
	
	@FindBy(xpath="//button[@class='sidebar-toggle']")
	private WebElement menu;
	@FindBy(xpath="//a[@class='dashboard']//span[contains(text(),'HRIS')]")
	private WebElement hris;
	@FindBy(xpath="//span[contains(text(),'My Profile')]")
	private WebElement myproLink;
	@FindBy(xpath="//h1[contains(text(),'Employee No. : demoemp')]")
	private WebElement empno;
	@FindBy(xpath="//a[contains(text(),'Employee Information')]")
	private WebElement empInfo;
	@FindBy(xpath="//span[@class='fz14'][contains(text(),'demoemp')]")
	private WebElement firstName;
	@FindBy(xpath="//a[contains(text(),'Personal Details')]")
	private WebElement persoLink;
	@FindBy(xpath="//a[contains(text(),'Dependent Details')]")
	private WebElement DependentDetailsLink;
	@FindBy(xpath="//label[text()='Date of Birth ']/../../..//input[@autocomplete='off']")
	private WebElement DOB;
	@FindBy(xpath="//a[contains(text(),'15')]")
	private WebElement dateValue;
	@FindBy(xpath="//button[contains(text(),'Update')]")
	private WebElement submit;
	@FindBy(xpath="//div[@class='ui-toast-detail']")
	private WebElement succes;	
	@FindBy(xpath="//input[@id='custfield_72']")
	private WebElement Kstring;
	@FindBy(xpath="//h3[text()='doc1']/../../../..//button[text()='Add']")
	private WebElement docTableAdd;
/*	@FindBy(xpath="//label[text()='File ']/../..//span[text()='Choose']")
	private WebElement chose;*/
	@FindBy(xpath="//button[text()='Save']")
	private WebElement Save;
	@FindBy(xpath="//h3[text()='table1']/../../../..//button[text()='Save']")
	private WebElement table1Save;
	@FindBy(xpath="//div[text()='Data Save Success']")
	private WebElement docSucces;	
	@FindBy(xpath="//span[@class='ui-fileupload-choose ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']")
	private WebElement chose;
	@FindBy(id="custcol_3")
	private WebElement docDesc;
	@FindBy(xpath="//h3[text()='table1']")
	private WebElement tableLabel;
	@FindBy(xpath="//h3[text()='table1']/../../../..//button[text()='Add']")
	private WebElement tableAdd;
	@FindBy(xpath="//h3[text()='table1']/../../../..//input[@id='custcol_2']")
	private WebElement col1;
	@FindBy(xpath="//h3[text()='table1']/../../../..//input[@id='custcol_3']")
	private WebElement col2;
	@FindBy(xpath="//h3[text()='table1']/../../../..//input[@id='custcol_4']")
	private WebElement col3;
	@FindBy(xpath="//div[text()='Employee data saved successfully']")
	private WebElement empsuc;
	@FindBy(xpath="//h3[text()='table1']/../../../..//span[@class='action-icon']")
	private WebElement table1EditFirst;
	@FindBy(xpath="//h3[text()='table1']/../../../..//span[@class='action-icon'][2]")
	private WebElement table1DeleteFirst;
	@FindBy(xpath="//h3[text()='table1']/../../../..//button[contains(text(),'Delete')]")
	private WebElement table1DeleteOk;	
	@FindBy(xpath="//div[text()='Employee row data deleted successfully']")
	private WebElement table1DeleteSuccess;	
	@FindBy(xpath="//i[@class='arrow-icon arrow-right']")
	private WebElement arrowRight;
	@FindBy(xpath="//h3[text()='Dependents']/../../..//button[text()='Add']")
	private WebElement dependentAdd;
	@FindBy(xpath="//form-button[@class='ng-star-inserted']//button[text()='Update']")
	private WebElement bottomSubmit;
	@FindBy(xpath="//h3[text()='Dependents']/../../..//span[@class='action-icon']")
	private WebElement dependentEditFirst;
	@FindBy(xpath="//input[@id='custcol_2']")
	private WebElement dependentName;
	@FindBy(xpath="//button[contains(text(),'Close')]")
	private WebElement depClose;
	@FindBy(xpath="//h3[text()='Dependents']/../../..//span[@class='action-icon'][2]")
	private WebElement depDeleteFirst;
	@FindBy(xpath="//button[text()='	Delete	']")
	private WebElement depDeleteOk;
	@FindBy(xpath="//div[text()='Employee row data deleted successfully']")
	private WebElement depDeleteSuccess;	
	@FindBy(xpath="//label[text()='Effective Date ']/../../../..//button/span")
	private WebElement depCalendar;
	@FindBy(xpath="//td[contains(@class,'ui-datepicker-today')]")
	private WebElement depCurrentDate;
	@FindBy(xpath="//label[text()='Dependent Relationship ']/../..//span[contains(@class,'ui-dropdown')]")
	private WebElement depRelation;
	@FindBy(xpath="//span[text()='Father']")
	private WebElement fathr;	
	@FindBy(xpath="//h2[text()='table1']/../../..//button[text()='Update']")
	private WebElement tab1Update;
	@FindBy(xpath="//h2[text()='Dependents']/../../..//button[text()='Update']")
	private WebElement depUpdate;	
	@FindBy(xpath="//h3[text()='doc1']/../../../..//button[@class='action-icon ng-star-inserted']")
	private WebElement doc1EditFirst;
	@FindBy(xpath="//h3[text()='doc1']/../../../..//button[@class='action-icon ng-star-inserted'][2]")
	private WebElement doc1DeleteFirst;
	@FindBy(xpath="//button[text()='	Delete	']")
	private WebElement doc1DeleteOk;
	@FindBy(xpath="//div[text()='Employee row data deleted successfully']")
	private WebElement doc1DeleteSuccess;
	
	@FindBy(xpath="//button[@class='close-icon']")
	private WebElement closeIcon;
	
	
	@FindBy(id="custfield_5")
	private WebElement dep1;
	@FindBy(xpath="/html[1]/body[1]/payasia-root[1]/app-employee[1]/div[1]/div[1]/app-hris[1]/app-my-profile[1]/section-details[1]/section[1]/div[1]/div[1]/div[1]/user-profile[1]/div[1]/div[1]/div[1]/dynamic-form[1]/form[1]/div[1]/form-button[1]/div[1]/button[1]")
	private WebElement depSubmit;
	
	
		
	
	
	public MyProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
		
	}	
	
	public void myPro(WebDriver driver) throws IOException
	{
		
		String expMsg1="Employee No. : demoemp";
		String expMsg2="Employee Information";
		String expMsg3="demoemp";
		String expMsg4="Employee data updated successfully";
		String expMsg5="Data Save Success";	
		String expMsg6="Employee data saved successfully";
		String expMsg8="Effective date already exist";
		String expMsg11="Employee row data deleted successfully";
		String expMsg12="Employee row data deleted successfully";
		String expMsg13="Employee row data deleted successfully";
		WaitStatementLib.explicitWaitForClickable(driver, 20, menu);
		menu.click();
		WaitStatementLib.iSleep(3);
		hris.click();
		WaitStatementLib.iSleep(3);
		myproLink.click();
		menu.click();
		WaitStatementLib.iSleep(5);	
		String actMsg1=empno.getText();
		String actMsg2=empInfo.getText();
		String actMsg3=firstName.getText();
		//expMsg3=expMsg3.trim();
		Assert.assertEquals(actMsg1,expMsg1);
		Assert.assertEquals(actMsg2,expMsg2);
		Assert.assertEquals(expMsg3,actMsg3);
	    persoLink.click();
	    WaitStatementLib.iSleep(5);
	    DOB.click();
	    WaitStatementLib.iSleep(2);
	    dateValue.click();
	    WaitStatementLib.iSleep(5);
	   /* JavascriptExecutor js = ((JavascriptExecutor) driver);
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");*/  	  
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Kstring);
	    Kstring.clear();
	    Kstring.sendKeys("123");
	    
	    
	  /*  //doc1  working but issue comes because of browser doesn't come to focus while uploading
	 
   		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	   if(browserName.equalsIgnoreCase("chrome"))
	   {
	    
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", docTableAdd);
	    docTableAdd.click();
	    WaitStatementLib.explicitWaitForClickable(driver,20,chose);
	    chose.click();	
	    WaitStatementLib.iSleep(5);
	    driver.manage().window().maximize();
	    Runtime.getRuntime().exec("C:\\Users\\kiransingh\\Documents\\AutoIt scripts\\Payasia.exe");
	    driver.manage().window().maximize();
	    WaitStatementLib.iSleep(5);	   
	    Save.click();
	    WaitStatementLib.explicitWaitVisibility(driver,10,docSucces);
	    //WaitStatementLib.iSleep(2);
	    String actMsg5=docSucces.getText();
	    Assert.assertEquals(actMsg5,expMsg5);
	    WaitStatementLib.iSleep(5);
	    doc1EditFirst.click();
	    WaitStatementLib.iSleep(3);
	    docDesc.clear();
	    docDesc.sendKeys("Decsription desc");
	    submit.click();
	    //WaitStatementLib.iSleep(4);
	    WaitStatementLib.explicitWaitVisibility(driver, 10, docSucces);
	    String actMsg10=docSucces.getText();
	    Assert.assertEquals(actMsg10, expMsg5);
	    WaitStatementLib.iSleep(5);
	    doc1DeleteFirst.click();
	    WaitStatementLib.iSleep(4);
	    doc1DeleteOk.click();
	    WaitStatementLib.iSleep(4);
	    String actMsg11=doc1DeleteSuccess.getText();
	    Assert.assertEquals(actMsg11,expMsg11);
	    WaitStatementLib.iSleep(5);
	   }*/
	    
	    
	    
	    
	    
	    
	    
	    
	    
	/*    
	    driver.findElement(By.xpath("//h3[text()='doc1']")).click();
	    //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",bottomSubmit);
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
	    //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    WaitStatementLib.iSleep(5);
	    System.out.println("Button name = "+bottomSubmit.getText());
	    bottomSubmit.click();
	    WaitStatementLib.iSleep(2);
	    String actMsg4=succes.getText();
	    Assert.assertEquals(actMsg4,expMsg4);  */
	    
	    
	    
	 
	    
	    //table1
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",tableAdd);
	    tableAdd.click();
	    WaitStatementLib.iSleep(5);
	    col1.clear();
	    col1.sendKeys("Value1");
	    col2.clear();
	    col2.sendKeys("Value2");
	    col3.clear();
	    col3.sendKeys("Value3");
	    table1Save.click();
	    //WaitStatementLib.iSleep(3);
	    WaitStatementLib.explicitWaitVisibility(driver, 10, empsuc);
	    String actMsg6=empsuc.getText();
	    Assert.assertEquals(actMsg6,expMsg6);
	    WaitStatementLib.iSleep(6);
	    table1EditFirst.click();
	    WaitStatementLib.iSleep(3);
	    col2.clear();
	    col2.sendKeys("Value5");
	    WaitStatementLib.iSleep(3);
	    tab1Update.click();
	    //WaitStatementLib.iSleep(2);
	    WaitStatementLib.explicitWaitVisibility(driver, 10, empsuc);
	    String actMsg7=empsuc.getText();
	    Assert.assertEquals(actMsg7, expMsg6);
	    WaitStatementLib.iSleep(5);
	    table1DeleteFirst.click();
	    WaitStatementLib.iSleep(4);
	    table1DeleteOk.click();
	    WaitStatementLib.iSleep(3);
	    String actMsg12=table1DeleteSuccess.getText();
	    Assert.assertEquals(actMsg12,expMsg12);	  
	    
	    //dependent
	    arrowRight.click();
	    WaitStatementLib.iSleep(4);
	    arrowRight.click();
	    WaitStatementLib.iSleep(4);
	    arrowRight.click();
	    WaitStatementLib.iSleep(4);
	    DependentDetailsLink.click();
	    WaitStatementLib.iSleep(5);
	    dependentAdd.click();
	    WaitStatementLib.iSleep(3);
	    depCalendar.click();
	    WaitStatementLib.iSleep(3);
	    depCurrentDate.click();
	    WaitStatementLib.iSleep(3);
	    dependentName.sendKeys("Billy");
	    depRelation.click();
	    WaitStatementLib.iSleep(3);
	    fathr.click();
	    WaitStatementLib.iSleep(3);
	    Save.click();
	    WaitStatementLib.iSleep(3);
	    String actMsg14=empsuc.getText();
	    Assert.assertEquals(actMsg14,expMsg6);	
	    WaitStatementLib.iSleep(5);
	    dependentAdd.click();
	    WaitStatementLib.iSleep(3);
	    Save.click();
	    WaitStatementLib.iSleep(3);
	    String actMsg8=succes.getText();	 
	    Assert.assertEquals(actMsg8,expMsg8);
	    WaitStatementLib.iSleep(8);
	    
	    
	    
	    
	    
	    closeIcon.click();
	    //depClose.click();
	    WaitStatementLib.iSleep(3);
	    dependentEditFirst.click();
	    WaitStatementLib.iSleep(3);
	    dependentName.clear();
	    dependentName.sendKeys("Silly");
	    WaitStatementLib.iSleep(3);
	    depUpdate.click();
	    WaitStatementLib.iSleep(3);
	    String actMsg9=empsuc.getText();
	    Assert.assertEquals(actMsg9,expMsg6);
	    WaitStatementLib.iSleep(5);
	    depDeleteFirst.click();
	    WaitStatementLib.iSleep(3);
	    depDeleteOk.click();
	    WaitStatementLib.iSleep(3);
	    String actMsg13=depDeleteSuccess.getText();
	    Assert.assertEquals(actMsg13,expMsg13);	
	    
	    
	    
	    WaitStatementLib.iSleep(3);
	    dep1.clear();
	    WaitStatementLib.iSleep(5);
	    dep1.sendKeys("Dependent Details");
	    WaitStatementLib.iSleep(3); 
	    WaitStatementLib.explicitWaitForClickable(driver, 20, depSubmit);
	    depSubmit.click();
	    WaitStatementLib.iSleep(3);
	    String actMsg15=succes.getText();
	    String expMsg15="Employee data updated successfully";
	    Assert.assertEquals(actMsg15, expMsg15);
	    
	    
	    
	    
	    
	    
	    
	   
	    Reporter.log("My Profile page verified.",true);
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
