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
	private By txt_annualincome=By.cssSelector("input[id='annual_revenue']");
	private By txt_employees=By.cssSelector("input[id='num_of_employees']");
	private By select_source=By.cssSelector("select[name='source']");
	private By txt_vattaxnumber=By.cssSelector("input[id='vat_number']");
	private By select_status=By.cssSelector("select[name='status']");
	private By select_category=By.cssSelector("select[name='category']");
	private By select_priority=By.cssSelector("select[name='priority']");
	private By txt_phonenumber=By.cssSelector("input[id='phone']");
	private By txt_faxnumber=By.cssSelector("input[id='fax']");
	private By txt_website=By.cssSelector("input[id='website']");
	private By txt_email=By.cssSelector("input[id='email']");
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
	
	public void setAnnualIncome(String income)
	{
		waitForElementTobeVisible(txt_annualincome);
		driver.findElement(txt_annualincome).sendKeys(income);
	}
	
	public void setEmployees(String employees)
	{
		waitForElementTobeVisible(txt_employees);
		driver.findElement(txt_employees).sendKeys(employees);
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
        System.out.println("category is selected from drop-down");		
	}
	
	public void setPriority(String priority)
	{
		waitForElementTobeVisible(select_priority);
		select=new Select(driver.findElement(select_priority));
		select.selectByVisibleText(priority);
		System.out.println("Select priority from drop-down");
	}
	
	public void setSource(String source)
	{
		waitForElementTobeVisible(select_source);
		select=new Select(driver.findElement(select_source));
		select.selectByVisibleText(source);
		System.out.println("Select source from drop-down");
	}
	
	public void setPhoneNumber(String phonenumber)
	{
		waitForElementTobeVisible(txt_phonenumber);
		driver.findElement(txt_phonenumber).sendKeys(phonenumber);
		System.out.println("Entered phone number successfully");
	}
	public void setFax(String fax)
	{
		waitForElementTobeVisible(txt_faxnumber);
		driver.findElement(txt_faxnumber).sendKeys(fax);
		System.out.println("Entered phone number successfully");
	}
	public void setWebsite(String website)
	{
		waitForElementTobeVisible(txt_website);
		driver.findElement(txt_website).sendKeys(website);
		System.out.println("Entered website details successfully");
	}
	public void setEmail(String email)
	{
		waitForElementTobeVisible(txt_email);
		driver.findElement(txt_email).sendKeys(email);
		System.out.println("Entered email in the respective box");
	}
	
	public void setVATTAXNumber(String vattaxnumber)
	{
		waitForElementTobeVisible(txt_vattaxnumber);
		driver.findElement(txt_vattaxnumber).sendKeys(vattaxnumber);
		System.out.println("VAT Number has been entered");
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
