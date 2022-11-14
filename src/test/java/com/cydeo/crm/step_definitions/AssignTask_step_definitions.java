package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.LoginPageKdr;
import com.cydeo.crm.pages.MainPageKdr;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import java.util.UUID;

public class AssignTask_step_definitions {

    LoginPageKdr loginPage = new LoginPageKdr();
    MainPageKdr mainPage = new MainPageKdr();

    String TaskName;
    String TaskCount;

    @Given("user goes to login page")
    public void user_goes_to_login_page() {

        String url= ConfigurationReader.getProperty("crm.url");
        Driver.getDriver().get(url);

    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.emailInput.sendKeys("hr1@cybertekschool.com");
        loginPage.passwordInput.sendKeys("UserUser");

    }
    @When("user click to login button")
    public void user_click_to_login_button() {
        loginPage.loginButton.click();

    }
    @When("user should go to main page")
    public void user_should_go_to_main_page() {
        String Url = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("https://qa.crmly.net/stream/?login=yes",Url);

    }
    @When("user clicks on the tasks button")
    public void user_clicks_on_the_tasks_button() {

        mainPage.tasksButton.click();
    }
    @Then("user clicks on the New Task button on the tasks page top on the right side")
    public void user_clicks_on_the_new_task_button_on_the_tasks_page_top_on_the_right_side() {
        mainPage.newTaskButton.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']")));


    }
    @When("user clicks the High priority Checkbox in the top right of the New Task page")
    public void user_clicks_the_high_priority_checkbox_in_the_top_right_of_the_new_task_page() {
        mainPage.highPriorityCheckbox.click();


    }
    @When("user types description into Things to do input")
    public void user_types_description_into_things_to_do_input() {
        TaskName= UUID.randomUUID().toString();
        mainPage.inputBox.sendKeys(TaskName+"  is a random Task Name for KADiR");
    }
    @And("user clicks the Add Task button")
    public void user_clicks_the_add_task_button() throws InterruptedException {
        mainPage.addTaskButton.click();
        Thread.sleep(3000);

    }

    @Then("orange Flame sign appears next to task name")
    public void orange_Flame_sign_appears_next_to_task_name() throws InterruptedException {
        Driver.getDriver().switchTo().parentFrame();

        // Verify the related high priority flame sign is displayed

        Assert.assertTrue(mainPage.highPriorityFlame(TaskName+"  is a random Task Name for KADiR").isDisplayed());
        Thread.sleep(3000);

        //Assert.assertTrue(mainPage.flameSign.isDisplayed());
    }


    @When("user clicks in the Add more button in the input box of Responsible person")
    public void user_clicks_in_the_add_more_button_in_the_input_box_of_responsible_person() {
        mainPage.addMoreButton.click();
    }
    @When("user selects more than one person from the list")
    public void user_selects_more_than_one_person_from_the_list() throws InterruptedException {
        mainPage.firstPerson.click();
        Thread.sleep(3000);


    }
    @When("user goes to the main page")
    public void user_goes_to_the_main_page() {
        Driver.getDriver().switchTo().parentFrame();
        try {
            mainPage.closeNewTask.click();
        } catch (ElementNotInteractableException e){
            mainPage.homePageLogo.click();
        }
        mainPage.homePageLogo.click();

    }
    @When("user save the count of the tasks under the My Tasks table")
    public void user_save_the_count_of_the_tasks_under_the_my_tasks_table() {
        TaskCount=mainPage.counter.getText();
        System.out.println("TaskCount = " + TaskCount);


    }


    @Then("get the new number of tasks under the My Tasks table and verify it is different than the saved number")
    public void get_the_new_number_of_tasks_under_the_my_tasks_table_and_verify_it_is_different_than_the_saved_number() {
        String lastCount =mainPage.counter.getText();
        System.out.println("lastCount = " + lastCount);
        Assert.assertNotEquals(TaskCount,lastCount);
    }


    @When("user clicks on the Checklist button")
    public void user_clicks_on_the_checklist_button_and_user_should_see_opens_a_field_with_the_title_checklist() {
        mainPage.checkListButton.click();
    }
    @When("user fills the checklist input field")
    public void user_fills_the_checklist_input_field() throws InterruptedException {
        mainPage.checklistField.sendKeys("High quality testing is a necessity");
        Thread.sleep(3000);
    }
    @Then("user clicks the add button and a numbered check list should be displayed")
    public void user_clicks_the_add_button_and_a_numbered_check_list_should_be_displayed() {
        mainPage.checklistAddButton.click();
        Assert.assertTrue(mainPage.checklistAddedTask.isDisplayed());

    }

    @When("user clicks in the input box next to the Deadline title")
    public void user_clicks_in_the_input_box_next_to_the_deadline_title() {
        mainPage.dateInputBox.click();
    }
    @When("user selects a day from the Calendar")
    public void user_selects_a_day_from_the_calendar() {
        mainPage.dayDate.click();

    }
    @When("user clicks the select button")
    public void user_clicks_the_select_button() {
        mainPage.dateSelectButton.click();
    }


    @When("user selects a day from the Calendar of Start task on menu")
    public void user_selects_a_day_from_the_calendar_of_start_task_on_menu() {
        mainPage.startTaskBox.click();
        mainPage.daySelect.click();

    }
    @When("user input the duration")
    public void user_input_the_duration() throws InterruptedException {
        mainPage.durationInput.sendKeys("4");
        Thread.sleep(3000);

    }


}
