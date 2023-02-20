package com.crm.qa.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactTest extends TestBase {
	
	LoginPage loginPage;
	Homepage homePage;
	TestUtil testUtil; //using to use utilities such as move to another iframe in webpage, thread sleep etc...
	ContactsPage contactsPage;
	NewContactPage newContactPage;
	
	String sheetName = "contacts";
	
	public NewContactTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage(); 
		
		homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));	
		Thread.sleep(2000);
//		this driver.wait did not work so used thread.sleep
//		driver.wait(2000);
		
		
//		Actions actions = new Actions(driver);
//		actions.moveToElement(contactsLink);
		homePage.clickOnNewContactLink();
		
//		had to add actions to move mouse a bit so that the 'main-nav' element can go back in left side panel 
//		and selenium can find the perticular webelement
		
		 new Actions(driver)
         .moveByOffset(13, 15)
         .perform();
		
		Thread.sleep(2000);
		
		contactsPage = new ContactsPage();
		newContactPage = new NewContactPage();
		
//		while(newContactPage.verifyFirstNameBtn() == false) {
//			driver.navigate().refresh();
//		}
		do {
			driver.navigate().refresh();
		}while (newContactPage.verifyFirstNameBtn() == false);
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) throws InterruptedException {
//		//homePage.clickOnNewContactLink();
//		
//		Thread.sleep(2000);
//		
//		new Actions(driver)
//        .moveByOffset(13, 15)
//        .perform();
		
		//Thread.sleep(2000);
//		driver.navigate().refresh();
		newContactPage.createNewContact(firstname, lastname);
		//Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
