package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageKdr {
    public LoginPageKdr(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@name='USER_LOGIN']")
    public WebElement emailInput;

    @FindBy(xpath ="//input[@name='USER_PASSWORD']")
    public WebElement passwordInput;

    @FindBy (css = ".login-btn")
    public WebElement loginButton;





}
