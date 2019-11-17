package com.virtusa.testng.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	static WebDriver driver;
	static Properties prop;
	static WebDriverWait wait;
	
	
	public static WebDriver Initialization(String browsername) throws InterruptedException
	{
		Properties p=InitializeProperties();
			
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
			{ 
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			}
		
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Long.parseLong(p.getProperty("implicitlyWait")),TimeUnit.SECONDS);
		  driver.get(prop.getProperty("url"));
		  
		  
		return driver;
		
	}
	
	
	
	  public static Properties InitializeProperties()
	  {
		  
		  try
		  {
			
		  prop=new Properties();
		  FileInputStream fis=new FileInputStream("C:\\Users\\skandha\\eclipse-workspace\\Puretestng\\src\\main\\java\\com\\virtusa\\testng\\config\\config.properties");
		  prop.load(fis);
		  
		  	  
		  }
		  catch(FileNotFoundException fe)
		  {
			  fe.printStackTrace();
		  }
		   catch(IOException ie)
		  {
			   ie.printStackTrace();
		  }
		 
		  return prop;
		  
	}
	
	public void waitForElementTobeVisible(By locator)
	{
		wait=new WebDriverWait(driver,Long.parseLong(prop.getProperty("webdriverWait")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	  
	public boolean isElementDisplayed(By locator)
	{
		
		return driver.findElement(locator).isDisplayed();
		 
	}
	  
	public boolean isElementEnabled(By locator)
	{
		return driver.findElement(locator).isEnabled();
	}
	  
	public boolean isSelected(By locator)
	{
      return driver.findElement(locator).isSelected();
	}
	  
	public void switchToFrame(String frameName)
	{
		wait=new WebDriverWait(driver,Long.parseLong(prop.getProperty("webdriverWait")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		//driver.switchTo().frame(frameName);
	}

	public void switchToWindow(String winName)
	{
		
	   driver.switchTo().window(winName);
		
	}
	
	public void moveToElement(By locator)
	{
		
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(locator)).build().perform();
				
	}
	 
	public JavascriptExecutor wrapDriverToJS()
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	
	public void elementClick(By locator)
	{
		waitForElementTobeVisible(locator);
		driver.findElement(locator).click();
	}
	
		
	
}
