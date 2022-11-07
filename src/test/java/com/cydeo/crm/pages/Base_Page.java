package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {

    public Base_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }




}
