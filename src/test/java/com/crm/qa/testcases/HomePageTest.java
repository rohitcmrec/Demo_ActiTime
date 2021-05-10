package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utils.TimeUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TimeUtil timeutil;
	TaskPage taskpage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initBrowser();
		timeutil = new TimeUtil();
		homepage = new HomePage();
		loginpage = new LoginPage();
		taskpage = new TaskPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(enabled=false)
	public void validateHomePageTitle()
	{
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "actiTIME - Enter Time-Track", "please check the correct title");
	}
	
	@Test(enabled=false)
	public void changeUser()
	{
		try {
		homepage.clickUserdrpdwn();
		By user = By.xpath("//span[@class='userName']");
		timeutil.getElementsList(user, "Ramirez, Maria");
		}catch(StaleElementReferenceException e) {
		String username = homepage.validateUserName();
		Assert.assertEquals(username, "Ramirez, Maria");
		}
	}
	
	@Test(enabled=false)
	public void clickTakLink()
	{
		taskpage=homepage.taskLinkClick();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
