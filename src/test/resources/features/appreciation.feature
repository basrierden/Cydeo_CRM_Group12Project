  @CRMLYEUG-1388
Feature: As a user, I should be able to send appreciation by clicking on Appreciation tab under Active Stream.

  #@CRMLYEUG-1533
  Background:User is on the Appreciation
    Given user logins Activity Stream page with valid credentials
    Then user navigates to the Appreciation page

  @CRMLYEUG-1532
  Scenario:  User should be able to send a appreciation by filling the mandatory fields.
    When user types the message in the message content
    And user adds recipients
    And user clicks send button
    Then the appreciation sent

  @CRMLYEUG-1534
  Scenario: Will user be able to send an Appreciation without filling the mandatory fields
    When user doesn't fill the mandatory fields
    And user clicks the send button
    Then user cannot send an Appreciation and sees the error message

  @CRMLYEUG-1535 @smoke
  Scenario:  The message delivery should be to 'All employees' by default and should be changeable.
   Then the delivery is All employees
    And user select another employees
    Then the employees changed

  @CRMLYEUG-1536 @smoke
  Scenario: User should be able to cancel sending appreciation at any time before sending.
    When user types the message in the message content
    And user adds recipients
    And user clicks the cancel button
    Then sending the appreciation is cancelled before sending

  @CRMLYEUG-1537 @smoke
  Scenario: User should be select an icon.
    When user select an icon
    Then icon is selected