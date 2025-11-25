Feature: Successful Payment Approval and Download the EBook

  Background:
    When Navigate the homepage
    Then Find the Add to Cart button and click it
    Then Verify E Book added
    When Click on Pay with Bank Card option on the cart page
    Then The payment page should display fields for: Email, Name, Card Number, Expiration Date, CVC
    When Fill in the mandatory payment fields with valid data
    And Click the Payment button with valid data
    Then Verify the confirmation message

  Scenario: Verify price and Download the EBook
    When Verify EBook price
    Then Download EBook
