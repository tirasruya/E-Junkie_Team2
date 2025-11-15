Feature: Accessing the E-Junkie Homepage from Shopdemo

  Scenario: Verify access to the E-Junkie homepage from Shopdemo
    When the user clicks the "E-Commerce By E-Junkie" link
    And the user clicks the E-Junkie logo on the new page
    Then the user should be redirected to "https://www.e-junkie.com/"