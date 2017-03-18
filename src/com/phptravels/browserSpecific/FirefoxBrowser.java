package com.phptravels.browserSpecific;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends Browser{

	WebDriver driver;
	
	public FirefoxBrowser() {
		super("firefox");
		this.driver = driver;
	}

	@Override
	public WebDriver initializeBrowser() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

}
