Feature: Checkout Flow

Scenario: Successful purchase
  Given user is on login page
  When user logs in with valid credentials
  Then user should be on products page
  When user adds top two items
  And user goes to cart
  And user proceeds to checkout
  And user fills form
  Then user should be on overview page