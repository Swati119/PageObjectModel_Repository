package com.phptravels.browserSpecific;

import org.openqa.selenium.WebDriver;

public abstract class Browser {
	
	String browser;
	
	public Browser(String browserName){
		this.browser = browserName;
	}
	
	public abstract WebDriver initializeBrowser();

}
