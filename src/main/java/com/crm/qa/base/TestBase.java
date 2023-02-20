package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.time.Duration;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.apache.*;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
//import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\QA\\Selenium_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

public static void initialization() {
	
	// ------------ browsername we got from config file but we will use gecko driver so need to check which browser we are using
//	String browserName = prop.getProperty("browser");
	
//	if(browserName.equals("chrome")) {
//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
//		driver = new ChromeDriver();
//	}
//	else if(browserName.equals("fir")) {
//}
//	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
//	driver = new ChromeDriver();
//	
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");	
		driver = new ChromeDriver(); 
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");	
		driver = new FirefoxDriver(); 
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
//	in selenium 4, duration of seconds is used instead of TimeUnit.SECONDS
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_load_timeout));
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
	
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	

	}
}

