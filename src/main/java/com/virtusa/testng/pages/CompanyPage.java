package com.virtusa.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompanyPage extends BasePage{

	
	WebDriver driver;
	Select select;
	
	private By link_newCompany=By.xpath("//a[@title='New Company']");
	private By txt_companyname=By.cssSelector("input[id='company_name']");
	private By txt_industry=By.cssSelector("input[name='industry']");
	private By select_status=By.cssSelector("select[name='status']");
	private By select_category=By.cssSelector("select[name='category']");
	private By select_priority=By.cssSelector("select[name='priority']");
	private By btn_save=By.cssSelector("form input[value='Save']");
	private By header_text=By.xpath("//td[@class='tabs_header']");
	
	
	public CompanyPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickNewCompanyTab()
	{
		waitForElementTobeVisible(link_newCompany);
		driver.findElement(link_newCompany).click();
	    	
	}
 
		
	public void setCompanyName(String companyName)
	{
	
		waitForElementTobeVisible(txt_companyname);
		driver.findElement(txt_companyname).sendKeys(companyName);
	}
	
	public void setIndustry(String industry)
	{
		waitForElementTobeVisible(txt_industry);
		driver.findElement(txt_industry).sendKeys(industry);
	}
	
	public void setStatus(String status)
	{
		waitForElementTobeVisible(select_status);
		select=new Select(driver.findElement(select_status));
		select.selectByVisibleText(status);
	}
	
	public void setCategory(String category)
	{
		waitForElementTobeVisible(select_category);
		select=new Select(driver.findElement(select_category));
		select.selectByVisibleText(category);
		
	}
	
	public void setPriority(String priority)
	{
		waitForElementTobeVisible(select_priority);
		select=new Select(driver.findElement(select_priority));
		select.selectByVisibleText(priority);
	}
	
	public void clickSave()
	{
		waitForElementTobeVisible(btn_save);
		driver.findElement(btn_save).click();
	}
	
	public String verifyHeaderText()
	{
		waitForElementTobeVisible(header_text);
		String text=driver.findElement(header_text).getText();
		System.out.println(text);
		return text;
	}

	
	
	
}
