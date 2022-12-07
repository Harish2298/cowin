package com.sdp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpom {
	public WebDriver driver=null;
	@FindBy(xpath="//a[text()='Login to book your slot']")
	private WebElement scroll;
	
	@FindBy(xpath = "//button[@tabindex='0']")
	private WebElement button;

	public WebElement getScroll() {
		return scroll;
	}

	public WebElement getButton() {
		return button;
	}
	public Searchpom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
