package com.sdet24.CreateContactTest;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sdet24.GenericUtility.ExcelUtility;
import com.sdet24.GenericUtility.FileUtility;

public class CreateContactTest {
	
	@Test
	public void createOrgTest() throws Throwable {
	
	
		FileUtility fLib=new FileUtility();
		
		String BROWSER= fLib.getPropertyData("browser");
		String URL=fLib.getPropertyData("url");
		String Username=fLib.getPropertyData("username");
		String Password=fLib.getPropertyData("password");
		
		
		Random random=new Random();
		int randomnum=random.nextInt(1000);
		System.out.println(randomnum);
		
		//String OrgName="SBM_Bank";
		
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
		String OrgName = ex.getExcelData("OrgName", 1, 1) + "_" + randomnum;
		String ContactName =ex.getExcelData("ContactName", 1, 1) + "_" + randomnum;
		
		
		driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
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
		
		//Wait Condition
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Contacts"))));
		
		//Navigate to contact Module
		driver.findElement(By.linkText("Contacts")).click();
		
		//Navigate to create Org Page
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(ContactName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//Switch to child window
		
		Set<String> set=driver.getWindowHandles();
		System.out.println("child window"+ set);
		Iterator<String> it= set.iterator();
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			if(driver.getTitle().contains("Accounts&action")) {
				
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		
		
		//Switch to Parent window
				Set<String> set1=driver.getWindowHandles();
				System.out.println(set1);
				Iterator<String> it1= set1.iterator();
				String windowID1=it1.next();
				driver.switchTo().window(windowID1);
				while(it.hasNext()) {
					if(driver.getTitle().contains(" Administrator - Contacts")) {
						break;
					}
					
				}
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();	
				
				
				Actions a=new Actions(driver);
				WebElement mouse= driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				a.moveToElement(mouse).perform();
				driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
				System.out.println("=====Logout successfull=====");
				
				driver.close();
				
				
	}

}
