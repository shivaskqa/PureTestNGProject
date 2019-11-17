package com.virtusa.testng.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.virtusa.testng.pages.BasePage;

public class ListenerTest implements ITestListener{

	WebDriver driver;
	
	
	public void onTestStart(ITestResult result) {
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("The Name of the test case Pass : "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("The Name of the test case failed :"+ result.getName());
		String method=result.getName().toString().trim();
		try {
			driver=BasePage.Initialization("chrome");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		takeScreenshot(driver, method);
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	public void takeScreenshot(WebDriver driver,String methodname)
	{
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("C:\\Users\\skandha\\eclipse-workspace\\Puretestng\\target\\screenshots"+methodname+".png");
		try
		{
		FileUtils.copyFile(srcfile, destFile);
		}
		catch(IOException ie) { ie.printStackTrace();
		}
		
 	}

}
