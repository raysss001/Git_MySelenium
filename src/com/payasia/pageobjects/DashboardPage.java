package com.payasia.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.payasia.generic.WaitStatementLib;
import org.openqa.selenium.JavascriptExecutor;

public class DashboardPage {
	
	
	@FindBy(xpath="//a[@class='pointer dashboard']")
	private WebElement dash;
	@FindBy(xpath="//span[contains(text(),'Welcome')]")
	private WebElement wel;
	
	@FindBy(xpath="//span[text()='Welcome']/../..//div[text()='HRIS']")
	private WebElement myHRIS;
	@FindBy(xpath="//span[text()='Welcome']/../..//div[text()='Leave']")
	private WebElement myLeave;
	@FindBy(xpath="//span[text()='Welcome']/../..//div[text()='Claim']")
	private WebElement myClaim;	
	
	@FindBy(xpath="//h3[text()='Requests Pending For']/..//div[text()='HRIS']")
    private WebElement pendingHRIS;
	@FindBy(xpath="//h3[text()='Requests Pending For']/..//div[text()='Leave']")
    private WebElement pendingLeave;
	@FindBy(xpath="//h3[text()='Requests Pending For']/..//div[text()='Claim']")
    private WebElement pendingClaim;
	
	@FindBy(xpath="//h1[contains(text(),'My HRIS Request')]")
	private WebElement myHRISScreen;	
	@FindBy(xpath="//span[text()='Leaves']")
	private WebElement myLeaveScreen;
	@FindBy(xpath="//span[text()='My Claim']")
	private WebElement myClaimScreen;
	
	
	@FindBy(xpath="//h1[text()='HRIS Pending Items']")
	private WebElement pendingHRISScreen;	
	@FindBy(xpath="//span[text()='Pending For Approval']")
	private WebElement pendingLeaveScreen;
	@FindBy(xpath="//span[text()='Pending claims']")
	private WebElement pendingClaimScreen;
	
	
	@FindBy(xpath="//h2[text()='Quick Links']/..//a[text()='Change Password']")
	private WebElement changePass;
	@FindBy(xpath="//h1[text()='Change Password']")
	private WebElement changePassScreen;
	
	
	@FindBy(xpath="//h2[text()='Quick Links']/..//a[text()='Update Info']")
	private WebElement updateInfo;
	@FindBy(xpath="//a[text()='Employee Information']")
	private WebElement updateInfoScreen;
	
	
	@FindBy(xpath="//h4[text()='Tomorrow is Holliday.']")
	private WebElement announce;
	
	@FindBy(xpath="//h3[text()='Recent Activities']/../..//label[contains(text(),'All - ')]")
	private WebElement recentAll;	
	@FindBy(xpath="//h3[text()='Recent Activities']/../..//span[contains(text(),'My Request -')]")
	private WebElement recentMyRequest;
	@FindBy(xpath="//h3[text()='Recent Activities']/../..//span[contains(text(),'Pending-Leave Apps -')]")
	private WebElement recentLeave;
	@FindBy(xpath="//h3[text()='Recent Activities']/../..//span[contains(text(),'Pending-Claim Apps -')]")
	private WebElement recentClaim;
	@FindBy(xpath="//h3[text()='Recent Activities']/../..//span[contains(text(),'Pending-HRIS Apps -')]")
	private WebElement recentHRIS;
	
	
	@FindBy(xpath="//span[text()='Go to Payslips']")
	private WebElement goToPayslip;
	@FindBy(xpath="//h1[text()='Payslip']")
	private WebElement goToPayslipScreen;
	@FindBy(xpath="(//button[@class='view-btn btn'][1])[1]")
	private WebElement viewPayslip;
	@FindBy(xpath="(//button[@class='view-btn btn'][2])[1]")
	private WebElement downloadPayslip;
	@FindBy(xpath="//h2[contains(text(),'Preview Payslip')]")
	private WebElement paysliptitle;
	@FindBy(xpath="//h2[text()='Preview Payslip']/../button[@class='close-icon']")
	private WebElement payslipClose;
	
	
	@FindBy(xpath="//h3[text()='Document Center']/../..//label[text()='General']")
	private WebElement docGeneral;
	@FindBy(xpath="//h3[text()='Document Center']/../..//span[text()='Payslip']")
	private WebElement payslip;	
	@FindBy(xpath="//h3[text()='Document Center']/../..//label[text()='Select']")
	private WebElement docSelect;
	@FindBy(xpath="//h3[text()='Document Center']/../..//span[text()='Document Name']")
	private WebElement docName;
	@FindBy(xpath="//h3[text()='Document Center']/../..//input[@placeholder='Search']")
	private WebElement docSearch;
	@FindBy(xpath="//div[text()=' demoemp_payslip_201741.pdf']/../..//i[@class='icon-object']")
	private WebElement docDownload;
	
	
	
	
	
	
	
	
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
		
