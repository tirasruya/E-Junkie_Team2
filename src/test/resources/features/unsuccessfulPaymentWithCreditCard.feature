Feature: Failed Debit/Credit Card Payment Verification

  Background:
    When Navigate the homepage
    Then Find the Add to Cart button and click it
    Then Verify E Book added
    When Click on Pay with Bank Card option on the cart page
    Then The payment page should display fields for: Email, Name, Card Number, Expiration Date, CVC

  Scenario: Attempt payment with invalid debit/credit card
    When Fill in the mandatory payment fields with valid data except for Card Number
    And Click the Payment button
    Then Verify the error message Your card number is invalid