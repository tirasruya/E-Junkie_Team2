Feature: Adding E Book To Cart

  Scenario:Successfuly Adding EBook To Cart

    When Navigate the homepage
    Then Find the Add to Cart button and click it
    Then Verify E Book added
    Then Click the Add Promo Code button
    Then Input an invalid promo code
    Then Click the Apply button
    Then Verify the invalid message
