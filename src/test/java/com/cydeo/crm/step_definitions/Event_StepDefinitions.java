package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStream_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class Event_StepDefinitions {

    ActivityStream_Page activityStreamPage = new ActivityStream_Page();


    @When("user clicks on Event button")
    public void user_clicks_on_event_button() {
        activityStreamPage.eventButton.click();
        BrowserUtils.sleep(5);
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
        BrowserUtils.sleep(3);
        activityStreamPage.upcomingEvents.click();
        BrowserUtils.sleep(5);
    }
    @Then("user is able to see Remainder label")
    public void user_is_able_to_see_remainder_label() {
        Assert.assertTrue(activityStreamPage.reminderLabelProof.isDisplayed());
    }

    @When("user select location for event")
    public void user_select_location_for_event() {
        activityStreamPage.selectMeetingRoom.click();
        activityStreamPage.westMeetingRoom.click();
        BrowserUtils.sleep(2);
        activityStreamPage.sendEventBtn.click();

        // Anything

    }
    @Then("user should see selected location")
    public void user_should_see_selected_location() {
        BrowserUtils.sleep(3);
        Assert.assertEquals("West Meeting Room", activityStreamPage.meetingRoomProof.getText());
    }




}
