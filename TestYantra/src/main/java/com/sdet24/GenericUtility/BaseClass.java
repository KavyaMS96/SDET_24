package com.sdet24.GenericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	@BeforeSuite
	public void bsConfig() {
		
		System.out.println("");
		
	}
	
	@BeforeSuite(groups={"smokeTest", "regressionTest"})
	public void connectDB() {
		System.out.println("=====DB Connection Successfully=====");
		
	}
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable {
		
				
				System.out.println("=====Launch Browser=====");
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void loginToApp() throws Throwable {
		
		
		System.out.println("====Login to Application=====");
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void logoutOffApp() {
		
		System.out.println("=====Logout successfully=====");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void CloseBrowser() {
		
		System.out.println("=====Close Browser successfully=====");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void CloseDB()  {
		System.out.println("=====DB Connection close successfully=====");
	}
	

}
