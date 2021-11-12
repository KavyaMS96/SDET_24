package com.sdet24.GenericUtility;



import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sdet24.PomRepoUtility.HomePage;
import com.sdet24.PomRepoUtility.LoginPage;

public class BaseClassAnnotation {

	public WebDriver driver;
	public static WebDriver staticDriver;
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	@BeforeSuite(groups={"smokeTest", "regressionTest"})
	public void connectDB() {
		System.out.println("=====DB Connection Successfully=====");
		
	}
	//@Parameters(value ="BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable {
		String BROWSER= fLib.getPropertyData("browser");
		String URL=fLib.getPropertyData("url");
		//step1: Launch Browser
				if(BROWSER.equals("chrome")) {
					driver = new ChromeDriver();
				}
				else if(BROWSER.equals("firefox")) {
					driver = new FirefoxDriver();
				}
				else if(BROWSER.equals("ie")) {
					driver = new InternetExplorerDriver();
				}
				
				wLib.waitUntilPageLoad(driver);
				driver.get(URL);
				
				System.out.println("=====Launch Browser=====");
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void loginToApp() throws Throwable {
		String Username=fLib.getPropertyData("username");
		String Password=fLib.getPropertyData("password");
		LoginPage lp=new LoginPage(driver);
		
		lp.getUsernameTxtBox().sendKeys(Username);
		lp.getPwdTxtbox().sendKeys(Password);	
		lp.getLgnbtn().click();
		
		System.out.println("====Login to Application=====");
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void logoutOffApp() {
		HomePage hp= new HomePage(driver);
		wLib.mouseHover(driver, hp.getProfImg());
		hp.getSignOutLink().click();
		System.out.println("=====Logout successfully=====");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void CloseBrowser() {
		driver.close();
		System.out.println("=====Close Browser successfully=====");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void CloseDB() throws SQLException {
		System.out.println("=====DB Connection close successfully=====");
		
	}
}