	public void verifyDashboard(WebDriver driver){
		
		String expMsg="Welcome";
		String expMsg1="My HRIS Request";
		String expMsg2="Leaves";
		String expMsg3="My Claim";
		String expMsg4="HRIS Pending Items";
		String expMsg5="Pending For Approval";
		String expMsg6="Pending claims";
		String expMsg7="Change Password";
		String expMsg8="Employee Information";
		String expMsg9="Payslip";
		String expMsg10="Preview Payslip";
		
		myHRIS.click();
		WaitStatementLib.iSleep(6);
		String actMsg1=myHRISScreen.getText();
		assertEquals(actMsg1, expMsg1);		
		dash.click();
		WaitStatementLib.iSleep(4);
		String actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
		myLeave.click();
		WaitStatementLib.iSleep(6);
		String actMsg2=myLeaveScreen.getText();
		assertEquals(actMsg2, expMsg2);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
		myClaim.click();
		WaitStatementLib.iSleep(6);
		String actMsg3=myClaimScreen.getText();
		assertEquals(actMsg3, expMsg3);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
		
		pendingHRIS.click();
		WaitStatementLib.iSleep(6);
		String actMsg4=pendingHRISScreen.getText();
		assertEquals(actMsg4, expMsg4);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
		pendingLeave.click();
		WaitStatementLib.iSleep(6);
		String actMsg5=pendingLeaveScreen.getText();
		assertEquals(actMsg5, expMsg5);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
		pendingClaim.click();
		WaitStatementLib.iSleep(6);
		String actMsg6=pendingClaimScreen.getText();
		assertEquals(actMsg6, expMsg6);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
		
		changePass.click();
		WaitStatementLib.iSleep(5);
		String actMsg7=changePassScreen.getText();
		assertEquals(actMsg7, expMsg7);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
        updateInfo.click();
		WaitStatementLib.iSleep(5);
		String actMsg8=updateInfoScreen.getText();
		assertEquals(actMsg8, expMsg8);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		
		
	
		
		
		goToPayslip.click();
		WaitStatementLib.iSleep(5);
		String actMsg9=goToPayslipScreen.getText();
		assertEquals(actMsg9, expMsg9);		
		dash.click();
		WaitStatementLib.iSleep(4);
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);		
		viewPayslip.click();
		WaitStatementLib.iSleep(5);
		String actMsg10=paysliptitle.getText();
		assertEquals(actMsg10, expMsg10);
		payslipClose.click();
		actMsg=wel.getText();
		assertEquals(actMsg,expMsg);
		WaitStatementLib.iSleep(3);
		downloadPayslip.click();
		WaitStatementLib.iSleep(5);
		
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",docGeneral);
		docGeneral.click();
		WaitStatementLib.iSleep(5);
		payslip.click();
		WaitStatementLib.iSleep(5);
		docSelect.click();
		WaitStatementLib.iSleep(2);
		docName.click();
		WaitStatementLib.iSleep(2);
		docSearch.sendKeys("demoemp_payslip_201741");
		WaitStatementLib.iSleep(3);
        docDownload.click();
        assertEquals(actMsg,expMsg);
        WaitStatementLib.iSleep(4);	
		
		String recAll=recentAll.getText();
		recAll= recAll.substring(recAll.indexOf("[")+1,recAll.indexOf("]"));
		int expAll=Integer.parseInt(recAll);	
		recentAll.click();
		WaitStatementLib.iSleep(5);		
		String recMyrequest=recentMyRequest.getText();
		recMyrequest= recMyrequest.substring(recMyrequest.indexOf("[")+1,recMyrequest.indexOf("]"));
		int Myrequest=Integer.parseInt(recMyrequest);		
		String recHRIS=recentHRIS.getText();
		recHRIS= recHRIS.substring(recHRIS.indexOf("[")+1,recHRIS.indexOf("]"));
		int HRIS=Integer.parseInt(recHRIS);		
		String recLeave=recentLeave.getText();
		recLeave= recLeave.substring(recLeave.indexOf("[")+1,recLeave.indexOf("]"));
		int Leave=Integer.parseInt(recLeave);		
		String recClaim=recentClaim.getText();
		recClaim= recClaim.substring(recClaim.indexOf("[")+1,recClaim.indexOf("]"));
		int Claim=Integer.parseInt(recClaim);		
		int actAll= Myrequest + HRIS + Leave + Claim;		
		assertEquals(actAll,expAll);			
		Reporter.log("Dashboard screen verified",true);
		
		
		
		
		
	}
	
	
}
