package com.swaglabs.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;


public class LinkdinButton {

WebDriver driver;
	
	
	public LinkdinButton(WebDriver rdriver)
	{
		driver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[text()='LinkedIn']")
	WebElement LinkdinButton;
	
	public void clickLinkdinbutton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",LinkdinButton);
		LinkdinButton.click();
	}
	
	
}
