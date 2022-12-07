package com.sdp.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Statepom {
	public WebDriver driver = null;
	@FindBy(xpath = "//h1[text()='Get Vaccinated in 3 Easy Steps']")
	private WebElement scrollDown;

	public WebElement getScrollDown() {
		return scrollDown;
	}

	@FindBy(xpath = "//span[text()='Select Your State']")
	private WebElement state;

	public WebElement getState() {
		return state;
	}

	@FindBy(xpath = "//mat-option[@role='option']/span")
	private List<WebElement> tamilNadu;

	public List<WebElement> getTamilNadu() {
		return tamilNadu;
	}

	@FindBy(xpath = "(//span[@class='mat-option-text'])[32]")
	private WebElement scrollDown1;

	public WebElement getScrollDown1() {
		return scrollDown1;
	}

	public Statepom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
