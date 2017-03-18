package com.phptravels.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.phptravels.utils.WebUtils;

import junit.framework.Assert;

public class LoginPage {
	
	WebDriver driver;
	WebUtils webUtil = new WebUtils(driver);
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement userNameEditBox;
	
	@FindBy(name = "password")
	WebElement passwordEditBox;
	
	@FindBy(xpath = "//input[@id='remember-me']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement incorrectCredentialAlert;
	
	public void enter_userName(String user){
		userNameEditBox.clear();
		userNameEditBox.sendKeys(user);
	}
	
	public void enter_password(String password){
		passwordEditBox.clear();
		passwordEditBox.sendKeys(password);
	}
	
	public void check_rememberMeCheckBox(){
		boolean checkBoxSelected = rememberMeCheckBox.isSelected();
		if(!checkBoxSelected){
			rememberMeCheckBox.click();
		}
	}
	
	public void unCheck_rememberMeCheckBox(){
		boolean checkBoxSelected = rememberMeCheckBox.isSelected();
		if(checkBoxSelected){
			rememberMeCheckBox.click();
		}
	}
	
	public void click_LoginButton(){
		loginButton.click();
	}
	
	@SuppressWarnings("deprecation")
	public String validate_LoginErrorMessage() throws InterruptedException{
		String result = "";
		try{
			/*WebDriverWait wait = webUtil.explicitWait(30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert alert-danger")));*/
			Thread.sleep(15000);
			String errorMessage = incorrectCredentialAlert.getText();
			Assert.assertEquals("Invalid Email or Password", errorMessage);
			result = "passed";
		}catch (NoSuchElementException e){
			result = "Error message not found";
			e.printStackTrace();
			
			System.out.println("printing from catch part");
		}
		return result;
	}
}
