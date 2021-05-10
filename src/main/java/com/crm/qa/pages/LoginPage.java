package com.crm.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// cretion of webelements
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login ')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	private WebElement forgotpassword;
	
	@FindBy(xpath="//div[contains(text(),'Request Login Info')]")
	private WebElement requestinfobtn;
	
	@FindBy(linkText="Return to login page")
	private WebElement returntologinpage;
	
	@FindBy(xpath="//div[@class='atProductName']")
	private WebElement logo;
	
	//initialize the WebElement
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods 
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public void forgotPwdLink()
	{
		forgotpassword.click();
	}
	
	public boolean requestInfoLink()
	{
		return requestinfobtn.isDisplayed();
	}
	
	public void returnHomePage()
	{
		returntologinpage.click();
	}
	
	public HomePage login(String usr, String pwd)
	{
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
