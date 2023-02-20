package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
// org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase  {
	
	@FindBy(xpath="//span[@class='user-display'][contains(text(),'Nikunj Patel')]")
	@CacheLookup
	WebElement unameDisplay;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]//parent::a//following-sibling::button")
	WebElement newContactLink;
		
//	initialization the page object
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUsername() {
		return unameDisplay.isDisplayed();
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		//Thread.sleep(5000);
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
//	public void clickOnNewContactLink() {
////		Actions actions = new Actions(driver);
////		actions.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//	}

	public NewContactPage clickOnNewContactLink() throws InterruptedException {
		//Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		//Thread.sleep(2000);
		newContactLink.click();
		return new NewContactPage();
	}
	
}
