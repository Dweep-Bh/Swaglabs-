package com.swaglabs.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.pageobject.LinkdinButton;
import com.swaglabs.pageobject.LoginPage_Swaglabs;

public class VerifyLinkdinButton extends BaseClass {
   
	
	
	@Test
	public void linkdinbuttonverification()
	{
		driver.get(url);
		LoginPage_Swaglabs ls=new LoginPage_Swaglabs(driver);
		ls.enterUsername("standard_user");
		ls.enterPassword("secret_sauce");
		ls.clickLoginbutton();
		
		LinkdinButton lb= new LinkdinButton(driver);
		lb.clickLinkdinbutton();
	    logger.info("clicked on Linkdin button");
	}
	
	

}
