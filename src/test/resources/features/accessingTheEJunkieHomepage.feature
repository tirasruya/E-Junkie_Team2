Feature: Accessing the E-Junkie Homepage from Shopdemo

  Scenario: Verify access to the E-Junkie homepage from Shopdemo
    When the user clicks the ECommerceByEJunkie link
    And the user clicks the E-Junkie logo on the new page
    Then the user should be redirected to e-junkie.com