package com.amazon.stepdefinitions;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.uiframework.HybridDriver;
import com.ui.amazon.pageobjects.CheckoutPage;
import com.ui.amazon.pageobjects.DeliveryAddressPage;
import com.ui.amazon.pageobjects.ErrorMessagePage;
import com.ui.amazon.pageobjects.HomePage;
import com.ui.amazon.pageobjects.PaymentPage;
import com.ui.amazon.pageobjects.ResultsPage;
import com.ui.amazon.pageobjects.ShippingDetailsPage;
import com.ui.amazon.pageobjects.SignInPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonTestCaseSteps extends HybridDriver {

	@BeforeClass
	public void beforeClass() {

		try {
			driver = setDriver();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
	}

	@Given("^User will launch Landing page using Landing page URL \"([^\"]*)\"$")
	public void user_will_launch_Landing_page_using_Landing_page_URL(String url) throws Throwable {
		driver = setDriver();
		new HomePage(driver);
		new ResultsPage(driver);
		new SignInPage(driver);
		new DeliveryAddressPage(driver);
		new ShippingDetailsPage(driver);
		new PaymentPage(driver);
		new CheckoutPage(driver);
		new ErrorMessagePage(driver);
		
		launchURL(url);
	}
	
	@Given("^User enters \"([^\"]*)\" in the search form field$")
	public void user_enters_in_the_search_form_field(String ProductName) throws Throwable {
		enterValue(HomePage.searchText, ProductName);
	}

	@When("^User clicks on search button and wait for search results$")
	public void user_clicks_on_search_button_and_wait_for_search_results() throws Throwable {
		clickElement(HomePage.searchButton);
	}

	@When("^User will Click on the \"([^\"]*)\" in search results$")
	public void user_will_Click_on_the_productName_in_search_results(String ProductName) throws Throwable {
		WebElement selectProducts = driver.findElement(By.xpath("//h2//span[contains(text(), '"+ProductName+"')]"));
		System.out.println("The selected poduct xpath is --->" + selectProducts);
		selectProducts.click();		
	}

	@When("^User will click on AddToCart button$")
	public void user_will_click_on_AddToCart_button() throws Throwable {
		clickElement(ResultsPage.AddToCartButton);	
	}

	@Then("^User should see AddedToCart confirmation message is displayed$")
	public void user_should_see_AddedToCart_confirmation_message_is_displayed() throws Throwable {
		explicitWaitForDisplayed(ResultsPage.AddedToCartText, 3000);			
	}

	@Then("^User will click on ProceedToCheckout button$")
	public void user_will_click_on_ProceedToCheckout_button() throws Throwable {
		clickElement(ResultsPage.proceedToCheckoutButton);		
	}
	
	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\" and clicks on sign in button$")
	public void user_enters_and_and_clicks_on_sign_in_button(String EmailID, String Password) throws Throwable {
		clickElement(HomePage.loginButton);
		enterValue(SignInPage.emailInputField, EmailID);
		clickElement(SignInPage.continueButton);
		enterValue(SignInPage.passwordInputField, Password);
		clickElement(SignInPage.signInButton);
	}

	@Then("^User will click on DeliverToThisAddress button$")
	public void user_will_click_on_DeliverToThisAddress_button() throws Throwable {
		clickElement(DeliveryAddressPage.deliverToThisAddressButton);		
	}

	@Then("^User should see AddNewCard button to complete the checkout process$")
	public void user_should_see_AddNewCard_button_to_complete_the_checkout_process() throws Throwable {
		explicitWaitForDisplayed(PaymentPage.addNewCardButton, 3000);		
		closeWindow();
	}
	
	@Then("^User will verify for wrong password message and use the message for bug ticket$")
	public void user_will_verify_for_wrong_password_message_and_use_the_message_for_bug_ticket() throws Throwable {
	   String errorMessage = getText(ErrorMessagePage.errorMessage);
	   System.out.println("Error Message for Wrong Password ----> "+errorMessage);
	}

	@Then("^User will close the window$")
	public void user_will_close_the_window() throws Throwable {
	  closeWindow();
	}
	
}

