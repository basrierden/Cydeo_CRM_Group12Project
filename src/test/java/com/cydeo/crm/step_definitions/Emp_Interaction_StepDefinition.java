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

    @When("User click unfollow under any of employee post")
    public void user_click_unfollow_under_any_of_employee_post() {
        basePage.get_only_my_posts();
        basePage.unfollow.click();

    }
    @Then("unfollow turns to follow")
    public void unfollow_turns_to_follow() {
        String actual = basePage.follow.getText();
        basePage.follow.click();
        Assert.assertEquals("Unfollow was not clicked","Follow",actual);
    }

    @When("user click to like of that comment")
    public void user_click_to_like_of_that_comment() {
        basePage.likeBtnComment.click();
    }
    @Then("like icon appears next to comment")
    public void like_icon_appears_next_to_comment() {
        boolean result = basePage.likeBtnCommentParent.getAttribute("class").contains("bx-you-like-button");
        basePage.delete_comment_from_post();
        BrowserUtils.sleep(2);
        Assert.assertTrue("comment could not be liked",result);
    }



}

