package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStream_Page;
import com.cydeo.crm.pages.Base_Page;
import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class upload_stepDefinitions {
    Login_Page login_page= new Login_Page();
    Base_Page basePage= new Base_Page();
    ActivityStream_Page activityStream_page= new ActivityStream_Page();
    @Given("user logins Activity Stream page with valid credential")
    public void user_logins_activity_stream_page_with_valid_credential() {
        Driver.getDriver().get("https://qa.crmly.net/");
        login_page.inputUsername.sendKeys("helpdesk32@cybertekschool.com");
        login_page.inputPassword2.sendKeys("UserUser");
        login_page.loginButton.click();

    }

    @Given("user clicks Message button")
    public void user_clicks_message_button() {
        activityStream_page.messageBTN.click();
        BrowserUtils.sleep(10);


    }

    @Then("user is on the Message page")
    public void user_is_on_the_message_page() {
        Assert.assertTrue(basePage.messageSendButton.isDisplayed());
       // BrowserUtils.sleep(10);

    }

    @When("user clicks on Upload Files button")
    public void user_clicks_on_upload_files_button() {
        BrowserUtils.sleep(10);
        basePage.messageUploadFileBtn.click();
        BrowserUtils.sleep(10);

    }

    @When("user uploads jpeg file")
    public void user_uploads_png_file() {
        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\JPEG.jpg");
        BrowserUtils.sleep(10);

    }

    @When("user uploads pdf file")
    public void user_uploads_pdf_file() {

        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\PDF fORMAT Document.pdf");
        BrowserUtils.sleep(10);
    }

    @When("user uploads docx file")
    public void user_uploads_docx_file() {
        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\DOCX Document.docx");
        BrowserUtils.sleep(10);
    }

    @Then("user is able to upload files")
    public void user_is_able_to_upload_files() {
        //basePage.messageTitleField.sendKeys("Upload Practice");
        basePage.messageSendButton.click();
        BrowserUtils.sleep(10);
        Assert.assertTrue(basePage.uploadedJpegFile.isDisplayed());
        Assert.assertTrue(basePage.uploadedPDFFile.isDisplayed());
        Assert.assertTrue(basePage.uploadedDocXFile.isDisplayed());
        BrowserUtils.sleep(10);


    }

    @When("user uploads picture")
    public void user_uploads_picture() {
        basePage.messageUploadFileBtn.click();
        BrowserUtils.sleep(10);
        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\JPEG.jpg");
        BrowserUtils.sleep(10);

    }

    @Then("user should display uploaded picture")
    public void user_should_display_uploaded_picture() {

        basePage.messageSendButton.click();
        BrowserUtils.sleep(10);
        Assert.assertTrue(basePage.uploadImageProof.isDisplayed());
        BrowserUtils.sleep(10);

    }

    @When("user inserts file into text")
    public void user_inserts_file_into_text() {
        basePage.messageUploadFileBtn.click();
        BrowserUtils.sleep(10);
        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\DOCX Document.docx");
        BrowserUtils.sleep(10);
        basePage.msgInsertInTextBtn.click();
        BrowserUtils.sleep(10);


    }

    @Then("user sees in text label on button")
    public void user_sees_in_text_label_on_button() {

        String actualText = basePage.msgInTextBtn.getText();
        BrowserUtils.sleep(10);
        String expectedText = "In text";
        Assert.assertEquals(expectedText, actualText);
        BrowserUtils.sleep(10);

    }

    @When("user uploads docx document")
    public void user_uploads_docx_document() {

        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\DOCX Document.docx");
        BrowserUtils.sleep(10);
    }

    @Then("recipient should see Edit button")
    public void recipient_should_see_edit_button() {
        basePage.messageSendButton.click();
        BrowserUtils.sleep(10);
        Assert.assertTrue(basePage.recipientEditBtn.isDisplayed());
        BrowserUtils.sleep(10);


    }

    @When("user uploads any file")
    public void user_uploads_any_file() {

        BrowserUtils.sleep(10);
        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\JPEG.jpg");
        BrowserUtils.sleep(10);

    }

    @When("user clicks on delete upload")
    public void user_clicks_on_delete_upload() {
        BrowserUtils.sleep(10);
        basePage.msgFileDeleteBtn.click();
        BrowserUtils.sleep(10);

    }

    @Then("user removed attachment before sending")
    public void user_removed_attachment_before_sending() {
        BrowserUtils.sleep(10);
        basePage.messageSendButton.click();
        BrowserUtils.sleep(10);
        System.out.println("User removed attachment before sending");


    }


    @When("user uploads any file to send")
    public void user_uploads_any_file_to_send() {
        basePage.messageUploadFileBtn.click();
        BrowserUtils.sleep(10);
        basePage.chooseFilesForMessage.sendKeys("C:\\Users\\kantoor\\Desktop\\PROJECT FILES\\DOCX Document.docx");
        BrowserUtils.sleep(10);

    }

    @When("user click on pen icon to rename")
    public void user_click_on_pen_icon_to_rename() {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(basePage.addedFile).perform();
        BrowserUtils.sleep(10);

        basePage.fileNameEditBtn.click();
        BrowserUtils.sleep(10);
        basePage.inputRename.sendKeys("Renamed file");
        BrowserUtils.sleep(10);

    }

    @When("user send message with renamed file")
    public void user_send_message_with_renamed_file() {
        basePage.messageSendButton.click();BrowserUtils.sleep(10);

    }

    @Then("recipient should receive renamed file")
    public void recipient_should_receive_renamed_file() {
        String actualFileText =basePage.renamedFile.getText();
        Assert.assertTrue(actualFileText.contains("Renamed file"));
        BrowserUtils.sleep(10);

    }

}
