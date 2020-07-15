package com.ui.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.uiframework.BasePage;

public class ResultsPage extends BasePage {
	
	public ResultsPage(WebDriver driver) { super(driver); 

	}	

	@FindBy(xpath = "//input[@id='add-to-cart-button']")	
	public static WebElement AddToCartButton;
	
	@FindBy(xpath = "//h1[contains(text(), 'Added to Cart')]")	
	public static WebElement AddedToCartText;
	
	@FindBy(xpath = "//*[@id='hlb-ptc-btn-native']")	
	public static WebElement proceedToCheckoutButton;
	
	@FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[2]")
	public static WebElement todaysDealsLink;
	
}
