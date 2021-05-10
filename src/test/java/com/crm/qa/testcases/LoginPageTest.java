package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		
		initBrowser();
		loginpage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	@Test
	public void validateLogo()
	{
		boolean logo = loginpage.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void forgotPwdLink()
	{
		loginpage.forgotPwdLink();
		boolean link = loginpage.requestInfoLink();
		Assert.assertTrue(link);
		loginpage.returnHomePage();
	}
	
	@Test
	public void login()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
