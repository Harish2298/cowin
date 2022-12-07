package com.sdp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Sdp {//singleTon Design pattern or Page Object Manager
	public Statepom st;
	public WebDriver driver = null;

	public Statepom getState() {
		if (st == null) {
			st = new Statepom(driver);

		}
		return st;
	}

	public Districtpom getDistrict() {
		Districtpom dt = new Districtpom(driver);
		return dt;
	}
	public Searchpom getSearch() {
		Searchpom sr = new Searchpom(driver);
		return sr;
		
	}
	public SlotSearch getslotSearch() {
		SlotSearch ss = new SlotSearch(driver);
		return ss;
	}
	public HospitalCount gethospitalCount() {
		HospitalCount hc = new HospitalCount(driver);
		return hc;
	}
	
	
	
	
	
	public Sdp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
