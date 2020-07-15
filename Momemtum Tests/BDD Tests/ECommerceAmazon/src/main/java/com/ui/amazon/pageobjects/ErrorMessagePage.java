package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class ErrorMessagePage extends BasePage {
	
	public ErrorMessagePage(WebDriver driver) {	super(driver);
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='auth-error-message-box']/div/div/ul/li/span")	
	public static WebElement errorMessage;
	
}
