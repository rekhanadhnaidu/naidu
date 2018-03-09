package com.cname.core.framework.DataLayer;

import java.io.FileInputStream;
import java.util.Properties;

import com.cname.core.framework.utils.Global;

public class Property 
{
	public static String getValue(String key)
	{
		String data = null;
		try
		{
			FileInputStream file = new FileInputStream(Global.proFilePath);
			
			Properties pro = new Properties();
			pro.load(file);
			
			data = pro.getProperty(key);
		}
		catch(Exception e)
		{
			new Exception("File not found");
		}
		
		return data;
		
	}
}
