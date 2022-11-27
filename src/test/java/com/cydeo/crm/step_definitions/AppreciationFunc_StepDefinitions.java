package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStream_Page;
import com.cydeo.crm.pages.Base_Page;
import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AppreciationFunc_StepDefinitions {


        Login_Page login_page = new Login_Page();
        ActivityStream_Page activityStream_page = new ActivityStream_Page();
        Base_Page base_page = new Base_Page();

        @Given("user logins Activity Stream page with valid credentials")
        public void user_logins_activity_stream_page_with_valid_credentials() {

            Driver.getDriver().get("https://qa.bleucrm.com/");
            login_page.inputUsername.sendKeys("helpdesk40@cybertekschool.com");
            login_page.inputPassword2.sendKeys("UserUser");
            login_page.loginButton.click();
        }
        @When("user navigates to the Appreciation page")
        public void user_navigates_to_the_appreciation_page() {
            base_page.moreButtonInpage.click();
            base_page.appreciationButton.click();
        }


        @When("user types the message in the message content")
        public void user_types_the_message_in_the_message_content() {
            BrowserUtils.sleep(5);
            // base_page.messageContent.sendKeys("great job");
            Driver.getDriver().switchTo().frame(base_page.iframeMessageContent);
            base_page.messageContent.sendKeys("great job");
            Driver.getDriver().switchTo().parentFrame();
            BrowserUtils.sleep(5);
        }
        @When("user adds recipients")
        public void user_adds_recipients() {
            base_page.addMoreRecipients.click();
            BrowserUtils.sleep(3);
            base_page.addAdmin.click();
            BrowserUtils.sleep(2);
            base_page.closeRecipients.click();
        }
        @When("user clicks send button")
        public void user_clicks_send_button() {
            BrowserUtils.sleep(5);
            base_page.sendButton.click();
            BrowserUtils.sleep(5);
        }
        @Then("the appreciation sent")
        public void the_appreciation_sent() {
            Assert.assertTrue(base_page.sentAppreciation.isDisplayed());

        }




        @When("user doesn't fill the mandatory fields")
        public void userDoesntFillTheMandatoryFields() {
            base_page.allEmployeesDeleteBtn.click();

        }

        @And("user clicks the send button")
        public void userClicksTheSendButton() {
            base_page.sendButton.click();

        }

        @Then("user cannot send an Appreciation and sees the error message")
        public void userCannotSendAnAppreciationAndSeesTheErrorMessage() {
            Assert.assertTrue(base_page.errorMessage.isDisplayed());

        }




        @Then("the delivery is All employees")
        public void the_delivery_is_all_employees() {
            Assert.assertTrue(base_page.allEmployeesbyDefault.isDisplayed());
        }
        @When("user select another employees")
        public void user_select_another_employees() {
            base_page.allEmployeesDeleteBtn.click();
            BrowserUtils.sleep(5);
            base_page.addPersonOrGroupOrDepart.click();
            BrowserUtils.sleep(5);
            base_page.employeesAndDepartment.click();
            BrowserUtils.sleep(5);
            base_page.addAnEmployee.click();
            BrowserUtils.sleep(5);
        }
        @Then("the employees changed")
        public void the_employees_changed() {
            Assert.assertTrue(base_page.addAnEmployee.isDisplayed());
        }



        @When("user clicks the cancel button")
        public void user_clicks_the_cancel_button() {
            base_page.cancelButton.click();
        }
        @Then("sending the appreciation is cancelled before sending")
        public void sending_the_appreciation_is_cancelled_before_sending() {
            System.out.println("the appreciation has been cancelled before sending");
        }



        @When("user select an icon")
        public void user_select_an_icon() {
            BrowserUtils.sleep(3);
            Driver.getDriver().switchTo().frame(base_page.iframeMessageContent);
            base_page.messageContent.sendKeys("great");
            Driver.getDriver().switchTo().parentFrame();
            BrowserUtils.sleep(3);
            base_page.selectAnIconButton.click();
            BrowserUtils.sleep(3);
            base_page.selectMedalGiftIcon.click();
            BrowserUtils.sleep(3);
            base_page.sendButton.click();
            BrowserUtils.sleep(5);
        }
        @Then("icon is selected")
        public void icon_is_selected() {
            String expectedResult = "Medal gift icon";
            String actualResult = "Null";
            Assert.assertEquals(expectedResult, null);
        }

 }



