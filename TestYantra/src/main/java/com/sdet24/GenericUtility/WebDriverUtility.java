package com.sdet24.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class contains methods of webdriver utility
 * @author Kavya
 *
 */
public class WebDriverUtility {
	
	//Implicitly wait
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait till the element is visible
	 * @param driver
	 * @param element
	 */
	//Explicitly wait
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method is used for the element to be clicked
	 * @param element
	 * @throws InterruptedException
	 */
	//Custom wait
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<40)
		{
			try {
				element.click();
				break;
			}
			catch(Throwable t) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method enables user to handle dropdown using value
	 * @param element
	 * @param option
	 */
	public void SelectOption(WebElement element, String option)
	{
		Select s=new Select(element);
		s.selectByValue(option);
	}
	
	
	/**
	 * this method is used to perform mouseHover actions
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method performs right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext())
		{
			String winId=it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * Method to handle Alert pop-up and accept it
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to handle dismiss
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	} 
	/**
	 * method to handle scrolling action in webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		j.executeScript("window.scrollBy(0, "+y+")", element);
	}
	
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchFrame(WebDriver driver, String idOrName)
	{
		driver.switchTo().frame(idOrName);
		
	}
	
	
	public void pressEnterKey() throws AWTException 
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
}

