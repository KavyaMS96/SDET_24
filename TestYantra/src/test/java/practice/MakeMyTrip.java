package practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {
	@Test
	public void makemytrip() throws Throwable {
		
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
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(5000);
		
		JavascriptExecutor javaex=  (JavascriptExecutor) driver;
		javaex.executeScript("window.scrollBy(0, 120)");
		
		//driver.findElement(By.xpath("//li[@class='menu_Flights']")).click();
		
		//Navigate to Source
		WebElement src = driver.findElement(By.xpath("//label[@for='fromCity']"));
		src.sendKeys("BOM");
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
		
		//Navigate to Destination
		WebElement dest = driver.findElement(By.xpath("//label[@for='toCity']"));
		dest.sendKeys("MAA");
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
				
		//Navigate to Departure
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@aria-label='Wed Nov 10 2021']")).click();

//---------------------------------------------------------------------------------------		
		//dynamic xpath for current date
		//driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
//---------------------------------------------------------------------------------------		
		
		//xpath for jan 20 2022
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Thu Jan 20 2022']")).click();
		
		
		//Search button.
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		//
		
		
		
	
		
		
	}

}
