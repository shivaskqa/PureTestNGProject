package com.virtusa.testng.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.virtusa.testng.listeners.ListenerTest;
import com.virtusa.testng.pages.CompanyPage;
import com.virtusa.testng.pages.HomePage;
import com.virtusa.testng.pages.LoginPage;
import com.virtusa.testng.utils.ReadDataFromExcel;

@Listeners(ListenerTest.class)
public class CompanyTest extends TestBase{

	CompanyPage
	cpage;
	WebDriverWait wait;
	
		
	@Test(dataProvider="readDataFromExcel")
	public void saveCompanyFormWithExcelData(String company,String industry,String annualincome,String employees,String status,String category,String priority,String source,String taxvatnumber,String phone,String fax,String website,String email)
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
		
		
		
		
		
		cpage=new CompanyPage(driver);
		
		cpage.clickNewCompanyTab();
		cpage.setCompanyName(company);
		cpage.setIndustry(industry);
		cpage.setAnnualIncome(annualincome);
		cpage.setEmployees(employees);
		cpage.setStatus(status);
		cpage.setCategory(category);
		cpage.setPriority(priority);
		cpage.setSource(source);
		cpage.setVATTAXNumber(taxvatnumber);
		cpage.setPhoneNumber(phone);
		cpage.setFax(fax);
		cpage.setEmail(email);
		
		
		cpage.clickSave();
		
	}
	@DataProvider
	public Object[][] readDataFromExcel()throws Throwable
	{
		
		ReadDataFromExcel r=new ReadDataFromExcel();
		return r.dataFromExcel("C:\\Users\\skandha\\eclipse-workspace\\Puretestng\\resources\\CRMPROTestData.xlsx", "CompanyFormData");
		
	}
	
		
}
