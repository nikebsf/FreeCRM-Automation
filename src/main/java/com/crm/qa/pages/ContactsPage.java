package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase  {
	
	
	@FindBy(xpath="//th[contains(text(),'Phone')]")
	WebElement contactPhoneLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@class='search']//parent::div[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//button[@class='ui linkedin button']/i")
	WebElement saveBtn;
	
//	this is not genuine method to select checkbox of contacts/names
//	@FindBy(xpath="//body[@data-new-gr-c-s-check-loaded='8.904.0']/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/div[@class='table-wrapper']/table[@class='ui celled definition sortable striped table custom-grid']/tbody/tr[1]/td[1]")
//	WebElement a;
	
//	initialization the page object
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifycontactPhoneLink() {
		return contactPhoneLink.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
//		driver.findElement(By.xpath("//a[text(),'"+name+"']//parent::td[@class='checkbox']"
//				+ "//preceding-sibling::td[@class='checkbox'//input[@name='id']]")).click();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
		
//		driver.findElement(By.xpath("//div[@class='ui checked fitted read-only checkbox']//label")).click();		
	}
	
//	public void createNewContact(String fname, String lname, String comp) throws InterruptedException {
//		
////		use Select class with select object to choose name prefix while creating new contact 
////		and pass (String title) for this prefix. etc, Mr., Mrs.
//		
//		firstName.sendKeys(fname);
//		Thread.sleep(1500);
//		lastName.sendKeys(lname);
//		Thread.sleep(1500);
//		company.sendKeys(comp);
//		Thread.sleep(5000);
//		saveBtn.click();
//		
//	}
	
}
