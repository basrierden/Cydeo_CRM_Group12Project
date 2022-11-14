package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {


    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    public void loginAs(String userType){

        String username ="";
        String password ="";

        switch(userType){
            case "Helpdesk":
                username = ConfigurationReader.getProperty("helpdesk_username");
                password = ConfigurationReader.getProperty("helpdesk_password");
                break;
            case "Human Resource":
                username = ConfigurationReader.getProperty("hr_username");
                password = ConfigurationReader.getProperty("hr_password");
                break;
            case "Marketing":
                username = ConfigurationReader.getProperty("marketing_username");
                password = ConfigurationReader.getProperty("marketing_password");
                break;
            case "Helpdesk_kenan":
                username = ConfigurationReader.getProperty("helpdesk_username_kenan");
                password = ConfigurationReader.getProperty("helpdesk_password_kenan");
                break;
            case "Human Resource_kenan":
                username = ConfigurationReader.getProperty("hr_username_kenan");
                password = ConfigurationReader.getProperty("hr_password_kenan");
                break;
            case "Marketing_kenan":
                username = ConfigurationReader.getProperty("marketing_username_kenan");
                password = ConfigurationReader.getProperty("marketing_password_kenan");
                break;
            default:
                System.out.println("invalid entry");

        }

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();

    }
// AA









}
