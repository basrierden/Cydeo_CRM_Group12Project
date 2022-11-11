package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Employees_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EmployeesFunctions_StepDefinitions {

    Employees_Page employees_page = new Employees_Page();

    @When("the user clicks on Employees button on the left menu")
    public void the_user_clicks_on_employees_button_on_the_left_menu() {
        employees_page.employeesButton.click();

    }

    @Then("the user displays company structure")
    public void the_user_displays_company_structure() {
        Assert.assertTrue(employees_page.visual_structure.isDisplayed());
    }


    @When("the user leaves Department name empty")
    public void the_user_leaves_department_name_empty() {

    }

    @Then("the user sees the error message")
    public void the_user_sees_the_error_message() {
        String expectedErrorMessage = "Section name is not specified.";
        String actualErrorMessage = employees_page.errorMessage.getText();

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @When("the user clicks on Add Department button")
    public void the_user_clicks_on_add_department_button() {
        BrowserUtils.sleep(1);
        employees_page.addDepartmentButton.click();

    }

    @When("the user types Department name")
    public void the_user_types_department_name() {
        employees_page.departmentNameInputBox.sendKeys(ConfigurationReader.getProperty("newDepartmentName1"));
//        BrowserUtils.sleep(1);
    }

    @When("the user selects supervisor from company")
    public void the_user_selects_supervisor_from_company() {
        employees_page.supervisorSelectFromStructure.click();
//        BrowserUtils.sleep(2);
        employees_page.companyButton.click();
//        BrowserUtils.sleep(5);
        employees_page.CyberVet.click();
//        BrowserUtils.sleep(3);
        employees_page.employeeToBeSupervisorFromCompany.click();
//        BrowserUtils.sleep(5);

    }

    @When("the user adds a department")
    public void the_user_adds_a_department() {
        employees_page.addButton.click();

    }

    @Then("the user sees the added department on the company structure")
    public void the_user_sees_the_added_department_on_the_company_structure() {
//        BrowserUtils.sleep(1);
        WebElement DepartmentTitle = employees_page.getDepartmentTitleElement(ConfigurationReader.getProperty("newDepartmentName1"));

        Assert.assertTrue(DepartmentTitle.isDisplayed());

        //delete new department after assertion
        employees_page.deleteDepartment(ConfigurationReader.getProperty("newDepartmentName1"));

    }


    @When("the user selects a parent department from the department dropdown")
    public void the_user_select_a_parent_department_from_the_department_dropdown() {

        BrowserUtils.sleep(1);
        String ID = employees_page.getDepartmentID(ConfigurationReader.getProperty("newDepartmentName1"));
        employees_page.selectParentDepartmentList().selectByValue(ID);

    }

    @Then("the user sees the added department under parent department on the company structure")
    public void the_user_sees_the_added_department_under_parent_department_on_the_company_structure() {

        String parentDeptID = employees_page.getDepartmentID(ConfigurationReader.getProperty("newDepartmentName1"));
        String childDeptName = ConfigurationReader.getProperty("newDepartmentName2");

        WebElement childDept = employees_page.getChildDepartmentElement(parentDeptID, childDeptName);

        Assert.assertTrue(childDept.isDisplayed());

        //delete new department after assertion
        employees_page.deleteDepartment(ConfigurationReader.getProperty("newDepartmentName1"));

        employees_page.deleteDepartment(ConfigurationReader.getProperty("newDepartmentName2"));
    }


    @When("the user selects supervisor from recent")
    public void the_user_select_supervisor_from_recent() {
        employees_page.supervisorSelectFromStructure.click();
        employees_page.recentButton.click();
        employees_page.employeeToBeSupervisorFromRecent.click();

    }

    @When("the user searches and selects supervisor {string} from search")
    public void the_user_search_and_select_supervisor_from_search(String string) {
        employees_page.supervisorSelectFromStructure.click();
        employees_page.searchButton.click();
        employees_page.searchInputbox.sendKeys(string);
        employees_page.searchResultByName(string).click();
//        employees_page.employeeToBeSupervisorFromSearch.click();
//        BrowserUtils.sleep(2);

    }

    @When("the user clicks on Close button")
    public void the_user_clicks_on_close_button() {
        employees_page.closeButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("add department pop-up is closed")
    public void add_department_pop_up_is_closed() throws Exception {
        BrowserUtils.sleep(1);
        Assert.assertFalse(employees_page.addDepartmentPopUpTitle.isDisplayed());
    }

    @When("the user types Department name {string}")
    public void the_user_types_department_name(String string) {
        employees_page.departmentNameInputBox.sendKeys(string);
    }

    @When("the user edits the department")
    public void the_user_edits_the_department() {

        employees_page.editDepartment(ConfigurationReader.getProperty("newDepartmentName1"));
        employees_page.departmentNameInputBox.clear();
        BrowserUtils.sleep(1);
        employees_page.departmentNameInputBox.sendKeys(ConfigurationReader.getProperty("newDepartmentName2"));
        BrowserUtils.sleep(1);
        employees_page.addButton.click();
        BrowserUtils.sleep(1);
    }


    @When("the user types child Department name")
    public void the_user_types_child_department_name() {
        employees_page.departmentNameInputBox.sendKeys(ConfigurationReader.getProperty("newDepartmentName2"));
    }


    @Then("the department is edited")
    public void the_department_is_edited() {
        WebElement editedDepartmentTitle = employees_page.getDepartmentTitleElement(ConfigurationReader.getProperty("newDepartmentName2"));

        Assert.assertTrue(editedDepartmentTitle.isDisplayed());

        BrowserUtils.sleep(1);

        //delete new department after assertion
        employees_page.deleteDepartment(ConfigurationReader.getProperty("newDepartmentName2"));
    }

    @When("the user adds child department")
    public void the_user_adds_child_department() {
        BrowserUtils.sleep(1);
        employees_page.addChildDepartment(ConfigurationReader.getProperty("newDepartmentName1"));
        employees_page.departmentNameInputBox.sendKeys(ConfigurationReader.getProperty("newDepartmentName2"));
        BrowserUtils.sleep(1);
        the_user_adds_a_department();
        BrowserUtils.sleep(1);

    }

    @When("the user deletes the department")
    public void the_user_deletes_the_department() {
        BrowserUtils.sleep(1);

        employees_page.deleteDepartment(ConfigurationReader.getProperty("newDepartmentName1"));

        BrowserUtils.sleep(5);
    }

    @Then("the department is deleted")
    public void the_department_is_deleted() throws Exception {

        boolean departmentPresent = Driver.getDriver().getPageSource().contains(ConfigurationReader.getProperty("newDepartmentName1"));

        Assert.assertFalse(departmentPresent);

    }


}




        /*
        //delete new department after assertion
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(employees_page.NewDepartmentTest).perform();
//        BrowserUtils.sleep(1);
        employees_page.departmentDelete.click();
//        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
//        BrowserUtils.sleep(2);

        */