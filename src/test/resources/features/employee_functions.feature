@CRMLYEUG-1476
Feature: User should be able to use functions on Company Structure under Employee menu.

  User story: As a user, I should be able to use functions on Company Structure under Employee menu..


# AC1. All user types should be able to display company structure.
  @smoke @CRMLYEUG-1482
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
  @CRMLYEUG-1483
  Scenario: Hr user adds a department from the company structure.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user adds a department
    Then the user sees the added department on the company structure
    And the added department is deleted

  @CRMLYEUG-1484
  Scenario: Department cannot be added without department name
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user leaves Department name empty
    And the user adds a department
    Then the user sees the error message


# AC3. Hr user should be able to select a parent department from the department dropdown.
  @CRMLYEUG-1485
  Scenario: Hr user selects a parent department from the department dropdown when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user adds a department
    And the user clicks on Add Department button
    And the user types child Department name
    And the user selects a parent department from the department dropdown
    And the user adds a department
    Then the user sees the added department under parent department on the company structure
    And the added child department is deleted
    And the added department is deleted


# AC4. Hr user should be able to select a supervisor from "recent", "company" and "search"
  @CRMLYEUG-1486
  Scenario: Hr user selects a supervisor from "recent" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from recent
    And the user adds a department
    Then the user sees the added department on the company structure
    And the added department is deleted

  @CRMLYEUG-1487
  Scenario: Hr user selects a supervisor from "company" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from company
    And the user adds a department
    Then the user sees the added department on the company structure
    And the added department is deleted

  @CRMLYEUG-1488
  Scenario: Hr user selects a supervisor from "search" when adding a department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user searches and selects supervisor "Arben Istrefi" from search
    And the user adds a department
    Then the user sees the added department on the company structure
    And the added department is deleted


#AC5. Hr user should be able to close add department pop-up at any time before sending
  @CRMLYEUG-1489
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user clicks on Close button
    Then add department pop-up is closed

  @CRMLYEUG-1490
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user clicks on Close button
    Then add department pop-up is closed

  @CRMLYEUG-1491
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects a parent department Cyber Vet from the department dropdown
    And the user clicks on Close button
    Then add department pop-up is closed

  @CRMLYEUG-1492
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from recent
    And the user clicks on Close button
    Then add department pop-up is closed

  @CRMLYEUG-1493
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user selects supervisor from company
    And the user clicks on Close button
    Then add department pop-up is closed

  @CRMLYEUG-1494
  Scenario: Hr user can close add department pop-up at any time before sending
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user searches and selects supervisor "Arben Istrefi" from search
    And the user clicks on Close button
    Then add department pop-up is closed


#AC6. Hr user should be able to edit departments, add child departments, and delete departments after adding the department.
  @CRMLYEUG-1495
  Scenario: Hr user can edit departments after adding the department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user adds a department
    And the user edits the department
    Then the department is edited
    And the edited department is deleted

  @CRMLYEUG-1496
  Scenario: Hr user can add child departments after adding the department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user adds a department
    And the user adds child department
    Then the user sees the added department under parent department on the company structure
    And the added child department is deleted
    And the added department is deleted


  @CRMLYEUG-1497
  Scenario: Hr user can delete departments after adding the department.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user adds a department
    And the user deletes the department
    Then the department is deleted


#AC7. Hr user should be able to drag and drop the existing department under another department as a subdepartment.
  @CRMLYEUG-1498
  Scenario: Hr user can drag and drop the existing department under another department as a subdepartment.
    Given the user logs in as a "Human Resource"
    When the user clicks on Employees button on the left menu
    And the user clicks on Add Department button
    And the user types Department name
    And the user adds a department
    And the user clicks on Add Department button
    And the user types second Department name
    And the user adds a department
    And the user drag and drop the first department under second department as a subdepartment
    Then the user sees the added department under parent department on the company structure
    And the added child department is deleted
    And the added department is deleted


#AC8. Helpdesk and marketing users can not change company structure.
  @CRMLYEUG-1499
  Scenario Outline: Helpdesk and marketing users can not change company structure.
    Given the user logs in as a "<userType>"
    When the user clicks on Employees button on the left menu
    Then the user cannot see Add Department button
    Examples:
      | userType  |
      | Helpdesk  |
      | Marketing |