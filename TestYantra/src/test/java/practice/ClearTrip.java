package practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClearTrip {
	@Test
	public void cleartrip() throws Throwable {
		
		Date dateObj=new Date();
		String date= dateObj.toString();
		System.out.println(date);
		
		String[] today= date.split(" ") ;
		String day=today[0];
		String month=today[1];
		String actDate=today[2];
		String year=today[5];
		
		String travelDate= day+" "+month+" "+actDate+" "+year;
		System.out.println(travelDate);
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Login to Application
		driver.get("https://www.cleartrip.com/");
		
		//Navigate to source
		WebElement src = driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]"));
		src.sendKeys("BLR");
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore')]")).click();
		
		//Navigate to Destination
		WebElement dest = driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]"));
		dest.sendKeys("BOM");
		driver.findElement(By.xpath("//p[contains(text(),'Mumbai')]")).click();
		
		Thread.sleep(2000);
		
		//clicking on calender.
		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Thu Nov 11 2021']")).click();
		
		driver.findElement(By.xpath("//button[text()='Search flights']")).click();
		
		
		
	}

}
