@CRMLYEUG-1478
Feature: I should be able to create a poll by clicking on Poll tab under Active Stream.
  User Story:US07_As a user, I should be able to create a poll by clicking on Poll tab under Active Stream.

  #--------------------------------A.C->1---------------------------------------
  @Wip
  Scenario Outline: User should be able to add users by selecting multiple contacts from Employees and Department's contact lists.
    Given user logs in as "<userType>"
    When user adds users by selecting contacts
    Then user see added these contacts in the poll list
    Examples:
    |userType|
    | Human Resource |
    | Helpdesk       |
    | Marketing      |
  #--------------------------------A.C->2---------------------------------------
  Scenario Outline:  User should be able to add questions and multiple answers.
    Given user logs in as "<userType>"
    When user type "First question" as a question
    And user type "First answer" and "Second answer" as answers
    And user type "First message title" as a message title
    Then user should see the questions and answers in the poll page
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
  #--------------------------------A.C->3---------------------------------------
  Scenario Outline: User should be able to delete questions and multiple answers.
    Given user logs in as "<userType>"
    When user type "Second question" as a question
    And user type "Second answer" and "Third answer" as answers
    Then user should delete these questions and answers by clicking delete button
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
  #--------------------------------A.C->4---------------------------------------
  Scenario Outline: User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
    Given user logs in as "<userType>"
    When user adds users by selecting contacts
    And user type "First question" as a question
    And user type "First answer" and "Second answer" as answers
    And user type "First message title" as a message title
    And user select Allow multiple choice checkbox
    And user click send button
    Then user should see multiple choice in the poll

    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|

  #--------------------------------A.C->5---------------------------------------
  Scenario Outline: User should be able to create a poll with mandatory fields.
    Given user logs in as "<userType>"
    When user adds users by selecting contacts
    And user type "First question" as a question
    And user type "First answer" and "Second answer" as answers
    And user type "First message title" as a message title
    Then user should create a poll
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|

  Scenario Outline: User should be able to see an error message without a message title after clicking the sent button
    Given user logs in as "<userType>"
    When user adds users by selecting contacts
    And user type "First question" as a question
    And user type "First answer" and "Second answer" as answers
    Then user should see "The message title is not specified" as an error message after clicking the sent button
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
  Scenario Outline: User should be able to see an error message without contacts after clicking the sent button
    Given user logs in as "<userType>"
    When user type "First message title" as a message title
    And user type "First question" as a question
    And user type "First answer" and "Second answer" as answers
    Then user should see "Please specify at least one person." as an error message after clicking the sent button
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
  Scenario Outline: User should be able to see an error message without a question text after clicking the sent button
    Given user logs in as "<userType>"
    When user type "First message title" as a message title
    And user adds users by selecting contacts
    And user type "First answer" and "Second answer" as answers
    Then user should see "The question text is not specified." as an error message after clicking the sent button
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
  Scenario Outline: User should be able to see an error message without an answer after clicking the sent button
    Given user logs in as "<userType>"
    When user type "First message title" as a message title
    And user adds users by selecting contacts
    And user type "First question" as a question
    And user type "First answer" as answers
    Then user should see "Please specify at least two answers." as an error message after clicking the sent button
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
  Scenario Outline: User should be able to see an error message without two answer after clicking the sent button
    Given user logs in as "<userType>"
    When user type "First message title" as a message title
    And user adds users by selecting contacts
    And user type "First question" as a question
    Then user should see "The question "........." has no answers." as an error message after clicking the sent button
    Examples:
      |userType|
      |Helpdesk|
      |Human Resource|
      |Marketing|
