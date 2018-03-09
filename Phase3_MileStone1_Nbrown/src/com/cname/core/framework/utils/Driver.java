package com.cname.core.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver 
{
	public static WebDriver driver;
	public static WebDriver getDriver()
	{
		String bName = Global.browserName;
		if(bName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Global.chromeDriverPath);
			driver = new ChromeDriver();	
		}
		
		if(bName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", Global.fireFoxDriverPath);
			driver = new FirefoxDriver();	
		}
		
		if(bName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", Global.ieDriverPath);
			driver = new InternetExplorerDriver();	
		}
		return driver;
	}
}
