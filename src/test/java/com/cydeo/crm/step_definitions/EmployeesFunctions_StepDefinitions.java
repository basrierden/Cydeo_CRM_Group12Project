package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Employees_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

    @When("the user click on Add Department button and fills out fields")
    public void the_user_click_on_add_department_button_and_fills_out_fields() {
        employees_page.addDepartmentButton.click();
        BrowserUtils.sleep(1);

        employees_page.departmentNameInputBox.sendKeys("New Department Test");
//        BrowserUtils.sleep(1);
        employees_page.superviserSelectFromStructure.click();
//        BrowserUtils.sleep(1);
        employees_page.companyButton.click();
//        BrowserUtils.sleep(1);
        employees_page.CyberVet.click();
//        BrowserUtils.sleep(1);
        employees_page.employeeToBeSuperviser.click();
//        BrowserUtils.sleep(1);
        employees_page.addButton.click();


    }

    @Then("the user adds a department")
    public void the_user_adds_a_department() {
        Assert.assertTrue(employees_page.NewDepartmentTest.isDisplayed());

    }

}
