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


  Scenario: User should be able to select the event location from the dropdown.
    Given the user logs in as a "hr23@cybertekschool.com" and password "UserUser"
    When user clicks on Event button
    And user choose date and time for meeting
    And user select location for event
    Then user should see selected location

  Scenario Outline: User should be able to add individual members.
    Given the user logs in as a "<userType>"
    When user clicks on Event button
    And user click on members field
    And user add Kadir to recipient and send meeting invitation
    Then user should see Kadir is attendee

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

  @bug
  Scenario Outline: User should be able to add departments.
    Given the user logs in as a "<userType>"
    When user clicks on Event button
    And user click on members field
    And user adds eahdgfelr department as attendee and send meeting invitation
    Then user should see attendee proof

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

  @smoke
  Scenario Outline: User should be able to send event by filling the mandatory fields.
    Given the user logs in as a "<userType>"
    When user clicks on Event button
    And user send event invitation named DamirEvent
    Then event should be created with given name

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

  @wip_Damir
  Scenario Outline: User should NOT be able to send event without event name.
    Given the user logs in as a "<userType>"
    When user clicks on Event button without giving event name.
    And user send event invitation without event name.
    Then event should NOT be able to create event.

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |


