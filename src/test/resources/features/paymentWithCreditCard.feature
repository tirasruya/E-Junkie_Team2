Feature: Successful Debit/Credit Card Payment Verification

  Background:
    When Navigate the homepage
    Then Find the Add to Cart button and click it
    Then Verify E Book added
    When Click on Pay with Bank Card option on the cart page
    Then The payment page should display fields for: Email, Name, Card Number, Expiration Date, CVC

  Scenario: Attempt payment with valid debit/credit card
    When Fill in the mandatory payment fields with valid data
    And Click the Payment button with valid data
    Then Verify the confirmation message