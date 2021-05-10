package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
//	@FindBy(xpath="//td[contains(text(),'Enter Time-Track')]")
//	private WebElement homepagelogo;
	
	@FindBy(xpath="//div[@id='container_tasks']")
	@CacheLookup // the below webelement will be stored in a cache memory and next time onwards, webelement will be fetched from this cahce
	// memory, not the DOM
	private WebElement tasklink;
	
	@FindBy(xpath="//div[@id='container_reports']")
	private WebElement reportslink;
	
	
	@FindBy(xpath="//span[@class='arrow']")
	private WebElement dropdwbtn;
	
	@FindBy(xpath="//span[@class='dashedLink']")
	private WebElement userlist;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public TaskPage taskLinkClick()
	{
		tasklink.click();
		return new TaskPage();
	}
	
	public ReportPage reportLinkClick()
	{
		reportslink.click();
		return new ReportPage();
	}
	
	
	public void clickUserdrpdwn()
	{
		dropdwbtn.click();
	}
	
	public String validateUserName()
	{
		return userlist.getText();
	}
	
	
	//div[contains(@class,'row task')]

}
