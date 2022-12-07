package com.TestNg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CowinTestNG {
	public WebDriver driver = null;
	public JavascriptExecutor java;

	@BeforeTest
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.cowin.gov.in/");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void selectState() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement scrollDown = driver.findElement(By.xpath("//h1[text()='Get Vaccinated in 3 Easy Steps']"));
		java = (JavascriptExecutor) driver;
		java.executeScript("arguments[0].scrollIntoView();", scrollDown);
		Thread.sleep(1000);
		WebElement state = driver.findElement(By.xpath("//span[text()='Select Your State']"));
		Thread.sleep(1000);
		state.click();
		Thread.sleep(2000);
		List<WebElement> tamilNadu = driver.findElements(By.xpath("//mat-option[@role='option']/span"));
		for (WebElement option : tamilNadu) {
			String actual = option.getText();
			WebElement scrollDown1 = driver.findElement(By.xpath("(//span[@class='mat-option-text'])[32]"));
			java.executeScript("arguments[0].scrollIntoView();", scrollDown1);
			Thread.sleep(2000);
			java.executeScript("arguments[0].click();", scrollDown1);
			break;
		}
	}

	@Test(dependsOnMethods = "selectState")
	public void selectDistrict() throws InterruptedException {
		Thread.sleep(1000);
		WebElement scrollDown1 = driver.findElement(By.xpath("//h1[text()='Get Vaccinated in 3 Easy Steps']"));

		java.executeScript("arguments[0].scrollIntoView();", scrollDown1);
		WebElement district = driver.findElement(By.xpath("//span[text()='Select District']"));
		district.click();
		Thread.sleep(1000);
		List<WebElement> option = driver.findElements(By.xpath("//mat-option[@role='option']/span"));
		for (int i = 0; i < option.size(); i++) {
			String text = option.get(i).getText();
			WebElement district1 = driver.findElement(By.xpath("//span[text()=' Chennai ']"));
			java.executeScript("arguments[0].scrollIntoView();", district1);
			Thread.sleep(2000);
			java.executeScript("arguments[0].click();", district1);

			break;
		}
	}

	@Test(priority = 1)
	public void clickButton() throws InterruptedException {
		Thread.sleep(3000);
		WebElement scroll = driver.findElement(By.xpath("//a[text()='Login to book your slot']"));
		java.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.xpath("//button[@tabindex='0']"));
		button.click();
	}

	@Test(priority = 2)
	public void search() throws InterruptedException {
		Thread.sleep(3000);
		WebElement age = driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c1']"));
		age.click();
		WebElement dose = driver.findElement(By.xpath("//input[@id='cdoes2']/following::label[@for='cdoes2']"));
		dose.click();
		WebElement payment = driver.findElement(By.xpath("//input[@id='c6']/following::label[@for='c6']"));
		payment.click();
		WebElement vaccine = driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c3']"));
		vaccine.click();
		Thread.sleep(3000);
		List<WebElement> results = driver.findElements(By.xpath("//div[@class='show-result']/child::ul/child::li"));
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).getText());

		}
		System.out.println();
	}

	@Test(dependsOnMethods = "search")
	public void hospitalCount() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> count = driver.findElements(By.xpath("//div[@class='row-disp']"));
		for (WebElement hospitals : count) {
			System.out.println("The Suggested Hospitals");
			System.out.println(hospitals.getText());
		}
		System.out.println();
		System.out.println("The total count Hospital is :" + count.size());

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
