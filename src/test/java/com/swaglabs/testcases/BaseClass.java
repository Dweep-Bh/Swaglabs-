package com.swaglabs.testcases;

import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.swaglabs.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	
	String url = readConfig.getBaseUrl();
	
	String browser= readConfig.getBrowser();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		  case "chrome":
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			  break;
			  
		  case "msedge":
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		      break;
		      
		  case "firefox":
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
			  break; 
			  default:
				  driver = null;
				  break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		logger = LogManager.getLogger("SwagLabs");
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
