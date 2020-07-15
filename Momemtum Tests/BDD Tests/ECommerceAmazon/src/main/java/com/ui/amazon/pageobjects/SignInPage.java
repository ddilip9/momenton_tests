package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class SignInPage extends BasePage {
	
	public SignInPage(WebDriver driver) { super(driver); 

	}
	
	@FindBy(xpath = "//input[@type='email']")	
	public static WebElement emailInputField;
	
	@FindBy(id="continue")	
	public static WebElement continueButton;
	
	@FindBy(xpath = "//input[@type='password']")	
	public static WebElement passwordInputField;
	
	@FindBy(id="signInSubmit")	
	public static WebElement signInButton;
	
}
