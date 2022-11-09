Feature:
  CRMLYEUG-1476
  User story: As a user, I should be able to use functions on Company Structure under Employee menu.


# AC1. All user types should be able to display company structure.

  Scenario Outline: The user displays company structure.
    Given the user logs in as a "<userType>"
    When the user click on Employees button on the left menu
    Then the user displays company structure

    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |

# AC2. Hr user should be able to add a department from the company structure.

  Scenario: Hr user add a department from the company structure.
    Given the user logs in as a "Human Resource"
    When the user click on Employees button on the left menu
    And the user click on Add Department button
    And the user types Department name
    And the user select supervisor from company
    And the user adds a department
    Then the user sees the added department on the company structure


# AC3. Hr user should be able to select a parent department from the department dropdown.

  Scenario: Hr user selects a parent department from the department dropdown when adding a department.
    Given the user logs in as a "Human Resource"
    When the user click on Employees button on the left menu
    And the user click on Add Department button
    And the user types Department name
    And the user select a parent department from the department dropdown
    And the user adds a department
    Then the user sees the added department under parent department on the company structure

# AC4. Hr user should be able to select a supervisor from "recent", "company" and "search"
  @WIP
  Scenario: Hr user select a supervisor from "recent" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user click on Employees button on the left menu
    And the user click on Add Department button
    And the user types Department name
    And the user select supervisor from recent
    And the user adds a department
    Then the user sees the added department on the company structure

  Scenario: Hr user select a supervisor from "company" when adding a department.

  Scenario: Hr user select a supervisor from "search" when adding a department.
