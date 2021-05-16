package com.payasia.generic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class FunctionsLib extends ListenerReport{




	public void click(WebElement element, String name)  {
		try {
			element.click();
			logTestInfo("ELEMENT CLICKED : "+ name);
		}catch(Exception e) {
			logTestInfo("ELEMENT NOT CLICKED : "+ name);
		}
	}


	public void input(WebElement element, String value, String name) {
		try {
			element.sendKeys(value);	
			logTestInfo("ELEMENT INPUT SEND : "+ name);
		}catch(Exception e) {
			
		}	
		
		logTestInfo("ELEMENT INPUT NOT SEND : "+ name);
		logTestInfo("BROWSER NAME IS 1 = ");
		logTestInfo("BROWSER NAME IS 2 = "+System.getProperty("BrowserName"));
	}


	public void verifyTextOnElement(String exp, String act) {
		if(exp.equalsIgnoreCase(act)) {
			logTestInfo("STRINGS ARE EQUAL.");
		}
		else{
			logTestInfo("STRINGS ARE NOT EQUAL.");

		}

	}

	public String generate_String_alphabet() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();	 
		return generatedString;			
	}

	
	public void waitForAlert()
	{

		int i=0;
		while(i++<5)
		{
			try
			{
				Alert alert = driver.switchTo().alert();
				logTestPassSnap("Attempt "+i+" : Alert Found.");
				break;
			}
			catch(NoAlertPresentException e)
			{ if(i==5) {
				logTestFailSnap("Attempt "+i+" : Alert Not Found.");
			}
			logTestInfo("Attempt "+i+" : Alert Not Found.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException c) {
				e.printStackTrace();
			}
			continue;
			}
		}

	}

	/***************** WAIT FUNCTIONS ***************************/

	public void iSleep(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void ImplicitWaitForSeconds(int sec)
	{

		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);


	}	

	public void ImplicitWaitForMinutes(int mins)
	{

		driver.manage().timeouts().implicitlyWait(mins,TimeUnit.MINUTES);


	}			

	public void explicitWaitVisibility(WebDriver driver,int sec, WebElement ele,String elementName)
	{

		WebDriverWait wait= new WebDriverWait(driver,sec);
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			logTestPass("waiting for element to be visible : "+ elementName + " -- Element Found.");
		}catch(Exception e) {			
			logTestPass("waited for : "+ sec+" seconds");
			logTestFailSnap("Wait limit exceeded : " + elementName + " -- Element Not Found.");
		}		
	}		

	public void explicitWaitForClickable(WebDriver Tdriver,int sec, WebElement ele, String elementName)
	{

		WebDriverWait wait= new WebDriverWait(Tdriver,sec);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			logTestPass("waiting for element to be clickable : "+ elementName + " -- Element Clickable.");
		}catch(Exception e) {logTestPass("waited for : "+ sec+" seconds");}

		logTestFailSnap("Wait limit exceeded : "+ elementName + " -- Element not Clickable");
	}	

	/**********************************************************************************************************/	

	



}
