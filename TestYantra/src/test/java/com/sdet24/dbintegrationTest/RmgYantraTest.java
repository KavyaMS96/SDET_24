package com.sdet24.dbintegrationTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraTest {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, SQLException {
		Scanner sc= new Scanner(System.in);
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8084");
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("rmgyantra");
	    driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()=\"Create Project\"]")).click();
		
		System.out.println("enter the project name");
		String projectname=sc.next();
		driver.findElement(By.xpath("//input[@name=\"projectName\"]")).sendKeys(projectname);
		
		System.out.println("enter the manager name");
		String managername=sc.next();
		driver.findElement(By.xpath("//input[@name=\"createdBy\"]")).sendKeys(managername);
		
		WebElement status=driver.findElement(By.xpath("(//select[@name=\"status\"])[2]"));
		Select s=new Select(status);
		List<WebElement> allOpt=s.getOptions();
		for(WebElement opt:allOpt) {
		s.selectByVisibleText("Created");
		}
		driver.findElement(By.xpath("//input[@class=\"btn btn-success\"]")).click();
		//driver.close();
		
				Driver driverref= new Driver();
				DriverManager.registerDriver(driverref);

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/projects", "root", "root");

				Statement stat= con.createStatement();
				
				ResultSet set=stat.executeQuery("select * from project");
				
				System.out.println("enter the project name to verify");
				String Db_projectname=sc.next();
				
				int count=0;
				while(set.next()) {
					//System.out.println(set.getString(1) + "\t" + set.getString(2) + "\t" + set.getString(3) + "\t" + set.getString(4)+ "\t"+ set.getString(5) + "\t" + set.getInt(6));
				
				if(set.getString("project_name").equals(Db_projectname)) {
					
					count++;
					
				}
				}
				
				if(count==1) {
					System.out.println("Project is Created");
				}
				else {
					System.out.println("Project is not Created");
				}
				
			
				con.close();

		

}
}
