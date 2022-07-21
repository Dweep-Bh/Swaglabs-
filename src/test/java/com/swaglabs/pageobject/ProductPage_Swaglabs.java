package com.swaglabs.pageobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage_Swaglabs {

	
 static WebDriver driver;
	
	
	public ProductPage_Swaglabs(WebDriver rdriver)
	{
		driver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> beforeFilterPrice;
	@FindBy(xpath="//select[@class='product_sort_container']")
	static
	WebElement dropdown;
	@FindBy(xpath="//div[@id='shopping_cart_container']//a//span")
	WebElement CartItemno;
	
	
	public List<Double> getBeforeFilterPricelist()
	{
		List<Double> beforeFilterPriceList=new ArrayList<>();
		for(WebElement p : beforeFilterPrice)
		{
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		return beforeFilterPriceList;
	}
		public static void selectFilterDropdownLowToHigh()
		{
		Select filterdropdown=new Select(dropdown);
			
		filterdropdown.selectByValue("lohi");
		}
		
		public static void selectFilterDropdownHighToLow()
		{
		Select filterdropdown=new Select(dropdown);
			
		filterdropdown.selectByValue("hilo");
		}
		public List<Double> getAfterFilterPriceList()
		{
		List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
		List<Double> afterFilterPriceList= new ArrayList<>();
		
		for(WebElement p : afterFilterPrice)
		{
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
		   return afterFilterPriceList;
		}
		
		public void clickAddToCartButton(Double highestprice)
		{
			WebElement AddTocart =driver.findElement(By.xpath("//div[normalize-space()='$"+highestprice+"']//following-sibling::button"));
			AddTocart.click();
		}
		
		public String getCartItemno()
		{
			return CartItemno.getText();
		}
		  
					
	}


