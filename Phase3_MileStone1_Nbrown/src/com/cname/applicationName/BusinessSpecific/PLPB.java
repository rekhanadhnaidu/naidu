package com.cname.applicationName.BusinessSpecific;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cname.applicationName.PageObject.PLPObj;
import com.cname.core.framework.utils.Driver;

public class PLPB 
{
	public void selectProduct()
	{
		try
		{
			List<WebElement> w1 = Driver.driver.findElements(By.xpath(PLPObj.plpProduct));

			System.out.println(w1.size());
			
			Driver.driver.findElement(By.xpath(PLPObj.plpProduct)).click();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
