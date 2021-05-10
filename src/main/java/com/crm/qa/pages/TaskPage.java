package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TimeUtil;

public class TaskPage extends TestBase{
	
	TimeUtil tu = new TimeUtil();
	
	@FindBy(xpath="//div[contains(text(),'Add New')]")
	private WebElement custdrpdwn;
	
	@FindBy(xpath="//div[@class='item createNewCustomer']")
	private WebElement addnewcust;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement name;
	
	@FindBy(xpath="(//textarea[@placeholder='Enter Customer Description'])")
	private WebElement descrip;
	
	@FindBy(xpath="(//div[@class='dropdownButton'])[15]")
	private WebElement companydrpdwn;
	
	@FindBy(xpath="(//div[contains(text(),'Galaxy Corporation')])[6]")
	private WebElement company;
	
	@FindBy(xpath="//div[contains(text(),'Create Customer')]")
	private WebElement createcust;
	
	public TaskPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getTaskTitle()
	{
		return driver.getTitle();
	}
	public void createcust(String empname,String empdesc)
	{
		custdrpdwn.click();
		addnewcust.click();
		name.sendKeys(empname);
		descrip.sendKeys(empdesc);
		companydrpdwn.click();
		tu.clickElementJScript(company);
		createcust.click();		
		
	}
}
