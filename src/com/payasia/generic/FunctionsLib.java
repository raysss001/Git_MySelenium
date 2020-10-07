package com.payasia.generic;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class FunctionsLib extends BaseLib{

	public void click(WebElement ele, String name)  {
		try {
			ele.click();
		}catch(Exception e) {
			System.out.println("ELEMENT NOT FOUND : "+ name);
		}
	}
	
	
	public void input(WebElement ele, String val, String name) {
		try {
			ele.sendKeys(val);			
		}catch(Exception e) {
			System.out.println("ELEMENT NOT FOUND : "+ name);
		}		
	}
	
	
	public void verifyTextOnElement(String exp, String act) {
		if(exp.equalsIgnoreCase(act)) {
			System.out.println("String are equal.");
		}
		else{
			System.out.println("Strings are not Equal.");
			
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
	
}
