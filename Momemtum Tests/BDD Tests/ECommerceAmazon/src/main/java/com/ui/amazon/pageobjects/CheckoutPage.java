package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver) {	super(driver); 

	}
	
	@FindBy(xpath = "//h2//span[contains(text(), 'The 50 Greatest')]")	
	public static WebElement selectProduct;
}
