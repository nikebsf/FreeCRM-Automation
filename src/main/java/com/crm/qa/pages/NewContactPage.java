package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='search']//parent::div[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']/i")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']")
	WebElement flagBtn;
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFirstNameBtn() {
		return flagBtn.isDisplayed();
	}
	
public void createNewContact(String fname, String lname) throws InterruptedException {
	
	
		
//		use Select class with select object to choose name prefix while creating new contact 
//		and pass (String title) for this prefix. etc, Mr., Mrs.
		
		firstName.sendKeys(fname);
		//Thread.sleep(1500);
		lastName.sendKeys(lname);
		//Thread.sleep(1500);
//		company.sendKeys(comp);
//		Thread.sleep(5000);
		saveBtn.click();
		
	}

}
