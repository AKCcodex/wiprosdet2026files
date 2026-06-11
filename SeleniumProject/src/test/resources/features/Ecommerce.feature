Feature: E-Commerce End-to-End Flow

  Scenario: Complete ecommerce purchase flow

    Given User launches the browser
    When User logs in
    And User adds multiple products to cart
    And User removes one product from cart
    Then User validates total amount
    When User proceeds to checkout
    And User logs out
    Then Close the browser