package com.crm.qa.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
public class LoginPageTest extends TestBase {
	
	private static final Logger log = LogManager.getLogger(LoginPageTest.class);  
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
	LoginPage loginPage;
	Homepage homePage;
	
//	super is used to call super class constructor
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.info("*************************************** loginPageTitleTest ***************************************");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
		log.warn("warning message!!!!!!!");
		log.debug("debug message");
		log.fatal("fatal msg");
		
	}
	
	@Test(priority=2)
	public void CRMLogoTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
