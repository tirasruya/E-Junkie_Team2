Feature: Access and play "How It Works" video on E-Junkie homepage

  Background:
    Given the user is on the E-Junkie homepage

  Scenario: Play the "How It Works" video
    When the user clicks the How It Works button
    Then the URL should be e-junkie.com
    And the YouTube video should start playing
    And the video window should close after 10 seconds
