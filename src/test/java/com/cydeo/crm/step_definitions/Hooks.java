package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStream_Page;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After
    public void teardownScenario(Scenario scenario){


        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        Driver.closeDriver();

    }



}
