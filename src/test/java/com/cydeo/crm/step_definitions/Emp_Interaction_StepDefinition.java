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
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

    @When("user click on reply under the comment")
    public void user_click_on_reply_under_the_comment() {
        basePage.replyToComment.click();
    }
    @When("write something to comment part")
    public void write_something_to_comment_part() {
        Driver.getDriver().switchTo().frame(0);
        basePage.messageBox.sendKeys("This is the comment to comment");
        Driver.getDriver().switchTo().parentFrame();
        basePage.sendBtn.click();

    }
    @Then("message appears under the post with the name of receiver")
    public void message_appears_under_the_post_with_the_name_of_receiver() {
        String actual = "";
        for (WebElement comment : basePage.allComments) {
            if (comment.getText().contains("This is the comment to comment")){
                actual = "This is the comment to comment";
            }
        }
        basePage.delete_comment_from_post();
        Assert.assertEquals("This is the comment to comment",actual);
    }

    @When("click more under the comment was written")
    public void click_more_under_the_comment_was_written() {
        basePage.moreBtn_comment.get(0).click();
    }
    @When("click view comment")
    public void click_view_comment() {
        basePage.viewComment.click();
    }
    @Then("user will be directed to new page where page title is Conversations")
    public void user_will_be_directed_to_new_page_where_page_title_is_Conversations() {
        String actual = basePage.pageTitle.getText();
        Driver.getDriver().navigate().back();
        basePage.get_only_my_posts();
        basePage.delete_comment_from_post();
        Assert.assertEquals("Conversations",actual);
    }

    @When("click copy link")
    public void click_copy_link() {
        basePage.copyLink.click();
    }
    @Then("done icon appears next to copy link and link was copied accordingly")
    public void done_icon_appears_next_to_copy_link_and_link_was_copied_accordingly() throws IOException, UnsupportedFlavorException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String expected = (String) clipboard.getData(DataFlavor.stringFlavor);
        basePage.viewComment.click();
        String actual = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().navigate().back();
        basePage.delete_comment_from_post();
        Assert.assertEquals(expected,actual);

    }

    @When("click edit button")
    public void click_edit_button() {
        basePage.editBtn.click();
    }
    @When("write {string} the comment")
    public void write_the_comment(String string) {
        Driver.getDriver().switchTo().frame(0);
        basePage.messageBox.sendKeys(string);
        Driver.getDriver().switchTo().parentFrame();
        basePage.sendBtn.click();
    }
    @Then("updated comment contains to {string}")
    public void updated_comment_contains_to(String string) {
        boolean result = basePage.allComments.get(0).getText().contains(string);
        basePage.delete_comment_from_post();
        Assert.assertTrue(result);

    }

    @When("click delete button and click OK")
    public void click_delete_button_and_click_ok() {
        basePage.deleteBtn_comment.click();
        Driver.getDriver().switchTo().alert().accept();
        BrowserUtils.sleep(2);
    }
    @Then("comment deletes and Comment deleted alert appears on the screen")
    public void comment_deletes_and_comment_deleted_alert_appears_on_the_screen() {
        Assert.assertTrue(basePage.commentDeleted.isDisplayed());
    }

    @When("click create task button")
    public void click_create_task_button() {
        basePage.createTask.click();
        BrowserUtils.sleep(4);
    }
    @Then("{string} alert should appear")
    public void alert_should_appear(String string) {
        Assert.assertTrue(basePage.taskCreatedAlert.isDisplayed());
    }
    @Then("task should be created with the {string} comment header")
    public void task_should_be_created_with_the_comment_header(String expected) {
       basePage.taskView.click();
       String actual = basePage.taskPageTitle.getText();
        basePage.taskPageClose.click();
        basePage.delete_comment_from_post();
        Assert.assertEquals(expected,actual);
    }






}

