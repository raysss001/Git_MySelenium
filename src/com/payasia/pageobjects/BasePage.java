package com.payasia.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	
	@FindBy(xpath="//span[contains(text(),'Switch Role')]")
	private WebElement swich;
	
	
	
	
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void swithUser()
	{
		swich.click();		
	}
	
	
	



}
