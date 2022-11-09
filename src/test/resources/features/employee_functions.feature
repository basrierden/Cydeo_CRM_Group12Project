

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
  @WIP
  Scenario: Hr user add a department from the company structure.
    Given the user logs in as a "Human Resource"
    When the user click on Employees button on the left menu
    And the user click on Add Department button and fills out fields
    Then the user adds a department

    
