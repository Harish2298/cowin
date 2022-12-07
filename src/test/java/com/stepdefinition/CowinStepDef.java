package com.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.CowinBaseclass;
import com.cowin.property.ConfigurationHelper;
import com.runner.CowinRunner;
import com.sdp.pom.Sdp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CowinStepDef extends CowinBaseclass {
	public WebDriver driver=CowinRunner.driver;
	public JavascriptExecutor java;
	Sdp cowin = new Sdp(driver);
	@Given("user Enter The Url")
	public void user_enter_the_url() throws IOException {
		//driver.get("https://www.cowin.gov.in/");
		//getCurrentUrl("https://www.cowin.gov.in/");
		String url = ConfigurationHelper.getInstance().getUrl();
		getCurrentUrl(url);
	}

	@Then("user Select The State")
	public void user_select_the_state() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		impli();
		//WebElement scrollDown = driver.findElement(By.xpath("//h1[text()='Get Vaccinated in 3 Easy Steps']"));
		WebElement scrollDown = cowin.getState().getScrollDown();
		javaScriptScroll(scrollDown);
//		java = (JavascriptExecutor) driver;
//		java.executeScript("arguments[0].scrollIntoView();", scrollDown);
		//javaScriptScroll(scrollDown);//----> baseClass
		//Thread.sleep(1000);
		thread1();
		//WebElement state = driver.findElement(By.xpath("//span[text()='Select Your State']"));
		WebElement state = cowin.getState().getState();
		click(state);
		//Thread.sleep(1000);
		thread1();
		//state.click();
		//click(state);----> baseClass
		//Thread.sleep(2000);
		thread2();
		//List<WebElement> tamilNadu = driver.findElements(By.xpath("//mat-option[@role='option']/span"));
		 List<WebElement> tamilNadu = cowin.getState().getTamilNadu();
		for (WebElement option : tamilNadu) {
			String actual = option.getText();
			WebElement scrollDown1 = driver.findElement(By.xpath("(//span[@class='mat-option-text'])[32]"));
			//java.executeScript("arguments[0].scrollIntoView();", scrollDown1);
			javaScriptScroll(scrollDown1);//-----> baseClass
			//Thread.sleep(2000);
			thread2();
			//java.executeScript("arguments[0].click();", scrollDown1);
			javaClick(scrollDown1);//-----> baseClass
			break;
		}
	}
	

	@Then("user Select The District")
	public void user_select_the_district() throws InterruptedException {
		//Thread.sleep(1000);
		impli();
		thread3();
		//WebElement scrollDown1 = driver.findElement(By.xpath("//h1[text()='Get Vaccinated in 3 Easy Steps']"));
        WebElement scrollDown1 = cowin.getDistrict().getScrollDown1();
		//java.executeScript("arguments[0].scrollIntoView();", scrollDown1);
		javaScriptScroll(scrollDown1);//---->baseClass
		//WebElement district = driver.findElement(By.xpath("//span[text()='Select District']"));
		WebElement district = cowin.getDistrict().getDistrict();
		//district.click();
		click(district);//---->baseClass
		//Thread.sleep(1000);
		thread1();
		//List<WebElement> option = driver.findElements(By.xpath("//mat-option[@role='option']/span"));
		List<WebElement> option = cowin.getDistrict().getOption();
		for (int i = 0; i < option.size(); i++) {
			String text = option.get(i).getText();
			//WebElement district1 = driver.findElement(By.xpath("//span[text()=' Chennai ']"));
			WebElement district1 = cowin.getDistrict().getDistrict1();
			//java.executeScript("arguments[0].scrollIntoView();", district1);
			javaScriptScroll(district1);//
			//Thread.sleep(2000);
			thread2();
			//java.executeScript("arguments[0].click();", district1);
			javaClick(district1);//baseClass

			break;
		}
	}

	

	@Then("user Click The Button")
	public void user_click_the_button() throws InterruptedException {
		//Thread.sleep(3000);
		impli();
		thread3();
		//WebElement scroll = driver.findElement(By.xpath("//a[text()='Login to book your slot']"));
		WebElement scroll = cowin.getSearch().getScroll();
		//java.executeScript("arguments[0].scrollIntoView();", scroll);
		javaScriptScroll(scroll);//--->baseClass
		//Thread.sleep(3000);
		thread3();
		//WebElement button = driver.findElement(By.xpath("//button[@tabindex='0']"));
		WebElement button = cowin.getSearch().getButton();
		//button.click();
		click(button);
	}

	@When("user Click The Required Options")
	public void user_click_the_required_options() throws InterruptedException {
		//Thread.sleep(3000);
		thread3();
		//WebElement age = driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c1']"));
		WebElement age = cowin.getslotSearch().getAge();
		age.click();
		//WebElement dose = driver.findElement(By.xpath("//input[@id='cdoes2']/following::label[@for='cdoes2']"));
		WebElement dose = cowin.getslotSearch().getDose();
		dose.click();
		//WebElement payment = driver.findElement(By.xpath("//input[@id='c6']/following::label[@for='c6']"));
		WebElement payment = cowin.getslotSearch().getPayment();
		payment.click();
		//WebElement vaccine = driver.findElement(By.xpath("//input[@id='c1']/following::label[@for='c3']"));
		WebElement vaccine = cowin.getslotSearch().getVaccine();
		vaccine.click();
		Thread.sleep(3000);
		//List<WebElement> results = driver.findElements(By.xpath("//div[@class='show-result']/child::ul/child::li"));
		List<WebElement> results = cowin.getslotSearch().getResults();
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).getText());
			
		}System.out.println();
		
	}

	@Then("user Gets The Mulitiple Suggestions")
	public void user_gets_the_mulitiple_suggestions() throws InterruptedException {
		//Thread.sleep(3000);
		thread3();
		//List<WebElement> count = driver.findElements(By.xpath("//div[@class='row-disp']"));
		List<WebElement> count = cowin.gethospitalCount().getCount();
		for (WebElement hospitals : count) {
			System.out.println("The Suggested Hospitals");
			System.out.println(hospitals.getText());
			System.out.println();
		}
		System.out.println();
		System.out.println("The total count Hospital is :"+count.size());
	}
	}


