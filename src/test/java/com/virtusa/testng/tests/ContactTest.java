package com.virtusa.testng.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.virtusa.testng.listeners.ListenerTest;
import com.virtusa.testng.pages.ContactPage;
import com.virtusa.testng.pages.HomePage;
import com.virtusa.testng.pages.LoginPage;
import com.virtusa.testng.utils.ReadDataFromExcel;

@Listeners(ListenerTest.class)
public class ContactTest extends TestBase{

	ContactPage cpage;
	WebDriverWait wait;
	
       	
       	
	@Test(dataProvider="readData")
	public void feedContactForm(String title,String fname,String lname,String suffix,String nickname,String company,String position,String category,String status,String mobile,String messenger,String birthdate)
	{
		
		  LoginPage lpage= new LoginPage(driver);
	  		 lpage.setUsername(prop.getProperty("username"));
	  		 lpage.setPassword(prop.getProperty("password"));
	  		 lpage.clickSubmit();
	  		 wait=new WebDriverWait(driver, 20);
	  		 wait.until(ExpectedConditions.titleContains("CRMPRO"));
	  		 System.out.println(lpage.getTitle());
	  		   
	    	   
			 HomePage hpage=new HomePage(driver);
			 
			 hpage.clickContactsTab();
					
		
		cpage=new ContactPage(driver);
		
		cpage.clickNewContact();
		cpage.setTitle(title);
		cpage.setFirstName(fname);
		cpage.setSurName(lname);
		cpage.setSuffix(suffix);
		cpage.setNickname(nickname);
		cpage.setCompanyName(company);
		cpage.setCategory(category);
		cpage.setStatus(status);
		cpage.setMobileNumber(mobile);
		cpage.setBirthDate(birthdate);
		cpage.setAllowCallsFlag();
		cpage.setReceiveEmailFlag();
		cpage.setReceiveSMSFlag();
				
		cpage.clickSave();
		
	}
	
	
	@DataProvider
	public Object[][] readData()throws Throwable
	{
		ReadDataFromExcel r=new ReadDataFromExcel();
		return r.dataFromExcel("C:\\Users\\skandha\\eclipse-workspace\\Puretestng\\resources\\CRMPROTestData.xlsx", "ContactFormData");
		 
	}
	
	
	
}
