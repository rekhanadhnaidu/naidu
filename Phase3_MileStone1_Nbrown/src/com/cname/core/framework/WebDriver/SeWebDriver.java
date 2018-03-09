package com.cname.core.framework.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cname.core.framework.utils.Driver;
import com.cname.core.framework.utils.FindBy;
import com.cname.core.framework.utils.Global;

public class SeWebDriver
{
	public WebDriver driver;
	public WebElement webElm;
	public List<WebElement> lWebElm;
	public Select sel;
	public Actions act;
	public Alert alt;
	
	public SeWebDriver()
	{
		driver = Driver.getDriver();
	}
	
	public void lounchApp(String url)
	{
		try
		{
			driver.get(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public WebElement findElement(String locator, String locatorValue)
	{
		try
		{
			webElm =driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return webElm;
	}
	
	public List<WebElement> findElements(String locator, String locatorValue)
	{
		try
		{
			lWebElm =driver.findElements(FindBy.seByMechanism(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lWebElm;
	}
	
	public String getTitle()
	{
		String title = null;
		try
		{
			title = driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return title;
	}
	
	public String getUrl()
	{
		String url = null;
		try
		{
			url = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return url;
	}
	
	public String getPageSource()
	{
		String sourceCode = null;
		try
		{
			sourceCode = driver.getPageSource();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sourceCode;
	}
	
	public void implicitlyWait()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Global.synTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void explicitlyWait(String locator, String locatorValue)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Global.synTime);
			wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.seByMechanism(locator, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void pageLoadWait()
	{
		try
		{
			driver.manage().timeouts().pageLoadTimeout(Global.synTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Select select(String locator, String locatorValue)
	{
		Select sel = null;
		
		try
		{
			webElm = driver.findElement(FindBy.seByMechanism(locator, locatorValue));
			sel = new Select(webElm);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sel;
	}
	
	public void selectByVisibleText(String locator, String loactorValue, String dropDownText)
	{
		try
		{
			Select sel = select(locator, loactorValue);
			sel.selectByVisibleText(dropDownText);
		}
		catch(Exception e)
		{
			new Exception("Value is not present : ");
		}
	}
	
	public void selectByValue(String locator, String loactorValue, String dropDownText)
	{
		try
		{
			Select sel1 = select(locator, loactorValue);
			sel1.selectByValue(dropDownText);
		}
		catch(Exception e)
		{
			new Exception("Value is not present : ");
		}
	}
	
	public void selectByIndex(String locator, String loactorValue, int index)
	{
		try
		{
			Select sel1 = select(locator, loactorValue);
			sel1.selectByIndex(index);
		}
		catch(Exception e)
		{
			new Exception("Value is not present : ");
		}
	}
	
	public List<WebElement> getAllDropDownValue(String locator, String locatorValue)
	{
		List<WebElement> lst = null;
		try
		{
			Select sel = select(locator, locatorValue);
			lst = sel.getOptions();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
	public boolean deselectByVisibleTest(String locator, String locatorValue, String val)
	{
		boolean flag = false;
		try
		{
			Select sel = select(locator, locatorValue);
			sel.deselectByVisibleText(val);
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public List<WebElement> getAllSelectedOptions(String locator, String locatorValue)
	{
		List<WebElement> lst = null;
		try
		{
			Select sel = select(locator, locatorValue);
			lst = sel.getAllSelectedOptions();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	
	
	public String getWindowId()
	{
		String winId = null;
		try
		{
			winId= driver.getWindowHandle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return winId;
	}
	
	public Set<String> getAllWinIds()
	{
		Set<String> winIds = null;
		try
		{
			winIds= driver.getWindowHandles();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return winIds;
	}
	
	public boolean switchWindowByTitle(String expectedTitle)
	{
		boolean flag= false;
		try
		{
			Set<String> allWinIds = getAllWinIds();
			for(String winId : allWinIds)
			{
				driver.switchTo().window(winId);
				String actualTitle = driver.getTitle();
				if(actualTitle.equals(expectedTitle))
				{
					flag=true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public void closeAllOtherWindows()
	{
		try
		{
			String mainWinId = getWindowId();
			Set<String> allWinIds = getAllWinIds();
			for(String winId : allWinIds)
			{
				
				boolean b = mainWinId.equals(winId);
				if(!b)
				{
					driver.switchTo().window(winId);
					driver.close();
				}
			}
			driver.switchTo().window(mainWinId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void captureScreenShot(String sName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\SHALINI KUMARI\\git\\day1morningbatch03\\Phase3_MileStone1_Nbrown\\ScreenShot"+sName+".png");
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Actions getAction()
	{
		try
		{
			act = new Actions(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return act;
	}
	
	public void moveToElement(String locator, String locatorValue)
	{
		try
		{
			act = getAction();
			webElm = driver.findElement(FindBy.seByMechanism(locator, locatorValue));
			act.moveToElement(webElm).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
//	public void dragAndDrop(String locator, String locatorValue)
//	{
//		try
//		{
//			act = getAction();
//			webElm = driver.findElement(FindBy.seByMechanism(locator, locatorValue));
//			WebElement target = driver.findElement(FindBy.seByMechanism(locator, locatorValue));
//			act.dragAndDrop(webElm, target)
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public void rightClick(String locator, String locatorValue)
	{
		try
		{
			act = getAction();
			webElm = driver.findElement(FindBy.seByMechanism(locator, locatorValue));
			act.contextClick(webElm).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void keyboard(Keys key)
	{
		try
		{
			act = getAction();
			act.sendKeys(key).perform();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Alert getAlert()
	{
		try
		{
			alt = driver.switchTo().alert();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alt;
	}
	
	public void acceptAlert()
	{
		try
		{
			alt = getAlert();
			alt.accept();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String captureAlertText()
	{
		String altText = null;
		try
		{
			alt = getAlert();
			altText = alt.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return altText;
	}
	
	public void dismissAlert()
	{
		try
		{
			alt = getAlert();
			alt.dismiss();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
