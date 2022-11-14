package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageKdr {
    public MainPageKdr(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//*[@id='bx_left_menu_menu_tasks']/a/span[1]")
    public WebElement tasksButton;

    @FindBy (id="tasks-buttonAdd")
    public WebElement newTaskButton;

    @FindBy (id="tasks-task-priority-cb")
    public  WebElement highPriorityCheckbox;

    @FindBy (xpath="//input[@data-bx-id='task-edit-title']")
    public WebElement inputBox;

    @FindBy(xpath="//button[@class='ui-btn ui-btn-success']")
    public WebElement addTaskButton;


    // We find the related flame sign which is sibling element of the tas name
    // that is created randomly with  UUID method in  Java
    public WebElement highPriorityFlame(String taskName){
        return Driver.getDriver().findElement(By.xpath("//a[.='"+taskName+"']/../span"));
    }

    @FindBy(xpath="//span[@class='task-form-field-controls']/a")
    public WebElement addMoreButton;

    @FindBy(xpath="//span[@class='bx-finder-groupbox-content']/a")
    public WebElement firstPerson;

    @FindBy (className = "side-panel-close-inner")
    public WebElement closeNewTask;

    @FindBy (id="logo_24_text")
    public WebElement homePageLogo;

    @FindBy(xpath="//span [@class='task-item-index']")
    public WebElement counter;

    @FindBy(className = "tasks-task-mpf-link")
    public WebElement checkListButton;

    @FindBy (xpath ="//input[@maxlength='255']")
    public WebElement checklistField;

    @FindBy (xpath="// span[@class='js-id-checklist-is-open-form task-dashed-link-inner']")
    public  WebElement checklistAddButton;

    @FindBy (xpath="//span[@class='js-id-checklist-is-i-title ']")
    public WebElement checklistAddedTask;

    @FindBy (xpath="//input[@data-bx-id='datepicker-display']")
    public WebElement dateInputBox;

    @FindBy (xpath="//a[@class='bx-calendar-cell bx-calendar-date-hidden']")
    public WebElement dayDate;

    @FindBy (xpath="//span[@class='bx-calendar-button-text']")
    public WebElement dateSelectButton;

    @FindBy (xpath="(//input[@class='task-options-inp'])[2]")
    public WebElement startTaskBox;

    @FindBy (xpath="//span[.='Select']")
    public WebElement daySelect;

    @FindBy(xpath="(//input[@class='task-options-inp'])[3]")
    public WebElement durationInput;
}
