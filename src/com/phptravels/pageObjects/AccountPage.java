package com.phptravels.pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.phptravels.utils.WebUtils;

public class AccountPage {

	WebDriver driver;
	
	
	public AccountPage(WebDriver seleniumDriver){
		this.driver = seleniumDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "RTL")
	WebElement welcomeMessage;
	
	@FindBy(partialLinkText= "John")
	WebElement accountDropDownToggle;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	  
	
	public String validateWelComeMessage(String nameOfUser){
		WebUtils webUtils = new WebUtils(driver);
		String status = "Failed";
		WebDriverWait wait = webUtils.explicitWait(15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("RTL")));
		String welcomeMessageText = welcomeMessage.getText();
		Assert.assertEquals(welcomeMessageText, "Hi, "+nameOfUser);
		status = "Passed";
		return status;
	}
	
	public void clickOn_AccountDropdownToggle(){
		WebUtils webUtils = new WebUtils(driver);
		WebDriverWait wait = webUtils.explicitWait(15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dropdown-toggle")));
		accountDropDownToggle.click();
	}
	
	public void clickOn_Logout(){
		WebUtils webUtils = new WebUtils(driver);
		WebDriverWait wait = webUtils.explicitWait(15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
		logout.click();
	}
	
}
