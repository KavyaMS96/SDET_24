package com.sdet24.CreateOrgModuleTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.sdet24.GenericUtility.ExcelUtility;
import com.sdet24.GenericUtility.FileUtility;


public class CreateOrgName_Industry_TypeTest {
	@Test
	public void createOrgTest2() throws Throwable {
		FileUtility fLib=new FileUtility();
		
		String BROWSER= fLib.getPropertyData("browser");
		String URL=fLib.getPropertyData("url");
		String Username=fLib.getPropertyData("username");
		String Password=fLib.getPropertyData("password");
		
		
		Random random=new Random();
		int randomnum=random.nextInt(1000);
		System.out.println(randomnum);
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		
		
		ExcelUtility ex=new ExcelUtility();
		String OrgName = ex.getExcelData("OrgName", 1, 1)+ "_" + randomnum;
		String IndName = ex.getExcelData("OrgName", 1, 2);
		String Type = ex.getExcelData("OrgName", 1, 3);
		
		
		
		driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
		
		WebElement indWeb=driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		Select sel=new Select(indWeb);
		sel.selectByVisibleText(IndName);
		
		WebElement typeWeb=driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
		Select sel2=new Select(typeWeb);
		sel2.selectByVisibleText(Type);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		String ActualText= driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		
		
		if(ActualText.contains(OrgName)) {
			System.out.println("Organization matched successfully");
			//ex.writeExcelData("OrgName", 1, 4, "PASS");
			
		}
		
		
		else {
			System.out.println("Organization not matched successfully");
			//ex.writeExcelData("OrgName", 1, 4, "FAIL");
			
			
		}
		Actions a=new Actions(driver);
		WebElement mouse= driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(mouse).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		System.out.println("=====Logout successfull=====");
		
		
		
		
		
	
	}
	
	

}
