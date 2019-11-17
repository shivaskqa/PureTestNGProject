package com.virtusa.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.virtusa.testng.pages.CompanyPage;
import com.virtusa.testng.pages.ContactPage;


public class HomePage extends BasePage{

	WebDriver driver;
	private By companies_tab=By.xpath("//a[contains(text(),'Companies')]");
	private By contatcs_tab=By.xpath("//a[contains(text(),'Contacts')]");
	private By deals_tab=By.xpath("//a[@title='Deals']");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public ContactPage clickContactsTab()
	{
		
		switchToFrame("mainpanel");
		waitForElementTobeVisible(contatcs_tab);
		moveToElement(contatcs_tab);
				
		return new ContactPage(driver);
		
	}

	public CompanyPage clickCompaniesTab()
	{
	
		switchToFrame("mainpanel");
		waitForElementTobeVisible(companies_tab);
		moveToElement(companies_tab);
		
		return new CompanyPage(driver);
	}
	
	
	
	
}
