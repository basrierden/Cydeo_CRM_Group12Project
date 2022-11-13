package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;

public class Login_StepDefinitions {


    Login_Page loginPage=new Login_Page();

    // login functionality for all user
    @Given("the user logs in as a {string}")
    public void the_user_logs_in_as_a(String userType) {

        Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));

        loginPage.loginAs(userType);
    }
}
