package com.payasia.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	//WebDriver driver;
	public static void iSleep(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*******************/
	
	
	
	public static void ImplicitWaitForSeconds(WebDriver driver, int sec)
	{
		
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
		
		
	}
	

	/********/
	
	
	public static void ImplicitWaitForMinutes(WebDriver driver, int mins)
	{
		
		driver.manage().timeouts().implicitlyWait(mins,TimeUnit.MINUTES);
		
		
	}
	
	
	/*********/
	
	
	
	
	public static void explicitWaitVisibility(WebDriver driver, int sec, WebElement ele,String name)
	{
		
		WebDriverWait wait= new WebDriverWait(driver,sec);
		try {
		wait.until(ExpectedConditions.visibilityOf(ele));
		}catch(Exception e) {
			System.out.println("ELEMENT NOT VISIBLE : "+ name);
		}
	}
	
	
	
	/****************/
	
	
	public static void explicitWaitForClickable(WebDriver driver, int sec, WebElement ele, String name)
	{
		
		WebDriverWait wait= new WebDriverWait(driver,sec);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		}catch(Exception e) {
			System.out.println("ELEMENT NOT VISIBLE : "+ name);
		}
	}
	
	
	public static void waitForAlert(WebDriver driver)
	{
		
		int i=0;
		   while(i++<5)
		   {
		        try
		        {
		            Alert alert = driver.switchTo().alert();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		        	try {
		    			Thread.sleep(1000);
		    		} catch (InterruptedException c) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}
		          continue;
		        }
		   }
		
	}

	
}
