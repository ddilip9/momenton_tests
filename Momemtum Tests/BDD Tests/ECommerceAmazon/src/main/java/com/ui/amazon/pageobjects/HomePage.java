package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {	super(driver);
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	public static WebElement searchText;
	
	@FindBy(xpath = "//input[@value='Go']")
	public static WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"nav-link-accountList\"]")
	public static WebElement loginButton;

}
