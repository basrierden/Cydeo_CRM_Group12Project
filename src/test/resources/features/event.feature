Feature: As a user, I should be able to create events by clicking on Event tab under Activity Stream.
  User Story: CRMLYEUG-1481
  User types: Human Resource, Helpdesk, Marketing


  Scenario Outline: User should be able to add Event start and ending date and time, select "All day" and specify the time zone.
    Given the user logs in as a "<userType>"
    When user clicks on Event button
    And user change date and time for start event
    And user change date and time for end event
    And user specifies time zone
    And user select All day
    And user click on Send button
    Then use should be able to create Event

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

  Scenario Outline: User should be able to set reminder.
    Given the user logs in as a "<userType>"
    When user clicks on Event button
    And user set reminder and send Event
    And user clicks on Upcoming Events
    Then user is able to see Remainder label

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

  @wip_Damir
  Scenario Outline: User should be able to select the event location from the dropdown.
    Given the user logs in as a "<userType>"
    When user clicks on Event button
    And user select location for event
    Then user should see selected location

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |