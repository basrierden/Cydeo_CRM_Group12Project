package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActivityStream_Page {

    public ActivityStream_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input#feed-cal-event-namecal_3Jcl")
    public WebElement inputEventName;

    @FindBy(id = "feed-add-post-form-tab-calendar")
    public WebElement eventButton;

    @FindBy(xpath = "//input[@id='event-locationcal_3Jcl']")
    public WebElement selectMeetingRoom;

    @FindBy(id = "bxecmr_2")
    public WebElement westMeetingRoom;

    @FindBy(xpath = "(//tr/td[.='West Meeting Room'])[1]")
    public WebElement meetingRoomProof;

    @FindBy(xpath = "//input[@id='event-full-daycal_3Jcl']")
    public WebElement allDayCheckbox;

    @FindBy(xpath = "//span[@class='feed-ev-tz-open']")
    public WebElement specifyTimeZone;

    @FindBy(xpath = "//input[@id='event-remindercal_3Jcl']")
    public WebElement setReminderCheck;

    @FindBy(xpath = "//select[@id='feed-cal-tz-fromcal_3Jcl']")
    public WebElement selectTimeZone;

    @FindBy(css = "button#blog-submit-button-save")
    public WebElement sendEventBtn;

    @FindBy(xpath = "//a[.='DamirEvent']")
    public WebElement eventProof;

    @FindBy(id = "feed-event-view-from-livefeed3521")
    public WebElement eventDayAndTime;

    // Event will start on:
    @FindBy(xpath = "//input[@id='feed-cal-event-fromcal_3Jcl']")
    public WebElement inputStartDate;

    @FindBy(xpath = "//a[.='23']")
    public WebElement startSpecificDate;

    @FindBy(xpath = "//input[@id='feed_cal_event_from_timecal_3Jcl']")
    public WebElement openStartTime;

    @FindBy(xpath = "(//td[@title='Increase (Up)'])[1]")
    public WebElement startHourUp;

    @FindBy(xpath = "(//td[@title='Decrease (Down)'])[1]")
    public WebElement startHourDown;

    @FindBy(xpath = "(//input[@class='bxc-cus-sel'])[1]")
    public WebElement typeStartHour;

    @FindBy(xpath = "(//input[@class='bxc-cus-sel'])[2]")
    public WebElement typeStartMinute;

    @FindBy(xpath = "(//td[@title='Increase (Up)'])[2]")
    public WebElement startMinuteUp;

    @FindBy(xpath = "(//td[@title='Decrease (Down)'])[2]")
    public WebElement startMinuteDown;

    @FindBy(xpath = "(//span[@class='bxc-am-pm'])[1]")
    public WebElement amPmSwitchButtonStart;

    @FindBy(xpath = "(//input[@value='Set Time'])[1]")
    public WebElement setTimeStart;

    // Event will end on:
    @FindBy(xpath = "//input[@id='feed-cal-event-tocal_3Jcl']")
    public WebElement inputEndDate;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement endDateMonthChoice;

    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement endDateYearChoice;

    @FindBy(xpath = "//span[.='2025']")
    public WebElement endYear2025;

    @FindBy(xpath = "//span[.='June']")
    public WebElement endDateSpecificMonth;

    @FindBy(xpath = "//a[.='27']")
    public WebElement endDateSpecificDay;

    @FindBy(xpath = "//input[@id='feed_cal_event_to_timecal_3Jcl']")
    public WebElement openEndTime;

    @FindBy(xpath = "//td[@title='Increase (Up)']")
    public WebElement endHourUp;

    @FindBy(xpath = "(//td[@title='Increase (Up)'])[2]")
    public WebElement endMinuteUp;

    @FindBy(xpath = "(//span[@class='bxc-am-pm'])[2]")
    public WebElement amPmSwitchButtonEnd;

    @FindBy(xpath = "(//input[@value='Set Time'])[2]")
    public WebElement setTimeEnd;

    // Set Reminder
    @FindBy(id = "event-remind_countcal_3Jcl")
    public WebElement reminderCount;

    @FindBy(xpath = "(//span[@class='calendar-item-date'])[1]")
    public WebElement upcomingEvents;

    @FindBy(xpath = "//div[.='Reminder:']")
    public WebElement reminderLabelProof;

    @FindBy(xpath = "//select[@id='event-remind_typecal_3Jcl']")
    public WebElement minHourDaySelect;

    @FindBy(css = "div#feed-event-dest-cont")
    public WebElement members;

    @FindBy(css = "input#feed-event-dest-input")
    public WebElement membersInputText;

    @FindBy(css = "a#destDepartmentTab_calnAJEM3")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-arrow'])[2]")
    public WebElement eahdgfelrDepartment;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-check-arrow'])[1]")
    public WebElement allDepartmentCheck;

    @FindBy(xpath = "(//a[@class='feed-add-post-destination-new'])[1]")
    public WebElement attendeeProof;










}
