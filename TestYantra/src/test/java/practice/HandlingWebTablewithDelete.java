package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.sdet24.GenericUtility.FileUtility;

public class HandlingWebTablewithDelete {
	
	@Test
	public void handlingWebTable() throws Throwable {
		

		FileUtility fLib=new FileUtility();
		
		String BROWSER= fLib.getPropertyData("browser");
		String URL=fLib.getPropertyData("url");
		String Username=fLib.getPropertyData("username");
		String Password=fLib.getPropertyData("password");
		
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
		
		String orgname="HDBC_Bank";
		
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//driver.findElement(By.xpath("//table/tbody/tr[1]/td/div/table/tbody/tr[*]/td[3]/a[contains(text(),'"+orgname+"')]/../..//td[*]/a[text()='del']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i=1; i<list.size(); i++)
		{
			String actOrgname = list.get(i).getText();
			if(actOrgname.contains(orgname)) {
				driver.findElement(By.xpath("//a[contains(text(), '"+orgname+"')]/parent::td/following-sibling::td[*]/a[text()='del']")).click();
				System.out.println(orgname +"is deleted");
				break;
			}
		}
		
		//Handling Alert PopUp
		driver.switchTo().alert().accept();

	}
}
