package com.cydeo.crm.pages;

import com.cydeo.crm.utilities.BrowserUtils;
import com.cydeo.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Base_Page {

    public Base_Page() {
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

    @FindBy(xpath = "//span[@class='menu-popup-item blog-comment-popup-menu ']/span[.='Delete']")
    public WebElement deleteBtn_comment;

    @FindBy(xpath = "//a[.='Like']")
    public WebElement likeBtn;

    @FindBy(xpath = "//div[.='You']")
    public WebElement youLiked;

    @FindBy(xpath = "//a[.='Unfollow']")
    public WebElement unfollow;

    @FindBy(xpath = "//a[.='Follow']")
    public WebElement follow;

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']/span/span/a")
    public WebElement likeBtnComment;

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']/span/span")
    public WebElement likeBtnCommentParent;

    @FindBy(xpath = "//div[@class='feed-post-emoji-text-item bx-ilike-right']")
    public WebElement likeIconComment;




    public void get_only_my_posts() {
        searchBox.click();
        BrowserUtils.sleep(2);
        myActivity.click();
        BrowserUtils.sleep(2);
    }

    public void delete_comment_from_post() {
        moreBtn_comment.click();
        deleteBtn_comment.click();
        Driver.getDriver().switchTo().alert().accept();
    }


}
