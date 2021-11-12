package com.sdet24.PomRepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author kavya
 *
 */
public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(name="user_name")
		private WebElement usernameTxtBox;
		
		@FindBy(name="user_password")
		private WebElement pwdTxtbox;
		
		@FindBy(id="submitButton")
		private WebElement lgnbtn;
		
		public WebElement getUsernameTxtBox() {
			return usernameTxtBox;
		}

		public WebElement getPwdTxtbox() {
			return pwdTxtbox;
		}

		public WebElement getLgnbtn() {
			return lgnbtn;
		}
	

		public void loginToapp(String username, String password) {
			usernameTxtBox.sendKeys(username);
			pwdTxtbox.sendKeys(password);
			lgnbtn.click();
			
		}

}
