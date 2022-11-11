package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Employees_Page {

    public Employees_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "main-buttons-item-text-title")
    public WebElement companyStructureButton;

    @FindBy(id = "pagetitle")
    public WebElement companyStructurePageTitle;

    @FindBy(id = "bx_visual_structure")
    public WebElement visual_structure;

    @FindBy(xpath = "//a[@title='Employees']")
    public WebElement employeesButton;

    @FindBy(xpath = "//a[@class='webform-small-button webform-small-button-blue webform-small-button-add']")
    public WebElement addDepartmentButton;

    @FindBy(xpath = "//span[@class='popup-window-titlebar-text']")
    public WebElement addDepartmentPopUpTitle;

    @FindBy(xpath = "//input[@id='NAME']")
    public WebElement departmentNameInputBox;

    @FindBy(id = "single-user-choice")
    public WebElement supervisorSelectFromStructure;


    @FindBy(xpath = "(//span[@class='finder-box-tab-text'])[1]")
    public WebElement recentButton;

    @FindBy(xpath = "(//span[@class='finder-box-tab-text'])[2]")
    public WebElement companyButton;

    @FindBy(xpath = "(//span[@class='finder-box-tab-text'])[3]")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[@class='company-department-inner'])[1]")
    public WebElement CyberVet;

    @FindBy(xpath = "(//div[@class=\"finder-box-item-text\"])[1]")
    public WebElement employeeToBeSupervisorFromRecent;

    @FindBy(xpath = "(//div[@class='company-department-employee-name'])[1]")
    public WebElement employeeToBeSupervisorFromCompany;

    @FindBy(xpath = "//span[@class='structure-undo-close']")
    public WebElement structureUndoClose;

//    @FindBy(id = "Single_ldde0j_user_input")
    @FindBy(className = "finder-box-search-textbox")
    public WebElement searchInputbox;

    public WebElement searchResultByName(String name) {
        return Driver.getDriver().findElement(By.xpath("(//div[.='"+name+"'])[2]"));
    }

    @FindBy(xpath = "//div[@class='finder-box-tab-content finder-box-tab-content-selected']")
    public WebElement employeeToBeSupervisorFromSearch;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement addButton;

    @FindBy(xpath = "//div[@class=\"popup-window-buttons\"]/span[2]")
    public WebElement closeButton;

    @FindBy(xpath = "//div[@class=\"webform-content\"]//li")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@title='New Department Test']")
    public WebElement NewDepartmentTest;

    public WebElement getDepartmentTitleElement(String departmentName){
        return Driver.getDriver().findElement(By.xpath("//div[@class='structure-dept-title-text']/a[@title='"+ departmentName +"']"));
    }

    @FindBy(id = "IBLOCK_SECTION_ID")
    public WebElement selectParentDepartment;

    @FindBy(xpath = "//table[@id='bx_str_children_449']//a[.='New Department Test']")
    public WebElement childDepartment;


    public WebElement getChildDepartmentElement (String parentID, String childDeptName){
        return Driver.getDriver().findElement(By.xpath("//table[@id='bx_str_children_"+parentID+"']//a[.='"+childDeptName+"']"));
    }


    public void deleteDepartment(String departmentName){
        WebElement deleteDepartment = Driver.getDriver().findElement(By.xpath("//a[@title='"+departmentName+"']/../following-sibling::div/div[@data-role='department_delete']"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(getDepartmentTitleElement(departmentName)).perform();
        deleteDepartment.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    public void editDepartment(String departmentName){
        WebElement editDepartment = Driver.getDriver().findElement(By.xpath("//a[@title='"+departmentName+"']/../following-sibling::div/div[@data-role='department_edit']"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(getDepartmentTitleElement(departmentName)).perform();
        editDepartment.click();
    }

    public void addChildDepartment(String parentDepartmentName){
        WebElement addChildDepartment = Driver.getDriver().findElement(By.xpath("//a[@title='"+parentDepartmentName+"']/../following-sibling::div/div[@data-role='department_add']"));

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(getDepartmentTitleElement(parentDepartmentName)).perform();
        addChildDepartment.click();
    }

    public String getDepartmentID(String departmentName){

        WebElement DepTitle = getDepartmentTitleElement(departmentName);
        String href = DepTitle.getAttribute("href");

        String DepIDNumber = href.substring(href.lastIndexOf('=')+1);

        return DepIDNumber;
    }





    public Select selectParentDepartmentList() {
        return new Select(selectParentDepartment);
    }


//    (//div[@class="finder-box-item-text"])[1]


}
