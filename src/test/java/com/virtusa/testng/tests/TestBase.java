package com.virtusa.testng.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.virtusa.testng.listeners.ListenerTest;
import com.virtusa.testng.pages.BasePage;


@Listeners(ListenerTest.class)
public class TestBase {

	WebDriver driver;
	Properties prop;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser)throws Throwable
	{
		System.out.println("We are in Test Base class");
		System.out.println();
		driver=BasePage.Initialization(browser);
		prop=BasePage.InitializeProperties();
		
				
	}
	
	
  @AfterMethod
  public void tearDown()
  {
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.quit();
  }
	
	
	
	
}
