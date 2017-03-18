package com.phptravels.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {


	WebDriver driver;
	
	public WebUtils(WebDriver seleniumDriver){
		this.driver = seleniumDriver;
	}
	
	public WebDriverWait explicitWait (int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait;		
	}
	
}
