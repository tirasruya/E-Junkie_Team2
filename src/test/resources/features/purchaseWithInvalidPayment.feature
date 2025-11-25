Feature: Demo e-Book Purchase with Invalid Payment

  Background:
    When Navigate the homepage
    Then Find the Add to Cart button and click it
    Then Verify E Book added

  Scenario: Attempt payment with empty email and billing fields
    When Click on Pay with Bank Card option on the cart page
    Then The payment page should display fields for:
      | Email          |
      | Name           |
      | Card Number    |
      | Expiration Date|
      | CVC            |
    When Leave all payment fields empty
    And Click the Pay button
    Then Verify validation errors for:
      | Invalid Email   |
      | Invalid Billing Name |
