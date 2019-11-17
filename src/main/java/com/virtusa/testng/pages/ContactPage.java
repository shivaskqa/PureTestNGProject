package com.virtusa.testng.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage{

	
	WebDriver driver;
	Select select;
	String parentWinHandle;
	
	private By newContactTab=By.cssSelector("a[title='New Contact']");
	private By title=By.cssSelector("select[name=title]");
	private By fname=By.cssSelector("input[id=first_name]");
	private By surname=By.cssSelector("input[id=surname]");

	private By select_suffix=By.cssSelector("select[name='suffix']");
	private By txt_nickname=By.cssSelector("input[name='nickname']");
	private By select_category=By.cssSelector("select[name='category']");
	private By select_status=By.cssSelector("select[name='status']");
	private By txt_mobilenumber=By.cssSelector("input[id='mobile']");
	
	private By company_lookup=By.xpath("//tr[8]//input[@type='button' and @value='Lookup']");
	private By company_txt=By.cssSelector("input[name=client_lookup]");
	
	private By receiveemail_YN=By.cssSelector("input[name='receive_email'][value='N']");
	private By receivesms_YN=By.cssSelector("input[name='receive_sms'][value='N']");
	private By allowcalls_YN=By.cssSelector("input[name='allows_call'][value='N']");
	private By source=By.xpath("//select[@name='source']");
	private By msngr=By.xpath("//select[@name='im_netowrk']");
	
	private By timezone=By.cssSelector("select#timezone");
	private By country=By.cssSelector("select[name='country']");
	
	private By btn_Save=By.cssSelector("form#contactForm input[type='submit']");
	
	private By header=By.cssSelector("td.tabs_header");
	
	public void clickNewContact()
	{
		waitForElementTobeVisible(newContactTab);
		driver.findElement(newContactTab).click();
		
	}
	
	public void setTitle(String txttitle)
	{
		waitForElementTobeVisible(title);
		select=new Select(driver.findElement(title));
		select.selectByVisibleText(txttitle);
	}
	
	public void setSuffix(String suffix)
	{
		waitForElementTobeVisible(select_suffix);
		select=new Select(driver.findElement(select_suffix));
		select.selectByVisibleText(suffix);
	}
	
	public void setMobileNumber(String mobilenumber)
	{
	
		waitForElementTobeVisible(txt_mobilenumber);
		driver.findElement(txt_mobilenumber).sendKeys(mobilenumber);
				
	}
	
	
	public void setFirstName(String firstname)
	{
		waitForElementTobeVisible(fname);
		driver.findElement(fname).sendKeys(firstname);
	}
	public void setSurName(String sname)
	{
	   waitForElementTobeVisible(surname);
	   driver.findElement(surname).sendKeys(sname);
	}
	
	
	public void setNickname(String name)
	{
		
		waitForElementTobeVisible(txt_nickname);
		driver.findElement(txt_nickname).sendKeys(name);
	}
	
	public void setCategory(String category)
	{
	
		waitForElementTobeVisible(select_category);
		select=new Select(driver.findElement(select_category));
		select.selectByVisibleText(category);
	}
	
	public void setStatus(String status)
	{	
		waitForElementTobeVisible(select_status);
		select=new Select(driver.findElement(select_status));
		select.selectByVisibleText(status);
    }
	
	public void setCompanyNameByLookUp(String companyname)
	{
		
		System.out.println("Inside the setCompanyNameByLookUp method");
		
		//Click on LookUp button to search and set company name
		//waitForElementtoload(company_lookup);
		
		String parentWinHandle=driver.getWindowHandle();
		
		System.out.println("Get Current Window Handle: "+parentWinHandle);
		
		driver.findElement(company_lookup).click();
		
		Set<String> winHandles=driver.getWindowHandles();
		
		System.out.println(winHandles);
		
		for(String handle:winHandles)
		{
			if(!handle.equalsIgnoreCase(parentWinHandle))
				{
				 switchToWindow(handle);
				 System.out.println("Current Title of the Window : "+driver.getTitle());
				 waitForElementTobeVisible(By.cssSelector("input[name='search']"));
				 driver.findElement(By.cssSelector("input[name='search']")).sendKeys(companyname);
				 driver.findElement(By.cssSelector("input[type='submit']")).click();
				 List<WebElement> list=driver.findElements(By.cssSelector("td.datafield a"));
				 
				 int listCount=list.size();
				 
				 System.out.println("Search List size in Company Search LookUp:"+ listCount);
				 
				 if(listCount >1)
				 {
					 for(WebElement e: list)
					 {
						  if(e.getText().equalsIgnoreCase(companyname))
						  {
							 Actions action=new Actions(driver);
							 action.moveToElement(e).contextClick().build().perform();
							 
						  }
					}
					 
				 }
				 else
					 { 
					   list.get(0).click();
					 }
				 				 
				}
		}
		
		switchToWindow(parentWinHandle);
		switchToFrame("mainpanel");
		System.out.println(driver.getTitle());
	}
	
	public void setCompanyName(String companyname)
	{
		waitForElementTobeVisible(company_txt);
		driver.findElement(company_txt).sendKeys(companyname);
	}
	
	public void setReceiveEmailFlag()
	{
		waitForElementTobeVisible(receiveemail_YN);
		driver.findElement(receiveemail_YN).click();
	}
	
	public void setReceiveSMSFlag()
	{
		waitForElementTobeVisible(receivesms_YN);
		driver.findElement(receivesms_YN).click();
	}
	
	public void setAllowCallsFlag()
	{
		waitForElementTobeVisible(allowcalls_YN);
		driver.findElement(allowcalls_YN).click();
	}
	
	public void setSource(String txtsource)
	{
		waitForElementTobeVisible(source);
		select=new Select(driver.findElement(source));
		select.selectByVisibleText(txtsource);
	}
	
	public void setMessenger(String msgr)
	{
		
		waitForElementTobeVisible(msngr);
		select=new Select(driver.findElement(msngr));
		select.selectByVisibleText(msgr);
	}
	
	public void setBirthDate(String date)
	{
	    WebElement dt=driver.findElement(By.cssSelector("input[id='fieldId_birthday']"));
	    ((JavascriptExecutor)driver).executeScript ("document.getElementById('fieldId_birthday').removeAttribute('readonly',0);"); 
	    dt.clear();
	    dt.sendKeys(date);
		
	}
	
	public void setTimeZone(String txttimeZone)
	{
	    waitForElementTobeVisible(timezone);
	    select=new Select(driver.findElement(timezone));
	    select.selectByVisibleText(txttimeZone);
	
	}
	
	public void setCountry(String countryname)
	{
		waitForElementTobeVisible(country);
		select=new Select(driver.findElement(country));
		select.selectByVisibleText(countryname);
	}
	
	public void clickSave()
	{
		
		waitForElementTobeVisible(btn_Save);
		driver.findElement(btn_Save).click();
	}
	
	public String verifyHeader()
	{
		waitForElementTobeVisible(header);
		String headertxt=driver.findElement(header).getText();
			
				return headertxt;
		
		
	}


	
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
}
