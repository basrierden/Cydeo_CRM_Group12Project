Feature: Adding certain features to messages
  User Story: As a user, I should be able to add link, insert video, mention, quote,
  add tag in message.

  User Types: Human Resource, Helpdesk, Marketing


  Scenario Outline: Add mentions about department employees
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Add mention" button
    Then only Recent, and Employees and departments are displayed on the page
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |


  Scenario Outline: Attaching a link to the text
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Link" button
    And the user attaches a link to the specified text
    Then the link is displayed on the message body
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |



  Scenario Outline: Inserting YouTube videos to the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Insert video" button
    And the user inserts YouTube video
    Then the inserted video is displayed on the message body
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |


  Scenario Outline: Inserting Vimeo videos to the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Insert video" button
    And the user inserts Vimeo video
    Then the inserted video is displayed on the message body
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |



  @wip
  Scenario Outline: Removing a link from the the message before sending
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Link" button
    And the user attaches a link to the specified text
    And the user removes link from the message before sending
    Then the link is not displayed on the message body
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |


  Scenario Outline: Adding quotes to the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Quote text" button
    And the user adds quote to the message body
    Then the quote is displayed on the message body
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |


  Scenario Outline: Adding tags to  the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Add tag" button
    And the user add tag and clicks add button
    Then the added tag is displayed on the page
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |



  Scenario Outline: Removing tags from  the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Add tag" button
    And the user add tag and clicks add button
    And the user removes tag before sending message
    Then the added tag is not displayed on the page
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |