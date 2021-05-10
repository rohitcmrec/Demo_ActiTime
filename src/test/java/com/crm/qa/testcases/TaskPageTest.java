package com.crm.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.testdata.ExcelTestData;

public class TaskPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	TaskPage taskpage;
	ExcelTestData exceltestdata;
	
	
	public TaskPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initBrowser();
		loginpage = new LoginPage();
		homepage = new HomePage();
		taskpage = new TaskPage();
		exceltestdata = new ExcelTestData();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.taskLinkClick();
		
	}
	
	@Test(enabled=false)
	public void validateTaskTitle()
	{
		String title = taskpage.getTaskTitle();
		Assert.assertEquals(title, "actiTIME - Task List");
	}
	
	@Test(dataProvider="getdata",enabled=false)
	public void custCreation(String name, String des)
	{
		taskpage.createcust(name,des);
	}
	
	@DataProvider
	public Object [][] getdata()
	{
		Object[][] testdata = ExcelTestData.getExcelData();
		return testdata;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
