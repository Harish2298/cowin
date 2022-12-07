package com.sdp.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HospitalCount {
	public WebDriver driver=null;
	@FindBy(xpath = "//div[@class='row-disp']")
	private List<WebElement> count;

	public List<WebElement> getCount() {
		return count;
	}
	
	public HospitalCount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
