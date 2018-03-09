package com.cname.core.framework.utils;

import org.openqa.selenium.By;

public class FindBy 
{
	public static By seByMechanism(String findByMechanism, String locator)
	{
		By by = null;
		try
		{
			switch (findByMechanism.toLowerCase())
			{
				case "id":
					by = By.id(locator);
					break;
					
				case "classname":
					by = By.className(locator);
					break;
					
				case "xpath":
					by = By.xpath(locator);
					break;
					
				case "cssselector":
					by = By.cssSelector(locator);
					break;
					
				case "linktext":
					by = By.linkText(locator);
					break;
					
				case "partiallinktext":
					by = By.partialLinkText(locator);
					break;
				
				case "tagname":
					by = By.tagName(locator);
					break;
			}
		}
		catch(Exception e)
		{
			new Exception("Invalid Locator : "+findByMechanism);
		}
		return by;
	}
}
