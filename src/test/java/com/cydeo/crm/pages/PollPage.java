package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "(//span[.='Kara Murat'])[2]")
    public WebElement selectedContact;
    public void verifyContact(){
        String actual=selectedContact.getText();
        String expected="Kara Murat";
        Assert.assertEquals(expected, actual);
    }
    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement titleMessage;
    public void typeContentTitle(String titleMessagee){
        Driver.getDriver().switchTo().frame(0);
        titleMessage.sendKeys(titleMessagee);
        Driver.getDriver().switchTo().defaultContent();
    }
    @FindBy(xpath = "//input[@id='question_0']")
    public WebElement inputQuestion;
    @FindBy(xpath = "//input[@id='answer_0__0_']")
    public WebElement inputAnswer1;
    @FindBy(xpath = "//input[@id='answer_0__1_']")
    public WebElement inputAnswer2;
    public void typeInputQuestion(String question){
        inputQuestion.sendKeys(question);
    }
    public void typeInputAnswer1(String answer1){
        inputAnswer1.sendKeys(answer1);
    }
    public void typeInputAnswer2(String answer2){
        inputAnswer2.sendKeys(answer2);
    }
    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;
    public void clickSendButton(){
        sendButton.click();
    }
    public WebElement typingQuestion(String name){
        return Driver.getDriver().findElement(By.xpath("//div[.=\""+name+"\"]"));
    }
    public WebElement typingAnswer1(String name){
        return Driver.getDriver().findElement(By.xpath("//label[.=\""+name+"\"]"));
    }
    public WebElement typingAnswer2(String name){
        return Driver.getDriver().findElement(By.xpath("//label[.=\""+name+"\"]"));
    }
    public void verifyQuestion(String question){
        String expected=question;
        String actual=typingQuestion(question).getText();
        Assert.assertEquals(expected, actual);
    }
    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
    public WebElement messageButton;
    public void clickMessageButton(){
        messageButton.click();
    }
    @FindBy(xpath = "//label[@class='vote-block-close delq']")
    public  WebElement deleteButton;
    public void clickDeleteButtonForQuestion(){
        actions.moveToElement(inputQuestion).perform();
        BrowserUtils.sleep(5);
        deleteButton.click();
    }
    public void clickDeleteButtonForAnswer1(){
        actions.moveToElement(inputAnswer1).perform();
        BrowserUtils.sleep(5);
        deleteButton.click();
    }
    public void clickDeleteButtonForAnswer2(){
        actions.moveToElement(inputAnswer2).perform();
        BrowserUtils.sleep(5);
        deleteButton.click();
    }
    public boolean assertWebElementNotPresent(WebElement webElement) throws Exception{

        try {
            webElement.getText();
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }
    @FindBy(xpath = "//input[@id='multi_2']")
    public WebElement allowMultipleChangesCheckbox;
    public void clickAllowMultipleChangesCheckbox(){
        allowMultipleChangesCheckbox.click();
    }
    public void verifySelectedAllowMultipleChangesCheckbox(){
        Assert.assertTrue(allowMultipleChangesCheckbox.isSelected());
    }





}
