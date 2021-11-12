package com.sdet24.GenericUtility;

import java.util.Random;
/**
 * 
 * @author Kavya
 *
 */
public class JavaUtility {
/**
 * generic method to read random number.
 * @return randomNumber
 */
	public static String getRandomData()
	{
		Random random= new Random();
		int r = random.nextInt(1000);
		return ""+r;
	}
}