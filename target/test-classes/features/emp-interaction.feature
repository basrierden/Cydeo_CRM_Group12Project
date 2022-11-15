Feature: CRM24 employee interaction feature

  User Story: As a user, I should be able to interact with employees on the posts.

  Accounts are: Human Resource, Helpdesk, and Marketing

  @login
  Scenario Outline:
    Given the user logs in as a "<userType>"
    Examples:
      | userType       |
      | Human Resource |
      | Helpdesk       |
      | Marketing      |


       #CRMLYEUG-1278
  Scenario: Verify user should be able to make a comment to other employees' posts.
    Given the user logs in as a hr
    When user write a "This is a test comment" to any post
    And click send button
    Then "This is a test comment" appear under the post

   #CRMLYEUG-1280

 # Scenario: Verify user should be able to make a like to other employees' posts.
  #  When user click like button any of employees post
  #  Then you was written under the post

    #CRMLYEUG-1281

 # Scenario: Verify user should be able to unfollow other employees' posts.
   # When User click unfollow under any of employee post
   # Then unfollow turns to follow

    #CRMLYEUG-1282
 # Scenario: Verify user should be able to make a like on all other reviewers' comments.
  #  When user click to like of any reviewers comment
   # Then like icon appears next to comment

    #CRMLYEUG-1283

#  Scenario: Verify user should be able to make a comment on all other reviewers' comments.
 #   When user click on reply under the comment of any user
  #  And write something to comment part
  #  And click send button
  #  Then message appears under the post with the name of receiver

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
#    #CRMLYEUG-1286
#  Scenario: Verify after making a comment user should be able to view comment by clicking more
#    When user write a comment to any post
#    And click send button
#    And click more under the comment he/she wrote
#    And click view comment
#    Then user will be directed to new page where post owner name on the header
#
#    #CRMLYEUG-1287
#  Scenario: Verify after making a comment user should be able to copy link by clicking more
#    When user write a comment to any post
#    And click send button
#    And click more under the comment he/she wrote
#    And click copy link
#    Then done icon appears next to copy link and link was copied accordingly
#
#    #CRMLYEUG-1288
#  Scenario: Verify after making a comment user should be able to edit comment by clicking more
#    When user write a comment to any post
#    And click send button
#    And click more under the comment he/she wrote
#    And click edit button
#    And edit the comment
#    And click send button
#    Then previous comment changes to edited one
#
#    #CRMLYEUG-1289
#  Scenario: Verify after making a comment user should be able to delete comment by clicking more
#    When user write a comment to any post
#    And click send button
#    And click more under the comment he/she wrote
#    And click delete button and click OK
#    Then comment deletes and Comment deleted alert appears on the screen
#
#    #CRMLYEUG-1290
#  Scenario:
#    When user write a comment to any post
#    And click send button
#    And click more under the comment he/she wrote
#    And click create task button
#    Then task has been created alert should appear
#    Then task should be created with the comment header
#
#    #CRMLYEUG-1291
#  Scenario: Verify user see the reviewers' name
#    When user go to any post
#    Then reviewers' seen under the post
#
#    #CRMLYEUG-1292
#  Scenario: Verify user visit the reviewers' profile by clicking on their name
#    When user go to any post and click one of reviewer name
#    Then user is on the reviewer profile page
#
#    #CRMLYEUG-1293
#  Scenario: Verify user add others' posts to favorites by clicking on the Star icon
#    When user click star icon on right top of any post
#    And click filter and search input next to activity stream
#    And click favorites
#    Then favorite tag was added to search box and user see only favorite selected posts
#
#    #CRMLYEUG-1295
#  Scenario: Verify after making a comment user should not be able to delete comment by clicking cancel in alert
#    When user write a comment to any post
#    And click send button
#    And click more under the comment he/she wrote
#    And click delete button and click cancel
#    Then comment should not be deleted from post