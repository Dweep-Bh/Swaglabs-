package com.swaglabs.testcases;

import java.util.Collections;
import java.util.Comparator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.pageobject.LoginPage_Swaglabs;
import com.swaglabs.pageobject.ProductPage_Swaglabs;

public class ProductAddToCart extends BaseClass {
	
	@Test(priority=0)
	public void verifyLogin()
	
	{
		
		
		       
				driver.get(url);
				logger.info("url open");
				
				LoginPage_Swaglabs ls=new LoginPage_Swaglabs(driver);
				ls.enterUsername("standard_user");
				ls.enterPassword("secret_sauce");
				ls.clickLoginbutton();
				String ExcpetedResults="PRODUCTS";
				String ActualResults=ls.getProductHeading();
				Assert.assertEquals(ActualResults, ExcpetedResults);
				logger.info("Clicked on login Button");
	}
	@Test(priority=2)
	public void priceSorting()
	{
		ProductPage_Swaglabs ps=new ProductPage_Swaglabs(driver);
		Collections.sort(ps.getBeforeFilterPricelist());
		ps.selectFilterDropdownLowToHigh();
		Assert.assertEquals(ps.getBeforeFilterPricelist(), ps.getAfterFilterPriceList());
		logger.info("Sorting Functionality is working properly and item has been arranged as requested");
		
	}
	@Test(priority=1)
	public void addToCart()
	{
		ProductPage_Swaglabs ps=new ProductPage_Swaglabs(driver);
		Collections.sort(ps.getBeforeFilterPricelist());
		Double highestprice=ps.getBeforeFilterPricelist().get(ps.getBeforeFilterPricelist().size()-1);
		ps.clickAddToCartButton(highestprice);
		String ExpectedResult="1";
		String ActualResult=ps.getCartItemno();
		Assert.assertEquals(ExpectedResult, ActualResult);
		logger.info("AddToCart successfully");
	}

}
