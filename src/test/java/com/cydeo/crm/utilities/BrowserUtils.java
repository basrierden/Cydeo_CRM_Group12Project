package com.cydeo.crm.utilities;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }


    public static boolean assertWebElementNotPresent(WebElement webElement) throws Exception{

        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            webElement.isDisplayed();
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }





}
