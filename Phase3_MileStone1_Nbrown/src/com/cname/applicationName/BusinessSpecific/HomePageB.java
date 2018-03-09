package com.cname.applicationName.BusinessSpecific;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cname.applicationName.PageObject.HomePageObj;
import com.cname.core.framework.WebDriver.SeWebDriver;
import com.cname.core.framework.WebElement.SeWebElement;
import com.cname.core.framework.utils.Driver;

public class HomePageB 
{
	public WebDriver driver;
	public SeWebElement sElement;
	public HomePageB()
	{

	}
	
	public void searchProduct(String productName)
	{
		try
		{
			WebElement w1 = Driver.driver.findElement(By.xpath(HomePageObj.searchTextBox));
			w1.sendKeys(productName);
			
			WebElement w2 = Driver.driver.findElement(By.xpath(HomePageObj.searchBtn));
			w2.click();
		}
		catch(Exception e)
		{
			
		}
	}
	
	
}
