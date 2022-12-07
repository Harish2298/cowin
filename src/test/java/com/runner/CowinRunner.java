package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.CowinBaseclass;
import com.cowin.property.ConfigurationHelper;

import io.cucumber.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/r.harish/eclipse-workspace/com.cowin/src/test/java/com/feature/cowin.feature",
glue="com.stepdefinition", monochrome=true, plugin={"pretty",
		"html:Report/htmlReport.html",
		"json:Report/jsonreport.json",
		"junit:Report/junitReport.xml",
		//"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html"
		})
public class CowinRunner extends CowinBaseclass {
	
	public static WebDriver driver=null;
	
	@BeforeClass
	public static void setUp() throws IOException {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		//driver=driver("chrome");//------> baseClass
		String browser = ConfigurationHelper.getInstance().getBrowser();
		driver=driver(browser);
	}
	
	
	@AfterClass
	public static void tearDown() {
		//driver.close();
		close();//-----> baseClass
	}
	

}
