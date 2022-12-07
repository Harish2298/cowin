package com.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CowinBaseclass {// inheritance and static keyword
	public static WebDriver driver = null;
	public static JavascriptExecutor java;

	public static void click(WebElement element) {
		element.click();
	}

	public static WebDriver driver(String value) {
		if (value.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/r.harish/eclipse-workspace/Selinum/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (value.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "/Users/r.harish/eclipse-workspace/Selinum/edgedriver");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		return driver;

	}

	public static void javaScriptScroll(WebElement scrollIntoView) {
		java = (JavascriptExecutor) driver;
		java.executeScript("arguments[0].scrollIntoView();", scrollIntoView);
	}

	public static void javaClick(WebElement click) {
		java = (JavascriptExecutor) driver;
		java.executeScript("arguments[0].click();", click);

	}

	public static void getCurrentUrl(String url) {
		driver.get(url);
	}

	public static void impli() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public static void close() {
		driver.close();
	}

	public static void thread1() throws InterruptedException {
		Thread.sleep(1000);
	}

	public static void thread2() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static void thread3() throws InterruptedException {
		Thread.sleep(3000);
	}
	public static void sendKeys(WebElement element,String value ) {
		element.sendKeys(value);
	}
	

}
