package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class DeliveryAddressPage extends BasePage {
	
	public DeliveryAddressPage(WebDriver driver) {	super(driver);

	}
	
	@FindBy(xpath = "//div[contains(@class, 'ship-to-this-address')]")	
	public static WebElement deliverToThisAddressButton;
	
}
