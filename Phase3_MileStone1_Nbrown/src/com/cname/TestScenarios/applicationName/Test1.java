package com.cname.TestScenarios.applicationName;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cname.core.framework.DataLayer.Excel;
import com.cname.core.framework.DataLayer.Property;
import com.cname.core.framework.WebDriver.SeWebDriver;
import com.cname.core.framework.utils.Driver;
import com.cname.core.framework.utils.FindBy;
import com.cname.core.framework.utils.Global;

public class Test1
{
	@Test
	public void test1()
	{
		SeWebDriver sdriver = new SeWebDriver();
		sdriver.lounchApp(Global.url);
		WebElement w1 = sdriver.findElement("id", "searchKeyWords");
		w1.sendKeys("Jeans");
		
		
		
		
		
		
		
		
		
		
		
		
		
		String val1 = Excel.readData("Sheet1", 2, 3);
		System.out.println(val1);
		
		Excel.setData("Sheet1", 2, 6, "My Test");
		
		ArrayList<String> lst = Excel.getAllRowData("Sheet1", 2);
		System.out.println(lst);
	
		
		ArrayList<String> lst1 = Excel.getAllColData("Sheet1", 3);
		System.out.println(lst1);
		
		String data = Property.getValue("url");
		System.out.println("URL : "+data);
	}
}	
