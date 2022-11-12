Feature: CRM24 employee interaction feature

  User Story: As a user, I should be able to interact with employees on the posts.

  Accounts are: Human Resource, Helpdesk, and Marketing




       #CRMLYEUG-1278

  Scenario Outline: Verify user should be able to make a comment to other employees' posts.
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    Then "This is a test comment" appear under the post
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |


   #CRMLYEUG-1280
  Scenario Outline: Verify user should be able to make a like to other employees' posts.
    Given the user logs in as a "<userType>"
    When user click like button any of employees post
    Then you was written under the post
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

    #CRMLYEUG-1281
  Scenario Outline: Verify user should be able to unfollow other employees' posts.
    Given the user logs in as a "<userType>"
    When User click unfollow under any of employee post
    Then unfollow turns to follow
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

    #CRMLYEUG-1282
  Scenario Outline: Verify user should be able to make a like on all other reviewers' comments.
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And user click to like of that comment
    Then like icon appears next to comment
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

    #CRMLYEUG-1283

  Scenario Outline: Verify user should be able to make a comment on all other reviewers' comments.
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And user click on reply under the comment
    And write something to comment part
    And click send button
    Then message appears under the post with the name of receiver
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

#    #CRMLYEUG-1284
#  Scenario: Verify user should be able to like his/her comment
#    When user write a comment to any post
#    And click like button of his/her comment
#    Then Like icon appears next to comment
#
#    #CRMLYEUG-1285
#  Scenario: Verify user should be able to replay his/her comment
#    When user write a comment to any post
#    And click reply button under his/her own comment
#    And write something in comment part
#    And click send button
#    Then comment appear under the post
#

    #CRMLYEUG-1286
  Scenario Outline: Verify after making a comment user should be able to view comment by clicking more
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And click more under the comment was written
    And click view comment
    Then user will be directed to new page where page title is Conversations
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

    #CRMLYEUG-1287
  Scenario Outline: Verify after making a comment user should be able to copy link by clicking more
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And click more under the comment was written
    And click copy link
    Then done icon appears next to copy link and link was copied accordingly
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |


#    #CRMLYEUG-1288
  Scenario Outline: Verify after making a comment user should be able to edit comment by clicking more
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And click more under the comment was written
    And click edit button
    And write "text was edited" the comment
    And click send button
    Then updated comment contains to "text was edited"
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

#    #CRMLYEUG-1289
  Scenario Outline: Verify after making a comment user should be able to delete comment by clicking more
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And click more under the comment was written
    And click delete button and click OK
    Then comment deletes and Comment deleted alert appears on the screen
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

#    #CRMLYEUG-1290
  Scenario Outline: Verify after making a comment user should be able to create task by clicking more.
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And click more under the comment was written
    And click create task button
    Then "task has been created" alert should appear
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

#    #CRMLYEUG-1291
  Scenario Outline: Verify user see the reviewers' name
    Given the user logs in as a "<userType>"
    When user go to any post
    Then reviewers' seen under the post
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

#    #CRMLYEUG-1292
  Scenario Outline: Verify user visit the reviewers' profile by clicking on their name
    Given the user logs in as a "<userType>"
    When user go to any post and click one of reviewer name
    Then user is on the reviewer profile page
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

#    #CRMLYEUG-1293
  Scenario Outline: Verify user add others' posts to favorites by clicking on the Star icon
    Given the user logs in as a "<userType>"
    When user click star icon on right top of any post
    And click filter and search input next to activity stream
    And click favorites
    Then favorite tag was added to search box and user see only favorite selected posts
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |

   #CRMLYEUG-1295
  Scenario Outline: Verify after making a comment user should not be able to delete comment by clicking cancel in alert
    Given the user logs in as a "<userType>"
    When user write a "This is a test comment" to post
    And click send button
    And click more under the comment was written
    And click delete button and click cancel
    Then "This is a test comment" should not be deleted from post
    Examples:
      | userType             |
      | Human Resource_kenan |
      | Helpdesk_kenan       |
      | Marketing_kenan      |