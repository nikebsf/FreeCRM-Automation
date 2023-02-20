package com.crm.qa.testcases;

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

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	Homepage homePage;
	TestUtil testUtil; //using to use utilities such as move to another iframe in webpage, thread sleep etc...
	ContactsPage contactsPage;
	NewContactPage newContactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));	
		contactsPage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle = homePage.verifyHomepageTitle();
//		the third argument is used to print that message if the assertion is failed. justlike if?yes:no method
		Assert.assertEquals(homePageTitle,"Cogmento CRM","HomePage Title not matched");
	}
	
	
//	Here if the user name displayed in website is in the <iframe> then, we need to use the below code
	
	@Test(priority = 2)
	public void verifyUnameTest() {
//		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
//		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
//		Thread.sleep(10000);
	}  
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
