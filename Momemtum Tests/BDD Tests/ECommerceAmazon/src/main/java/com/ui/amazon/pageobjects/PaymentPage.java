package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class PaymentPage extends BasePage {
	
	public PaymentPage(WebDriver driver) {	super(driver);

	}
	
	@FindBy(xpath = "//span[contains(text(), 'Add a new card')]")	
	public static WebElement addNewCardButton;
	
}
