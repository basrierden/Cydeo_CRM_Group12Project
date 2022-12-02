package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStream_Page;
import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Event_StepDefinitions {

    ActivityStream_Page activityStreamPage = new ActivityStream_Page();
    Login_Page loginPage = new Login_Page();


    @When("user clicks on Event button")
    public void user_clicks_on_event_button() {
        activityStreamPage.eventButton.click();
        BrowserUtils.sleep(3);
        activityStreamPage.inputEventName.sendKeys("DamirEvent");
        BrowserUtils.sleep(2);
    }
    @When("user change date and time for start event")
    public void user_change_date_and_time_for_start_event() {

        // Start date and time
        activityStreamPage.inputStartDate.click();
        BrowserUtils.sleep(2);
        activityStreamPage.startSpecificDate.click();
        BrowserUtils.sleep(2);
        activityStreamPage.openStartTime.click();
        BrowserUtils.sleep(2);
        activityStreamPage.startHourDown.click();
        BrowserUtils.sleep(2);
        activityStreamPage.startHourUp.click();
        BrowserUtils.sleep(2);
        activityStreamPage.startMinuteUp.click();
        BrowserUtils.sleep(2);
        activityStreamPage.amPmSwitchButtonStart.click();
        BrowserUtils.sleep(2);
        activityStreamPage.setTimeStart.click();

    }
    @When("user change date and time for end event")
    public void user_change_date_and_time_for_end_event() {

        // End date and time
        BrowserUtils.sleep(2);
        activityStreamPage.inputEndDate.click();
        BrowserUtils.sleep(2);
        activityStreamPage.endDateMonthChoice.click();
        BrowserUtils.sleep(2);
        activityStreamPage.endDateSpecificMonth.click();
        BrowserUtils.sleep(2);
        activityStreamPage.endDateYearChoice.click();
        BrowserUtils.sleep(2);
        activityStreamPage.endYear2025.click();
        BrowserUtils.sleep(2);
        activityStreamPage.endDateSpecificDay.click();
    }
    @When("user specifies time zone")
    public void user_specifies_time_zone() {

        // Time zone
        BrowserUtils.sleep(2);
        activityStreamPage.specifyTimeZone.click();
        BrowserUtils.sleep(2);
        Select selectZone = new Select(activityStreamPage.selectTimeZone);
        selectZone.selectByValue("America/New_York");
        BrowserUtils.sleep(2);
    }
    @When("user select All day")
    public void user_select_all_day() {

        // All day
        activityStreamPage.allDayCheckbox.click();
        BrowserUtils.sleep(2);
    }
    @When("user click on Send button")
    public void user_click_on_send_button() {
        activityStreamPage.setReminderCheck.click();
        BrowserUtils.sleep(2);
        activityStreamPage.sendEventBtn.click();
    }
    @Then("use should be able to create Event")
    public void use_should_be_able_to_create_event() {
        BrowserUtils.sleep(3);
        Assert.assertTrue(activityStreamPage.eventProof.isDisplayed());
    }

    @When("user set reminder and send Event")
    public void user_set_reminder_and_send_event() {
        activityStreamPage.reminderCount.clear();
        BrowserUtils.sleep(2);
        activityStreamPage.reminderCount.sendKeys("2");
        BrowserUtils.sleep(2);
        Select selectMinHourDay = new Select(activityStreamPage.minHourDaySelect);
        BrowserUtils.sleep(2);
        selectMinHourDay.selectByValue("day");
        BrowserUtils.sleep(2);
        activityStreamPage.sendEventBtn.click();
    }
    @When("user clicks on Upcoming Events")
    public void user_clicks_on_upcoming_events() {
        BrowserUtils.sleep(2);
        activityStreamPage.upcomingEvents.click();
        BrowserUtils.sleep(5);
    }
    @Then("user is able to see Reminder label")
    public void user_is_able_to_see_reminder_label() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(activityStreamPage.reminderLabelProof.isDisplayed());
    }

    @When("user select location for event")
    public void user_select_location_for_event() {
        activityStreamPage.selectMeetingRoom.click();
        activityStreamPage.westMeetingRoom.click();
        BrowserUtils.sleep(2);
        activityStreamPage.sendEventBtn.click();

        // Anything now
        // New change

    }

    @Given("the user logs in as a {string} and password {string}")
    public void the_user_logs_in_as_a_and_password(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.loginButton.click();
    }
    @When("user choose date and time for meeting")
    public void user_choose_date_and_time_for_meeting() {
        BrowserUtils.sleep(3);
        activityStreamPage.allDayCheckbox.click();
    }

    @Then("user should see selected location")
    public void user_should_see_selected_location() {
        BrowserUtils.sleep(3);
        Assert.assertEquals("West Meeting Room", activityStreamPage.meetingRoomProof.getText());
    }

    @When("user click on members field")
    public void user_click_on_members_field() {
        activityStreamPage.members.click();
        BrowserUtils.sleep(1);
    }
    @When("user add Kadir to recipient and send meeting invitation")
    public void user_add_kadir_to_recipient_and_send_meeting_invitation() {
        activityStreamPage.membersInputText.sendKeys("Kadir", Keys.ENTER);
        activityStreamPage.sendEventBtn.click();
    }
    @Then("user should see Kadir is attendee")
    public void user_should_see_kadir_is_attendee() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(activityStreamPage.attendeeProof.isDisplayed());
    }

    @When("user adds department as attendee and send meeting invitation")
    public void user_adds_department_as_attendee_and_send_meeting_invitation() {
        activityStreamPage.employeesAndDepartments.click();
        activityStreamPage.eahdgfelrDepartment.click();
        activityStreamPage.allDepartmentCheck.click();
        activityStreamPage.sendEventBtn.click();
    }
    @Then("user should see attendee proof")
    public void user_should_see_attendee_proof() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(activityStreamPage.attendeeProof.isDisplayed());
    }
    @When("user send event invitation named DamirEvent")
    public void user_send_event_invitation_named_DamirEvent() {
        activityStreamPage.sendEventBtn.click();
        BrowserUtils.sleep(2);
    }
    @Then("event should be created with given name")
    public void event_should_be_created_with_given_name() {
        Assert.assertEquals("DamirEvent", activityStreamPage.eventProof.getText());
    }

    @When("user clicks on Event button without giving event name.")
    public void user_clicks_on_event_button_without_giving_event_name() {
        activityStreamPage.eventButton.click();
        BrowserUtils.sleep(3);
    }
    @When("user send event invitation without event name.")
    public void user_send_event_invitation_without_event_name() {
        activityStreamPage.sendEventBtn.click();
    }
    @Then("event should NOT be able to create event.")
    public void event_should_not_be_able_to_create_event() {
        BrowserUtils.sleep(3);
        Assert.assertFalse(activityStreamPage.eventNoNameProof.isDisplayed());
    }

    @When("user clicks on cancel event button")
    public void user_clicks_on_cancel_event_button() {
        BrowserUtils.sleep(2);
        activityStreamPage.cancelEventBtn.click();
    }
    @Then("user should see Send Message label")
    public void user_should_see_send_message_label() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(activityStreamPage.sendMessageTitle.isDisplayed());
    }



}
