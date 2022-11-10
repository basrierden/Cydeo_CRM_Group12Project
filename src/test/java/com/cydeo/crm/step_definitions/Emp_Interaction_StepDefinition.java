package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.Base_Page;
import com.cydeo.crm.pages.Login_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.ConfigurationReader;
import com.cydeo.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Emp_Interaction_StepDefinition {
    Login_Page loginPage = new Login_Page();
    Base_Page basePage = new Base_Page();


    @When("user write a {string} to post")
    public void user_write_a_to_any_post(String string) {
        basePage.get_only_my_posts();
        basePage.commentBox.click();
        Driver.getDriver().switchTo().frame(0);
        basePage.messageBox.sendKeys(string);
        BrowserUtils.sleep(3);
        Driver.getDriver().switchTo().parentFrame();


    }
    @When("click send button")
    public void click_send_button() {
        basePage.sendBtn.click();
        BrowserUtils.sleep(2);
    }
    @Then("{string} appear under the post")
    public void appear_under_the_post(String expected) {
        String actual = basePage.comment.getText();
        basePage.delete_comment_from_post();
        Assert.assertEquals("comment did not appear under the post",expected,actual);
    }


    @When("user click like button any of employees post")
    public void user_click_like_button_any_of_employees_post() {
        basePage.get_only_my_posts();
        basePage.likeBtn.click();
    }
    @Then("you was written under the post")
    public void you_was_written_under_the_post() {
        boolean isDisplayed = basePage.youLiked.isDisplayed();
        basePage.likeBtn.click();
        Assert.assertTrue(isDisplayed);

    }

}

