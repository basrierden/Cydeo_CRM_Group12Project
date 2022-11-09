Feature:
  CRMLYEUG-1476
  User story: As a user, I should be able to use functions on Company Structure under Employee menu.


# AC1. All user types should be able to display company structure.

  Scenario Outline: The user displays company structure.
    Given the user logs in as a "<userType>"
    When the user clicks on Employees button on the left menu
    Then the user displays company structure

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

# AC2. Hr user should be able to add a department from the company structure.

  Scenario: Hr user add a department from the company structure.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from company
    And the user adds a department
    Then the user sees the added department on the company structure


# AC3. Hr user should be able to select a parent department from the department dropdown.

  Scenario: Hr user selects a parent department from the department dropdown when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects a parent department from the department dropdown
    And the user adds a department
    Then the user sees the added department under parent department on the company structure

# AC4. Hr user should be able to select a supervisor from "recent", "company" and "search"

  Scenario: Hr user selects a supervisor from "recent" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from recent
    And the user adds a department
    Then the user sees the added department on the company structure

  Scenario: Hr user selects a supervisor from "company" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from company
    And the user adds a department
    Then the user sees the added department on the company structure


  Scenario: Hr user selects a supervisor from "search" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user searches and selects supervisor "Kara Murat" from search
    And the user adds a department
    Then the user sees the added department on the company structure

#AC5. Hr user should be able to close add department pop-up at any time before sending

  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user clicks on Close button
    Then add department pop-up is closed


  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user clicks on Close button
    Then add department pop-up is closed


  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects a parent department from the department dropdown
    And the user clicks on Close button
    Then add department pop-up is closed


  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from recent
    And the user clicks on Close button
    Then add department pop-up is closed

  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from company
    And the user clicks on Close button
    Then add department pop-up is closed

  @WIP
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user searches and selects supervisor "Kara Murat" from search
    And the user clicks on Close button
    Then add department pop-up is closed