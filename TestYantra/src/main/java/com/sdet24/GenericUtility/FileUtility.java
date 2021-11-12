package com.sdet24.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Kavya
 *
 */



public class FileUtility {
	
	/**
	 * 
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	
	public String getPropertyData(String key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./data/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value= pObj.getProperty(key);
		return value;
		
	}

}
