package com.payasia.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.payasia.generic.WaitStatementLib;

public class AdminHrLetterPage extends BasePage {
	@FindBy(xpath="//a[@class='top'][contains(text(),'Reports')]")
	private WebElement report;	
	@FindBy(xpath="//li[@id='54']//a[@href='#'][contains(text(),'HR Letters')]")
	private WebElement hrletter;	
	@FindBy(id="hrLetterSearchButton")
	private WebElement srchbtn;	
	@FindBy(id="addHRLetterButton")
	private WebElement addBtn;	
	@FindBy(id="hrLetterNameAdd")
	private WebElement letterName;	
	@FindBy(id="hrLetterDescriptionAdd")
	private WebElement letterDescription;	
	@FindBy(id="letterDescriptionEdit")
	private WebElement letterDescriptionEdit;
	@FindBy(id="hrLetterSubjectAdd")
	private WebElement sbjct;		
	@FindBy(className="cke_editable")
	private WebElement bdy;
	@FindBy(xpath="//div[6]//div[11]//div[1]//button[1]//span[1]")
	private WebElement sav;	
	@FindBy(xpath="//div[5]//div[11]//div[1]//button[1]//span[1]")
	private WebElement savedit;		
	@FindBy(xpath="//div[20]//div[2]//p[1]")
	private WebElement sucmsg;
	@FindBy(xpath="//div[12]//div[11]//div[1]//button[1]//span[1]")
	private WebElement OK;
	@FindBy(xpath="//td[@title='NAME1']/following-sibling::td//a[text()='Edit']") 	              
	private WebElement nam1edit;	
	
	
	public AdminHrLetterPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);	
		
	}
	
	
	public void addHRLetter(String name,String description,String subject, String body,WebDriver driver)
	{
		report.click();
		hrletter.click();
		WaitStatementLib.iSleep(5);			
		addBtn.click();
		letterName.sendKeys(name);
		letterDescription.sendKeys(description);
		sbjct.sendKeys(subject);
		WaitStatementLib.iSleep(3);
		//driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); //correct
		driver.switchTo().frame(driver.findElement(By.className("cke_wysiwyg_frame")));// correct		
		bdy.sendKeys(body);
		driver.switchTo().defaultContent();		
		sav.click();
		WaitStatementLib.iSleep(3);				
		driver.findElement(By.xpath("//div[@id='hrLetterDialogAlert']/following-sibling::div//button[@type='button']")).click();
		Reporter.log("HR LETTER SAVED SUCCESSFULLY",true);				
	}
	
	public void editHRLetter(String name,String newdesc, WebDriver driver)
	{	WaitStatementLib.explicitWaitForClickable(driver,5,srchbtn);	
		srchbtn.click();
		WaitStatementLib.explicitWaitForClickable(driver,5,nam1edit);
		nam1edit.click();
		WaitStatementLib.explicitWaitForClickable(driver,5, letterDescriptionEdit);
		letterDescriptionEdit.clear();
		letterDescriptionEdit.sendKeys(newdesc);
		savedit.click();
		WaitStatementLib.iSleep(3);	
		driver.findElement(By.xpath("//p[text()=\"HR Letter updated successfully \"]/../following-sibling::div//button[@type=\"button\"]")).click();			                            
		Reporter.log("HR LETTER EDITED/UPDATED SUCCESSFULLY",true);		
	}
	
	public void deleteHRLetter(String name,WebDriver driver)
	{
		driver.findElement(By.xpath("//td[text()=\"NAME1\"]//following-sibling::td/a[text()='Delete']")).click();
		WaitStatementLib.iSleep(3);	
		driver.findElement(By.xpath("//div[@id='deleteHRLetterDialog']//following-sibling::div//button/span[text()='Yes']")).click();
		Reporter.log("HR LETTER DELETED SUCCESSFULLY",true);	
		
	}
	
	
	public void sendHRLetter(String name,WebDriver driver,String expbdydata)
	{
		WaitStatementLib.explicitWaitForClickable(driver,5,srchbtn);	
		srchbtn.click();
		WaitStatementLib.iSleep(3);		
        driver.findElement(By.xpath("//td[@title=\"NAME1\"]/following-sibling::td/a[text()='Send']")).click();
        WaitStatementLib.iSleep(3);
        driver.findElement(By.xpath("//input[@id='sendHRLetterEmpNum']")).sendKeys("demoemp");
        driver.findElement(By.xpath("//input[@id='sendHRLetterEmpNum']")).sendKeys(Keys.DOWN , Keys.RETURN);
        driver.findElement(By.xpath("//button[@type='button']/span[text()='Preview']")).click();
        WaitStatementLib.iSleep(3);	
        String actbdydata=driver.findElement(By.xpath("//div[@id='hrletterPreviewMailDiv']")).getText();
        Assert.assertEquals(actbdydata, expbdydata);
        driver.findElement(By.xpath("//input[@id='hrletterPreviewMailCC']")).sendKeys("kiran.singh@mind-infotech.com");
        driver.findElement(By.xpath("//input[@id='saveInDocCenterCheck']")).click();
        driver.findElement(By.xpath("//span[text()='Send']")).click();
        WaitStatementLib.iSleep(3);	
        String actsendmsg=(driver.findElement(By.xpath("//div[@id='hrLetterDialogAlert']/p[text()='HR Letter send successfully']"))).getText();
            										  
        String expsendmsg="HR Letter send successfully";
        Assert.assertEquals(actsendmsg, expsendmsg);
        driver.findElement(By.xpath("//p[text()='HR Letter send successfully']/../following-sibling::div//span[text()='Ok']")).click();
        Reporter.log("HR LETTER SEND SUCCESSFULLY",true); 
        
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
