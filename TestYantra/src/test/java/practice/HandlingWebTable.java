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

public class HandlingWebTable {
	
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
		
		
		driver.findElement(By.linkText("Organizations")).click();
		//------------------------------------------------------------------------------------------------------------
		
		//1.Select all the checkbox present in the table.
		
		/*List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
				for(int i=1; i<list.size();i++) {
					list.get(i).click();
				}
		
		//-------------------------------------------------------------------------------------------------------------
		
		//2.unselect the last checkbox.
		list.get(list.size()-1).click();
		
		*/
		//--------------------------------------------------------------------------------------------------------------
		
		//3.clicking on fifth checkbox
		//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/input")).click();
		
		//------------------------------------------------------------------------------------------------------------
		
		//4.printing all the Organization name present in the table
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		
		for(int i=1; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		
		//5.
	}

}
