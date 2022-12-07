package com.sdp.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlotSearch {
	public WebDriver driver=null;
	@FindBy(xpath = "//input[@id='c1']/following::label[@for='c1']")
	private WebElement age;
	
	@FindBy(xpath = "//input[@id='cdoes2']/following::label[@for='cdoes2']")
	private WebElement dose;
	
	@FindBy(xpath = "//input[@id='c6']/following::label[@for='c6']")
	private WebElement payment;
	
	@FindBy(xpath = "//input[@id='c1']/following::label[@for='c3']")
	private WebElement vaccine;
	
	@FindBy(xpath = "//div[@class='show-result']/child::ul/child::li")
	private List<WebElement> results;

	public WebElement getAge() {
		return age;
	}

	public WebElement getDose() {
		return dose;
	}

	public WebElement getPayment() {
		return payment;
	}

	public WebElement getVaccine() {
		return vaccine;
	}

	public List<WebElement> getResults() {
		return results;
	}
	
	public SlotSearch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	

}
