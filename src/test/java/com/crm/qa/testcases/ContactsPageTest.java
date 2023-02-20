package com.crm.qa.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	Homepage homePage;
	TestUtil testUtil; //using to use utilities such as move to another iframe in webpage, thread sleep etc...
	ContactsPage contactsPage;
	NewContactPage newContactPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage(); 
		newContactPage = new NewContactPage();
		homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));	
		Thread.sleep(2000);
//		this driver.wait did not work so used thread.sleep
//		driver.wait(2000);;
		homePage.clickOnContactsLink();
		
//		had to add actions to move mouse a bit so that the 'main-nav' element can go back in left side panel 
//		and selenium can find the perticular webelement
		
		 new Actions(driver)
         .moveByOffset(13, 15)
         .perform();
//		
//		Thread.sleep(2000);
		
		contactsPage = new ContactsPage();
	}
	
	@Test(priority = 1)
	public void verifyContactsPhoneLinkTest() {
		Assert.assertTrue(contactsPage.verifycontactPhoneLink(),"Phone link/Button is missing from the page!!!!");
	}
	
	@Test(priority = 2)
	public void selectContactsTest() throws InterruptedException {
//		i tried to add these calls here to adjust newContactCreate process but it wont work. so putting back in setup method
//		homePage.clickOnContactsLink();
//		 new Actions(driver)
//         .moveByOffset(13, 15)
//         .perform();
		
		//Thread.sleep(2000);
		contactsPage.selectContactsByName("a a");
		//Thread.sleep(5000);
	}
	
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
