package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.sdet24.GenericUtility.ExcelUtility;
import com.sdet24.GenericUtility.FileUtility;


public class Sample_TestNG_Test {
	@Test
	public void createOrgTest(XmlTest xml) throws Throwable {
	
	
		FileUtility fLib=new FileUtility();
		
		String BROWSER= xml.getParameter("browser");
		String URL=xml.getParameter("url");
		String Username=xml.getParameter("username");
		String Password=xml.getParameter("password");
		
		
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
		
		
		driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		String ActualText= driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		
		
		if(ActualText.contains(OrgName)) {
			System.out.println("Organization matched successfully");
			ex.writeExcelData("OrgName", 1, 4, "PASS");
			
		}
		
		
		else {
			System.out.println("Organization not matched successfully");
			ex.writeExcelData("OrgName", 1, 4, "FAIL");
			
			
		}
		Actions a=new Actions(driver);
		WebElement mouse= driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(mouse).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		System.out.println("=====Logout successfull=====");
		
		driver.close();
		
		
		
		
		
	
	}
	
	

}
