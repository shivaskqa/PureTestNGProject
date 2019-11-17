package com.virtusa.testng.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.virtusa.testng.listeners.ListenerTest;
import com.virtusa.testng.pages.LoginPage;


@Listeners(ListenerTest.class)

public class LoginTest extends TestBase{
	
	
	
	@Test(priority=1)
	public void enterCredentials()
	{
		
	 LoginPage lpage= new LoginPage(driver);
	 lpage.setUsername(prop.getProperty("username"));
	 lpage.setPassword(prop.getProperty("password"));
	 lpage.clickSubmit();
	 System.out.println(lpage.getTitle());
	
	 
	}
	
	@Test(priority=2)
	public void enterwrongCredentials()
	{
	
	 LoginPage lpage= new LoginPage(driver);	
	 lpage=new LoginPage(driver);
	 lpage.setUsername("shivask");
	 lpage.setPassword("test123");
	 lpage.clickSubmit();
	 System.out.println(lpage.getTitle());
	 System.out.println(lpage.isSignUpDisplayed());
	 
		 
	}
	
	

}
