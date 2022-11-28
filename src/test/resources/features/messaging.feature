@CRMLYEUG-1531
Feature: Adding certain features to messages
  User Story: As a user, I should be able to add link, insert video, mention, quote,
  add tag in message.

  User Types: Human Resource, Helpdesk, Marketing

  @CRMLYEUG-1521
  Scenario Outline: Add mentions about department employees
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Add mention" button
    Then only Recent, and Employees and departments are displayed on the page
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1522 @smoke
  Scenario Outline: Attaching a link to the text
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Link" button
    And the user attaches a link to the specified text
    And the user clicks send message button
    Then the link is displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1523 @smoke
  Scenario Outline: Inserting YouTube videos to the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Insert video" button
    And the user inserts YouTube video
    And the user clicks send message button
    Then the inserted YouTube video is displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1524
  Scenario Outline: Inserting Vimeo videos to the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Insert video" button
    And the user inserts Vimeo video
    And the user clicks send message button
    Then the inserted Vimeo video is displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1525 @smoke
  Scenario Outline: Removing a link from the the message before sending
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Link" button
    And the user attaches a link to the specified text
    And the user removes link from the message before sending
    And the user clicks send message button
    Then the link is not displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1526 @smoke
  Scenario Outline: Removing YouTube video from the message before sending
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Insert video" button
    And the user inserts YouTube video
    And the user removes YouTube video before sending message
    And the user clicks send message button
    Then the inserted video is not displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1527
  Scenario Outline: Removing Vimeo video from the message before sending
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Insert video" button
    And the user inserts Vimeo video
    And the user removes Vimeo video before sending message
    And the user clicks send message button
    Then the inserted video is not displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |




  @CRMLYEUG-1528 @smoke
  Scenario Outline: Adding quotes to the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality
    And the user clicks "Quote text" button
    And the user adds quote to the message body
    And the user clicks send message button
    Then the quote is displayed on the message body
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |

  @CRMLYEUG-1529 @smoke
  Scenario Outline: Adding tags to  the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Add tag" button
    And the user add tag and clicks add button
    And the user clicks send message button
    Then the added tag is displayed on the page
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |


  @CRMLYEUG-1530
  Scenario Outline: Removing tags from  the message
    Given the user logs in as a "<userType>"
    And the user clicks Message functionality and writes a message
    And the user clicks "Add tag" button
    And the user add tag and clicks add button
    And the user removes tag before sending message
    And the user clicks send message button
    Then the added tag is not displayed on the page
    Examples:
      | userType             |
      | Human Resource_Hasan |
      | Helpdesk_Hasan       |
      | Marketing_Hasan      |