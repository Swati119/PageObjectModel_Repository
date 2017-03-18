package com.phptravels.testCases;

import org.openqa.selenium.WebDriver;

import com.phptravels.pageObjects.LoginPage;
import com.phptravels.utils.CommonUtils;

public class Login {

	String user;
	String password;
	WebDriver driver;
	
	LoginPage loginPage;
	
	public Login (String propertyFileName, WebDriver driverObj){
		CommonUtils commonUtils = new CommonUtils(); 
		this.user = commonUtils.readProperties(propertyFileName, "userName");
		this.password = commonUtils.readProperties(propertyFileName, "password");
		this.driver = driverObj;
		this.loginPage = new LoginPage(driver);
	}
	
	public void loginToApplication() throws InterruptedException{
		loginPage.enter_userName(user);
		loginPage.enter_password(password);
		loginPage.unCheck_rememberMeCheckBox();
		loginPage.click_LoginButton();
		/*String result = loginPage.validate_LoginErrorMessage();
		System.out.println(result);*/
	}
}
