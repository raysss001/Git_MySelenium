package com.payasia.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValue {
	static final String filePath=".\\config.properties";
	
	public static String getValue(String Key)
	{
		String value=null;
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(new File(filePath)));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		value=prop.getProperty(Key);
		return value;
		
	}
	

}
