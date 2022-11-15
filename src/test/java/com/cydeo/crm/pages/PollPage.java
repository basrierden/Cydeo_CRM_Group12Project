package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollPage {
    Actions actions = new Actions(Driver.getDriver());
    public PollPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "feed-add-post-form-tab-vote")
    public WebElement pollButton;
    public void clickPollButton(){
        pollButton.click();
    }
    @FindBy(id = "bx-destination-tag")
    public WebElement addMoreButton;
    public void clickAddMoreButton(){
        addMoreButton.click();
    }
    @FindBy(xpath = "//a[.='Employees and departments']")
    public WebElement departmentAndEmployees;
    public void clickDepartmentAndEmployee(){
        departmentAndEmployees.click();
    }
    @FindBy(xpath = "(//div[.='Kara Murat'])[3]")
    public WebElement contact;
    public void selectContact(){
        contact.click();
    }
    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement popupClose;
    public void clickPopupClose(){
        popupClose.click();
    }
    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement titleMessage;
    public void clickTitleMessage(){
        Driver.getDriver().switchTo().frame(0);
        titleMessage.click();
    }
    @FindBy(xpath = "(//span[.='Kara Murat'])[2]")
    public WebElement selectedContact;
    public void verifyContact(){
        String actual=selectedContact.getText();
        String expected="Kara Murat";
        Assert.assertEquals(expected, actual);
    }
}
