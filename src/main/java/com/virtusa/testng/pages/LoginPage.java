package com.virtusa.testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.virtusa.testng.pages.HomePage;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	// LoginPage Object Repository
	
	private By txt_username=By.cssSelector("input[name='username']");
	private By txt_password=By.cssSelector("input[name='password']");
	private By btn_submit=By.cssSelector("input[type='submit']");
	private By link_signUp=By.xpath("//a[contains(text(),'Sign')]");
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
public void setUsername(String username) {
		
		waitForElementTobeVisible(txt_username);
	     	driver.findElement(txt_username).sendKeys(username);
		
	}
	
	public void setPassword(String password)
	{
		waitForElementTobeVisible(txt_password);
		 driver.findElement(txt_password).sendKeys(password);
		
		
	}
	
	public HomePage clickSubmit()
	{
		waitForElementTobeVisible(btn_submit);
		if(isElementDisplayed(btn_submit)) 
			elementClick(btn_submit);
			
		return new HomePage(driver);
	}
	
	public String getTitle()
	{
	    String title=driver.getTitle();
		
		return title;
	}
	
    public boolean isSignUpDisplayed()
    {
    	return isElementDisplayed(link_signUp);
    }
	
}
