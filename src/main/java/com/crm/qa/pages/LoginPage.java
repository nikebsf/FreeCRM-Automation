package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
//	PageFactory - OR;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignupBtn;
	
	@FindBy(xpath="//div[@class='rd-navbar-panel']")
	WebElement logo;
	
//Initializing the login page
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//	Actions on login page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return logo.isDisplayed();
	}
	
//	we created login method to go to landing page - Homepage, so void changed to Homepage; method name got homepage login
	
	public Homepage login(String unmail, String pwd) {
		email.sendKeys(unmail);
		password.sendKeys(pwd);
		loginBtn.click();
		
		//Thread.sleep(3000);
		
		return new Homepage();
		}
	

}
