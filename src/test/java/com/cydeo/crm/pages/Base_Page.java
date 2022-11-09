package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Base_Page {

    public Base_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "LIVEFEED_search")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@data-id='my']/span/span[text()='My Activity']")
    public WebElement myActivity;

    @FindBy(xpath = "//div[@class='feed-com-add-box']/div/div/a")
    public WebElement commentBox;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBox;

    @FindBy(xpath = "//div[@style='display: block;']/form/div/div/button[text()='Send']")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[@class='feed-com-text-inner-inner']")
    public WebElement comment;

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']/a/span")
    public WebElement moreBtn_comment;

    @FindBy(xpath = "//div[@style='z-index: 1000; position: absolute; display: block; top: 217px; left: 404px;']" +
            "/div/div/div/span[.='Delete']")
    public WebElement deleteBtn_comment;

    @FindBy(xpath = "//a[.='Like']")
    public WebElement likeBtn;

    @FindBy(xpath = "//div[.='You']")
    public WebElement youLiked;





    public void get_only_my_posts(){
        searchBox.click();
        BrowserUtils.sleep(2);
        myActivity.click();
        BrowserUtils.sleep(2);
    }
    public void delete_comment_from_post(){
        moreBtn_comment.click();
        deleteBtn_comment.click();
        Driver.getDriver().switchTo().alert().accept();
    }






}
