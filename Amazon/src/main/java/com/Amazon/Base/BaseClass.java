/**
 * 
 */
package com.Amazon.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Amazon.utility.Log;
import com.Amazon.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author harik
 *
 */
public class BaseClass {
	
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver> dr =new ThreadLocal<>();
	
	public static WebDriver getdriver() {
		return dr.get(); 
	}
	
	
	@BeforeSuite(groups = {"Smoke", "Regression"})
	public static void loadconfig() {
		
		//for extent report
		ExtentManager.setExtent();
		
		
		DOMConfigurator.configure("log4j.xml");
		 Log.info("This is beforeSuite Method");
		
		prop = new Properties();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\harik\\eclipse-workspace\\Amazon\\Configuration\\Config.properties");
			prop.load(fis);
			} 
		catch (FileNotFoundException e) {
	 		
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void launch() throws InterruptedException {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr.set(new ChromeDriver());
			getdriver().manage().window().maximize();
			getdriver().manage().deleteAllCookies();
			getdriver().get(prop.getProperty("url"));
	
			Thread.sleep(3000);
			
		}
	}
	
	/*
	 * @Test public void test() throws InterruptedException { launch();
	 * System.out.println("testing...Amazon"); }
	 */
	
	@AfterSuite(groups = {"Smoke", "Regression"})
	public void afterSuite() {
		  Log.info("This is afterSuite Method");
		  
		//End extent report
		  ExtentManager.endReport();
	}
	
	
	

}
