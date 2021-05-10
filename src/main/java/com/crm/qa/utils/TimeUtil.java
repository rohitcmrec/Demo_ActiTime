package com.crm.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TimeUtil extends TestBase{
	
	public static long page_load_timeout=20;
	public static long implicit_wait=10;
	
	public void getElementsList(By xpath, String name)	
	{
		List<WebElement> eleList = driver.findElements(xpath);
		for(WebElement e:eleList)
		{
			if(e.getText().equalsIgnoreCase(name))
			{
				e.click();
			}
		}
	}
	
	public void clickElementJScript(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", ele);
	}
	
	public static void getScreenShot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File ("./Screenshot/"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(src, trg);
	}

}
