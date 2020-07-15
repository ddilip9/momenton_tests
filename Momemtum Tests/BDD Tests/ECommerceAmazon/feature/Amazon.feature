@amazon
Feature: Amazon e-commerce website add to cart and checkout


@addProductstoCart
Scenario Outline: This scenario is used to search, add products to cart, proceed to checkout and stop at payment
# Landing page
	Given User will launch Landing page using Landing page URL "<LandingURL>"
	Given User enters "<ProductName>" in the search form field 
	When User clicks on search button and wait for search results
	When User will Click on the "<ProductName>" in search results
	When User will click on AddToCart button
	Then User should see AddedToCart confirmation message is displayed
	Then User will click on ProceedToCheckout button
	Then User enters "<EmailID>" and "<Password>" and clicks on sign in button
	Then User will click on DeliverToThisAddress button
	Then User should see AddNewCard button to complete the checkout process

Examples:
	|LandingURL			        		|ProductName                                   |EmailID           |Password	|
	|https://www.amazon.com.au/ |The 50 Greatest Matches in Australian Cricket |ddilip9@gmail.com	|Test@123	|



	
@addProductstoCart2
Scenario Outline: This scenario is used to search, add products to cart, proceed to checkout and stop at payment
# Landing page
	Given User will launch Landing page using Landing page URL "<LandingURL>"
	Given User enters "<ProductName>" in the search form field 
	When User clicks on search button and wait for search results
	When User will Click on the "<ProductName>" in search results
	When User will click on AddToCart button
	Then User should see AddedToCart confirmation message is displayed
	Then User will click on ProceedToCheckout button
	Then User enters "<EmailID>" and "<Password>" and clicks on sign in button
	Then User will click on DeliverToThisAddress button
	Then User should see AddNewCard button to complete the checkout process

Examples:
	|LandingURL			        		|ProductName                                   |EmailID           |Password	|
	|https://www.amazon.com.au/ |The Immortals of Australian Cricket |ddilip9@gmail.com	|Test@123	|
	
	
	
@errorMessageScenario
Scenario Outline: This scenario is used test error message scenario
# Landing page
	Given User will launch Landing page using Landing page URL "<LandingURL>"
	Given User enters "<EmailID>" and "<Password>" and clicks on sign in button
	Then User will verify for wrong password message and use the message for bug ticket
	And User will close the window

Examples:
	|LandingURL			        		|ProductName                                   |EmailID           |Password	|
	|https://www.amazon.com.au/ |The 50 Greatest Matches in Australian Cricket |ddilip9@gmail.com	|Te73858374837st@123	|
	