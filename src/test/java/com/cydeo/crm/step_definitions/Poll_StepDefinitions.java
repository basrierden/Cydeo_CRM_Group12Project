package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.pages.PollPage;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        BrowserUtils.sleep(5);
    }
}
