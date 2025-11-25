Feature: Sending Contact Message

  Scenario: Contact form submission with Recaptcha mismatch
    Given Navigate to the homepage
    When Click on the Contact Us button
    And Fill in the contact form with:
      | name      | email            | subject      | message        |
      | Test User | tester@email.com | Test Subject | This is a test |
    And Click the Send Message button
    Then Verify the warning Recaptcha Mismatch