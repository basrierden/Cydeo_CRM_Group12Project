package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.pages.PollPage;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Poll_StepDefinitions {
    Login_Page loginPage=new Login_Page();
    PollPage pollPage=new PollPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    @Given("user logs in as {string}")
    public void user_logs_in_as(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
        loginPage.loginAs(string);

    }
    @When("user adds users by selecting contacts")
    public void user_adds_users_by_selecting_contacts() throws InterruptedException {
        //wait.until(ExpectedConditions.titleContains("Portal"));
        pollPage.clickPollButton();
        pollPage.clickAddMoreButton();
        BrowserUtils.sleep(5);
        pollPage.clickDepartmentAndEmployee();
        BrowserUtils.sleep(5);
        pollPage.selectContact();
        BrowserUtils.sleep(5);
        pollPage.clickPopupClose();
        //pollPage.clickTitleMessage();
        BrowserUtils.sleep(5);
    }
    @Then("user see added these contacts in the poll list")
    public void user_see_added_these_contacts_in_the_poll_list() {
        pollPage. verifyContact();
    }
    @When("user type {string} as a question")
    public void user_type_as_a_question(String string) {
        pollPage.clickPollButton();
        pollPage.typeInputQuestion(string);

    }
    @And("user type {string} and {string} as answers")
    public void user_type_and_as_answers(String string, String string2) {
       pollPage.typeInputAnswer1(string);
       pollPage.typeInputAnswer2(string2);
    }
    @When("user type {string} as a message title")
    public void userTypeAsAMessageTitle(String arg0) {
        pollPage.typeContentTitle(arg0);
        BrowserUtils.sleep(5);
    }
    @Then("user should see the question {string} and answers {string} and {string} in the poll page")
    public void userShouldSeeTheQuestionAndAnswersAndInThePollPage(String arg0, String arg1, String arg2) {
        pollPage.clickSendButton();
        //pollPage.clickMessageButton();
        BrowserUtils.sleep(5);
        pollPage.verifyQuestion(arg0);
        pollPage.typingAnswer1(arg1);
        pollPage.typingAnswer2(arg2);
    }
    @Then("user should delete these questions and answers by clicking delete button")
    public void userShouldDeleteTheseQuestionsAndAnswersByClickingDeleteButton() throws Exception {
        pollPage.clickDeleteButtonForQuestion();
        BrowserUtils.sleep(5);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
        Assert.assertTrue(pollPage.assertWebElementNotPresent(pollPage.inputQuestion));
        Assert.assertTrue(pollPage.assertWebElementNotPresent(pollPage.inputAnswer1));
        Assert.assertTrue(pollPage.assertWebElementNotPresent(pollPage.inputAnswer2));
    }

    @And("user select Allow multiple choice checkbox")
    public void userSelectAllowMultipleChoiceCheckbox() {
        
    }

    @Then("user should see selected Allow multiple choice checkbox in the poll")
    public void userShouldSeeSelectedAllowMultipleChoiceCheckboxInThePoll() {
    }
}
