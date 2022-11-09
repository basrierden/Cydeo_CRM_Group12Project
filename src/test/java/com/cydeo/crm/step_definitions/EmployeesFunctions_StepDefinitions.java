package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Employees_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class EmployeesFunctions_StepDefinitions {

    Employees_Page employees_page = new Employees_Page();

    @When("the user click on Employees button on the left menu")
    public void the_user_click_on_employees_button_on_the_left_menu() {
        employees_page.employeesButton.click();

    }

    @Then("the user displays company structure")
    public void the_user_displays_company_structure() {
        Assert.assertTrue(employees_page.visual_structure.isDisplayed());
    }


    @When("the user click on Add Department button")
    public void the_user_click_on_add_department_button() {
        employees_page.addDepartmentButton.click();
        BrowserUtils.sleep(1);

    }

    @When("the user types Department name")
    public void the_user_types_department_name() {
        employees_page.departmentNameInputBox.sendKeys("New Department Test");
//        BrowserUtils.sleep(1);

    }

    @When("the user select supervisor from company")
    public void the_user_select_supervisor_from_company() {
        employees_page.supervisorSelectFromStructure.click();
        BrowserUtils.sleep(2);
        employees_page.companyButton.click();
        BrowserUtils.sleep(5);
        employees_page.CyberVet.click();
        BrowserUtils.sleep(3);
        employees_page.employeeToBeSupervisorFromCompany.click();
        BrowserUtils.sleep(5);

    }


    @When("the user adds a department")
    public void the_user_adds_a_department() {
        employees_page.addButton.click();
        BrowserUtils.sleep(1);
    }

    @Then("the user sees the added department on the company structure")
    public void the_user_sees_the_added_department_on_the_company_structure() {
        Assert.assertTrue(employees_page.NewDepartmentTest.isDisplayed());

        //delete new department after assertion
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(employees_page.NewDepartmentTest).perform();
//        BrowserUtils.sleep(1);
        employees_page.departmentDelete.click();
//        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
//        BrowserUtils.sleep(2);
    }


    @When("the user select a parent department from the department dropdown")
    public void the_user_select_a_parent_department_from_the_department_dropdown() {
        employees_page.selectParentDepartmentList().selectByValue("449");
        BrowserUtils.sleep(1);
    }

    @Then("the user sees the added department under parent department on the company structure")
    public void the_user_sees_the_added_department_under_parent_department_on_the_company_structure() {
        Assert.assertTrue(employees_page.childDepartment.isDisplayed());

        //delete new department after assertion
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(employees_page.NewDepartmentTest).perform();
//        BrowserUtils.sleep(2);
        employees_page.departmentDelete.click();
//        BrowserUtils.sleep(2);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
//        BrowserUtils.sleep(2);
    }

    @When("the user select supervisor from recent")
    public void the_user_select_supervisor_from_recent() {
        employees_page.supervisorSelectFromStructure.click();
        BrowserUtils.sleep(1);
        employees_page.recentButton.click();
        BrowserUtils.sleep(1);
        employees_page.employeeToBeSupervisorFromRecent.click();
        BrowserUtils.sleep(1);

    }

    @When("the user search and select supervisor {string} from search")
    public void the_user_search_and_select_supervisor_from_search(String string) {
        employees_page.supervisorSelectFromStructure.click();
        employees_page.searchButton.click();
        employees_page.searchInputbox.sendKeys(string);
        employees_page.searchResultByName(string).click();
//        employees_page.employeeToBeSupervisorFromSearch.click();
        BrowserUtils.sleep(2);

    }


}
