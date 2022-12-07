package com.sdp.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Districtpom {
public WebDriver driver = null;
	@FindBy(xpath = "//h1[text()='Get Vaccinated in 3 Easy Steps']")
	private WebElement ScrollDown1;

	public WebElement getScrollDown1() {
		return ScrollDown1;
	}

	@FindBy(xpath = "//span[text()='Select District']")
	private WebElement district;

	public WebElement getDistrict() {
		return district;
	}

	@FindBy(xpath = "//mat-option[@role='option']/span")
	private List<WebElement> option;

	public List<WebElement> getOption() {
		return option;
	}

	@FindBy(xpath = "//span[text()=' Chennai ']")
	private WebElement district1;

	public WebElement getDistrict1() {
		return district1;
	}
	public Districtpom(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
}
