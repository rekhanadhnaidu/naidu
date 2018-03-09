package com.cname.applicationName.ObjectSpecific;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cname.core.framework.utils.Driver;

public class JDWilliams 
{
	public void enterText(String labelName, String val)
	{
		try
		{
			WebElement w1 = Driver.driver.findElement(By.xpath("//label[contains(text(),'"+labelName+"')]//following::input[1]"));
			w1.sendKeys(val);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void navigateToMenu(String menuName, String eTitle)
	{
		try
		{
			WebElement w1 = Driver.driver.findElement(By.xpath("(//a[contains(text(),'"+menuName+"')])[1]"));
			w1.click();
			String aTitle = Driver.driver.getTitle();
			Assert.assertTrue(aTitle.equals(eTitle), "Not in Expected Page");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void navigateToSubMenu(String menuName, String subMenuName, String eTitle)
	{
		try
		{
			WebElement w1 = Driver.driver.findElement(By.xpath("(//a[contains(text(),'"+menuName+"')])[1]"));
			Actions act = new Actions(Driver.driver);
			act.moveToElement(w1).perform();
			WebElement w2 = Driver.driver.findElement(By.xpath("(//a[contains(text(),'"+subMenuName+"')])[1]"));
			w2.click();
			String aTitle = Driver.driver.getTitle();
			Assert.assertTrue(aTitle.equals(eTitle), "Not in Expected Page");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
