
Feature:  User should be able to upload files and pictures as messages

  Background:Background:User is on the Event
    Given user logins Activity Stream page with valid credential
    And user clicks Message button
    Then user is on the Message page

@smoke@test
  Scenario:User should be upload max 3 files at same time
    When user clicks on Upload Files button
    And user uploads jpeg file
    And user uploads pdf file
    And user uploads docx file
    Then user is able to upload files


  Scenario: User should be able to display the uploaded picture in Activity Stream.
    When user clicks on Upload Files button
    And user uploads picture
    Then user should display uploaded picture


  Scenario: User should be able to insert the files and images into the text
    When user inserts file into text
    Then user sees in text label on button


  Scenario: User should be able to allow a recipient to edit documents.
    When user clicks on Upload Files button
    And user uploads docx document
    Then recipient should see Edit button


  Scenario: User should be able to remove files and images at any time before sending.
    When user clicks on Upload Files button
    And user uploads any file
    And user clicks on delete upload
    Then user removed attachment before sending


  Scenario: User should be able to rename the file before sending it.
    When user uploads any file to send
    And user click on pen icon to rename
    And user send message with renamed file
    Then recipient should receive renamed file

