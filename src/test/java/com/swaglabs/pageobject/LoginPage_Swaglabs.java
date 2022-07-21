package com.swaglabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Swaglabs {
	
	
WebDriver ldriver;
	
	
	public LoginPage_Swaglabs(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	@FindBy(xpath="//span[@class='title']")
	static
	WebElement productPageHeading;
	
	//identify action on webelemt
	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterPassword(String passw)
	{
		password.sendKeys(passw);
	}
	
	public void clickLoginbutton()
	{
		loginbutton.click();
	}
	
	public static String getProductHeading()
	{
		return productPageHeading.getText();
		
	}


}
