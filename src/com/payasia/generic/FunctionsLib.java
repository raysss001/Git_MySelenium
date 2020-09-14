package com.payasia.generic;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class FunctionsLib {

	public static void click(WebElement ele, String name)  {
		try {
			ele.click();
		}catch(Exception e) {
			System.out.println("ELEMENT NOT FOUND : "+ name);
		}
	}
	
	
	public static void input(WebElement ele, String val, String name) {
		try {
			ele.sendKeys(val);			
		}catch(Exception e) {
			System.out.println("ELEMENT NOT FOUND : "+ name);
		}		
	}
	
	
	public static void verifyTextOnElement(String exp, String act) {
		if(exp.equalsIgnoreCase(act)) {
			System.out.println("String are equal.");
		}
		else{
			System.out.println("Strings are not Equal.");
		}
		
	}
	
}
