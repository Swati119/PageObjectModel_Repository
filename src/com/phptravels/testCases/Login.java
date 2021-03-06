package com.phptravels.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravels.browserSpecific.Browser;
import com.phptravels.browserSpecific.FirefoxBrowser;
import com.phptravels.pageObjects.AccountPage;
import com.phptravels.pageObjects.LoginPage;
import com.phptravels.utils.CommonUtils;

public class Login {
	WebDriver driver;
	
	Browser firefoxBrowser = new FirefoxBrowser();
	CommonUtils utils = new CommonUtils();
//	LoginPage loginPage = new LoginPage(driver);
	
	String propertyFileName = "properties/config.properties";
	String user = utils.readProperties(propertyFileName, "userName");
	String password = utils.readProperties(propertyFileName, "password");
	String nameOfUser = utils.readProperties(propertyFileName, "nameOfUser");

	@BeforeTest
	public void LaunchBrowser() throws InterruptedException{
		
		WebDriver ffdriver = firefoxBrowser.initializeBrowser();
		this.driver = ffdriver;
	}
	
	@Test
	public void browseToUrl(){
		driver.get(utils.readProperties(propertyFileName, "url"));
	}

	@Test
	public void loginToApplication() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		loginPage.enter_userName(user);
		loginPage.enter_password(password);
		loginPage.unCheck_rememberMeCheckBox();
		loginPage.click_LoginButton();
		String result = accountPage.validateWelComeMessage(nameOfUser);
		System.out.println("Printing the result = "+result);
	}
	
	@Test
	public void logout(){
		AccountPage accountPage = new AccountPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		accountPage.clickOn_AccountDropdownToggle();
		accountPage.clickOn_Logout();
		String result = loginPage.validatePageTitle();
		System.out.println("Printing the result = "+result);
	}
}
