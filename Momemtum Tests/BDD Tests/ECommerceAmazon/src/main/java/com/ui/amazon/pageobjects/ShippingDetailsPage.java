package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class ShippingDetailsPage extends BasePage {
	
	public ShippingDetailsPage(WebDriver driver) {	super(driver);

	}
	
	@FindBy(xpath = "//h3[@class='a-spacing-mini']/preceding::span[@class='a-button-inner'][3]")	
	public static WebElement continueButton;
	
}
