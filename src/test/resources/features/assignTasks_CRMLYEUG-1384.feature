
@Kadir
Feature: As a user, I should be able to assign tasks under Quick Navigate Menu
  Acceptance Criteria:
  1. HR User should be able to create "High priority" tasks with the mandatory fields.
  2. HR User should be able to assign a task to more than one user (Test with adding 3 users max.)
  3. When a task(s) is(are) created, they can be seen on the count on the homepage under the "MY TASKS" table.
  4. Checklist should be able to be added while creating a task.
  5. Deadline should be able to be added while creating a task.
  6. Time planning function should be able to be used in setting the deadline.


  Background:  User is logged in ang go to tasks module
    Given user goes to login page
    When user enters valid credentials
    And  user click to login button
    And  user should go to main page
    And  user clicks on the tasks button
    Then user clicks on the New Task button on the tasks page top on the right side

  @CRMLYEUG-1466
  Scenario: HR User should be able to create "High priority" tasks with the mandatory fields.
    When user clicks the High priority Checkbox in the top right of the New Task page
    And  user types description into Things to do input
    And  user clicks the Add Task button
    Then orange Flame sign appears next to task name

  @CRMLYEUG-1467
  Scenario: HR User should be able to assign a task to more than one user
    When user types description into Things to do input
    And  user clicks in the Add more button in the input box of Responsible person
    And  user selects more than one person from the list
    Then  user clicks the Add Task button


  @CRMLYEUG-1468
  Scenario: When a task is created it can be seen on the count on the homepage under the my tasks table
    When user goes to the main page
    And  user save the count of the tasks under the My Tasks table
    And  user clicks on the tasks button
    And  user clicks on the New Task button on the tasks page top on the right side
    And  user types description into Things to do input
    And  user clicks the Add Task button
    And  user goes to the main page
    Then get the new number of tasks under the My Tasks table and verify it is different than the saved number


  @CRMLYEUG-1469
  Scenario: Checklist should be able to be added while creating a task.
    When user clicks on the Checklist button
    And  user fills the checklist input field
    Then user clicks the add button and a numbered check list should be displayed

  @CRMLYEUG-1470
  Scenario: Deadline should be able to be added while creating a task.
    When user types description into Things to do input
    And  user clicks in the input box next to the Deadline title
    And  user selects a day from the Calendar
    And  user clicks the select button
    Then user clicks the Add Task button

  @CRMLYEUG-1471
  Scenario: Time planning function should be able to be used in setting the deadline
    When user types description into Things to do input
    And  user selects a day from the Calendar of Start task on menu
    And  user input the duration
    Then  user clicks the Add Task button







