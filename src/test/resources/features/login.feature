Feature: CRM24 app login feature
User Story:
As a user, I should be able to login; so that I can land on homepage

Accounts are: Human Resource, Helpdesk, and Marketing

  @login
Scenario Outline:
  Given the user logs in as a "<userType>"
  Examples:
    | userType       |
    | Human Resource |
    | Helpdesk       |
    | Marketing      |