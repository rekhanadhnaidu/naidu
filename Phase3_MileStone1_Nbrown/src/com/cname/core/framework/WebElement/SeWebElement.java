package com.cname.core.framework.WebElement;

import org.openqa.selenium.WebElement;

import com.cname.core.framework.WebDriver.SeWebDriver;

public class SeWebElement 
{
	SeWebDriver sDriver;
	public SeWebElement()
	{
		sDriver = new SeWebDriver();
	}
	
	public void setValue(String locator, String locatorValue, String value)
	{
		try
		{
			WebElement w1 = sDriver.findElement(locator, locatorValue);
			w1.sendKeys(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
