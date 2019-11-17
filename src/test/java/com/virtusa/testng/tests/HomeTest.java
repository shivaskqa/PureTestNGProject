package com.virtusa.testng.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.virtusa.testng.listeners.ListenerTest;
import com.virtusa.testng.pages.HomePage;
import com.virtusa.testng.pages.LoginPage;


@Listeners(ListenerTest.class)

public class HomeTest extends TestBase{

	WebDriverWait wait;
	
	
	@Test(priority=1)
	public void clickCompanyTab()
	{
		
		 LoginPage lpage= new LoginPage(driver);
		 lpage.setUsername(prop.getProperty("username"));
		 lpage.setPassword(prop.getProperty("password"));
		 lpage.clickSubmit();
		 wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.titleContains("CRMPRO"));
		 System.out.println(lpage.getTitle());
		 
		 HomePage hpage=new HomePage(driver);
		 
		 hpage.clickCompaniesTab();
			
		
	}
	
	@Test(priority=2)
	public void clickContactTab()throws Throwable{
		
		LoginPage lpage= new LoginPage(driver);
		 lpage.setUsername(prop.getProperty("username"));
		 lpage.setPassword(prop.getProperty("password"));
		 lpage.clickSubmit();
		 wait=new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.titleContains("CRMPRO"));
		 
		 System.out.println(lpage.getTitle());
		 
		 HomePage hpage=new HomePage(driver);
		 
		 hpage.clickContactsTab();
			
   	
	}
	
	
}
