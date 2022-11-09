package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Employees_Page {

    public Employees_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className="main-buttons-item-text-title")
    public WebElement companyStructureButton;

    @FindBy(id="pagetitle")
    public WebElement companyStructurePageTitle;

    @FindBy(id="bx_visual_structure")
    public WebElement visual_structure;

    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesButton;

    @FindBy(xpath = "//a[@class='webform-small-button webform-small-button-blue webform-small-button-add']")
    public WebElement addDepartmentButton;

    @FindBy(xpath = "//input[@id='NAME']")
    public WebElement departmentNameInputBox;

    @FindBy(id="single-user-choice")
    public WebElement superviserSelectFromStructure;

    @FindBy(xpath = "(//span[@class='finder-box-tab-text'])[2]")
    public WebElement companyButton;

    @FindBy(xpath = "(//span[@class='company-department-inner'])[1]")
    public WebElement CyberVet;

    @FindBy(xpath = "(//div[@class='company-department-employee-name'])[1]")
    public WebElement employeeToBeSuperviser;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement addButton;

    @FindBy(xpath = "//a[@title='New Department Test']")
    public WebElement NewDepartmentTest;




//    (//div[@class="finder-box-item-text"])[1]






}
