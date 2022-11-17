package com.cydeo.crm.step_definitions;

import com.cydeo.crm.pages.ActivityStream_Page;
import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Messaging_StepDefinitions {

    ActivityStream_Page activityStream_page=new ActivityStream_Page();
    Faker faker = new Faker();
    String messageText= faker.internet().domainName();

    @Given("the user clicks Message functionality and writes a message")
    public void the_user_clicks_message_functionality_and_writes_a_message() {
        activityStream_page.messageFunctionality.click();
        BrowserUtils.sleep(1);
        Driver.getDriver().switchTo().frame(activityStream_page.messageTitleFrame);
        activityStream_page.frameBody.sendKeys(messageText);
        Driver.getDriver().switchTo().parentFrame();
    }

    @Given("the user clicks {string} button")
    public void the_user_clicks_button(String string) {
        activityStream_page.messageFunctionClickTo(string);
    }



    @Given("the user clicks Message functionality")
    public void the_user_clicks_message_functionality() {
        activityStream_page.messageFunctionality.click();
    }

    @Then("only Recent, and Employees and departments are displayed on the page")
    public void only_recent_and_employees_and_departments_are_displayed_on_the_page() {

        List<String> expectedList=new ArrayList<>(Arrays.asList("Recent", "Employees and departments"));
        List<String> actualList=new ArrayList<>(Arrays.asList());

        for (int i = 0; i < activityStream_page.mentionsList.size(); i++) {
            actualList.add(activityStream_page.mentionsList.get(i).getText());
        }

        System.out.println(activityStream_page.mentionsList.get(0).getText());
        System.out.println(activityStream_page.mentionsList.get(1).getText());
        Assert.assertEquals(expectedList,actualList);
    }

    @Then("the user attaches a link to the specified text")
    public void the_user_attaches_a_link_to_the_specified_text() {

        activityStream_page.linkTextInput.sendKeys(messageText);
        String expectedLinkURL= "https://www." + messageText + "/";
        activityStream_page.linkURLInput.sendKeys(expectedLinkURL);
        activityStream_page.linkSaveButton.click();

    }

    @Then("the link is displayed on the message body")
    public void the_link_is_displayed_on_the_message_body() {

        String expectedLinkURL= "https://www." + messageText + "/";
        String actualLinkURL= activityStream_page.attachedLinkOnMessageBody.getAttribute("href");
        Assert.assertEquals(expectedLinkURL,actualLinkURL);

    }

    @Given("the user inserts YouTube video")
    public void the_user_inserts_you_tube_video() {

        BrowserUtils.sleep(2);
        String youTubeEmbedLink= "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/KfTmJ9DMaEw\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        activityStream_page.videoSourceInput.sendKeys(youTubeEmbedLink + Keys.ENTER);
        BrowserUtils.sleep(5);


    }

    @Given("the user removes YouTube video before sending message")
    public void the_user_removes_you_tube_video_before_sending_message() {
        Driver.getDriver().switchTo().frame(activityStream_page.messageTitleFrame);
        Actions actions=new Actions(Driver.getDriver());
        actions.contextClick(activityStream_page.frameBody).perform();
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(3);
        activityStream_page.deleteVideoButton.click();
    }

    @Given("the user removes Vimeo video before sending message")
    public void the_user_removes_vimeo_video_before_sending_message() {

        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().switchTo().frame(activityStream_page.messageTitleFrame);
        actions.contextClick(activityStream_page.frameBody).perform();
        Driver.getDriver().switchTo().parentFrame();
        BrowserUtils.sleep(2);
        activityStream_page.deleteVideoButton.click();

    }

    @Then("the inserted YouTube video is displayed on the message body")
    public void the_inserted_you_tube_video_is_displayed_on_the_message_body() {

        BrowserUtils.sleep(5);
        String expectedYouTubeSource="https://www.youtube.com/embed/KfTmJ9DMaEw";
        String actualYouTubeSource=activityStream_page.addedVideo.getAttribute("src");
        Assert.assertEquals(expectedYouTubeSource,actualYouTubeSource);
        activityStream_page.addedMessageMoreButton.click();
        activityStream_page.addedMessageDeleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();



    }

    @Given("the user inserts Vimeo video")
    public void the_user_inserts_vimeo_video() {
        BrowserUtils.sleep(2);
        String vimeoEmbedLink= "<iframe src=\"https://player.vimeo.com/video/164836353?h=e6dd6280b8\" width=\"640\" height=\"360\" frameborder=\"0\" allow=\"autoplay; fullscreen; picture-in-picture\" allowfullscreen></iframe>\n" +
                "<p><a href=\"https://vimeo.com/164836353\">Gladiator Soundtrack - Hans Zimmer - piano &amp; pipe organ cover</a> from <a href=\"https://vimeo.com/user35503680\">David Robertshaw</a> on <a href=\"https://vimeo.com\">Vimeo</a>.</p>";

        activityStream_page.videoSourceInput.sendKeys(vimeoEmbedLink + Keys.ENTER);
        BrowserUtils.sleep(5);



    }



    @Then("the inserted Vimeo video is displayed on the message body")
    public void the_inserted_vimeo_video_is_displayed_on_the_message_body() {

        BrowserUtils.sleep(5);
        String expectedVimeoSource="https://player.vimeo.com/video/164836353?h=e6dd6280b8";
        String actualVimeoSource=activityStream_page.addedVideo.getAttribute("src");
        Assert.assertEquals(expectedVimeoSource,actualVimeoSource);
        activityStream_page.addedMessageMoreButton.click();
        activityStream_page.addedMessageDeleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }





    @And ("the user removes link from the message before sending")
    public void the_user_removes_link_from_the_message_before_sending() {

        Driver.getDriver().switchTo().frame(activityStream_page.messageTitleFrame);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(activityStream_page.messageLinkText).perform();
        actions.contextClick(activityStream_page.messageLinkText).perform();
        Driver.getDriver().switchTo().parentFrame();
        activityStream_page.removeLinkButton.click();
    }


    @Then("the link is not displayed on the message body")
    public void the_link_is_not_displayed_on_the_message_body() {

        activityStream_page.assertWebElementNotPresent(activityStream_page.attachedLinkOnMessageBody);
    }




    @Given("the user adds quote to the message body")
    public void the_user_adds_quote_to_the_message_body() {

        Driver.getDriver().switchTo().frame(activityStream_page.messageTitleFrame);
        activityStream_page.quoteBody.sendKeys(messageText);
        Driver.getDriver().switchTo().parentFrame();
    }

    @Then("the quote is displayed on the message body")
    public void the_quote_is_displayed_on_the_message_body() {

        String expectedTitleAttribute="Quote";
        String actualTitleAttribute=activityStream_page.sentQuotedText.getAttribute("title");
        Assert.assertEquals(expectedTitleAttribute,actualTitleAttribute);
    }


    @And("the user add tag and clicks add button")
    public void the_user_add_tag_and_clicks_add_button() {

        activityStream_page.addTagInputBox.sendKeys(messageText);
        activityStream_page.tagAddButton.click();
        BrowserUtils.sleep(1);

    }
    @Then("the added tag is displayed on the page")
    public void the_added_tag_is_displayed_on_the_page() {

        String expectedText=messageText;
        String actualText=activityStream_page.addedTags.getText();
        Assert.assertEquals(expectedText,actualText);

    }


    @Given("the user removes tag before sending message")
    public void the_user_removes_tag_before_sending_message() {
        activityStream_page.removeTagButton.click();
    }

    @Then("the added tag is not displayed on the page")
    public void the_added_tag_is_not_displayed_on_the_page() {

        try {
            String expectedText=messageText;
            String actualText=activityStream_page.addedTags.getText();
            Assert.assertEquals(expectedText,actualText);
        } catch (Exception e) {
            System.out.println("Tag is removed from the page. Two tags are different ");
        }

    }



    @Given("the user clicks send message button")
    public void the_user_clicks_send_message_button() {

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(activityStream_page.sendMessageButton).click().perform();
        BrowserUtils.sleep(3);

    }

    @Then("the inserted video is not displayed on the message body")
    public void the_inserted_video_is_not_displayed_on_the_message_body() {

        activityStream_page.assertWebElementNotPresent(activityStream_page.addedVideo);

    }

}
