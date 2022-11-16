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
    public List<WebElement> moreBtn_comment;



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

    @FindBy(xpath = "//div[@class='feed-com-informers-bottom']/a[1]")
    public WebElement replyToComment;

    @FindBy(xpath = "//div[@class='feed-com-text-inner-inner']")
    public List<WebElement>  allComments;

    @FindBy(xpath = "//span[.='View comment']")
    public WebElement viewComment;

    @FindBy(id="pagetitle")
    public WebElement pageTitle;

    @FindBy(xpath = "//span[@class='menu-popup-item-text']/span[.='Copy link']")
    public WebElement copyLink;

    @FindBy(xpath = "//span[@class='menu-popup-item blog-comment-popup-menu ']/span[.='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//span[.='Comment deleted']")
    public WebElement commentDeleted;

    @FindBy(xpath = "//span[@class='menu-popup-item blog-comment-popup-menu ']/span[.='Create task']")
    public  WebElement createTask;

    @FindBy(xpath = "//div[.='Task has been created']")
    public WebElement taskCreatedAlert;

    @FindBy(xpath = "//span[@class='feed-content-view-cnt-wrap']")
    public WebElement reviewers;

    @FindBy(xpath = "//span[@class='bx-contentview-popup']")
    public WebElement reviewersName;

    @FindBy(xpath = "//a[@class='bx-contentview-popup-img']")
    public List<WebElement> reviewersList;

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement reviewerHeader;

    @FindBy(xpath = "//div[@title='Add to favorites']")
    public WebElement starIcon;

    @FindBy(xpath = "//span[.='Favorites']")
    public WebElement favorites;

    @FindBy(xpath = "//div[@class=\'main-ui-filter-search-square main-ui-filter-search-square-preset main-ui-square\']/div[1]")
    public WebElement favoriteTag;

    public void get_only_my_posts() {
        BrowserUtils.sleep(3);
        searchBox.click();
        BrowserUtils.sleep(2);
        myActivity.click();
        BrowserUtils.sleep(2);
    }

    public void delete_comment_from_post() {
        for (WebElement btn : moreBtn_comment) {
            btn.click();
            deleteBtn_comment.click();
            Driver.getDriver().switchTo().alert().accept();
        }

    }

    //upload_stepDefinitions locators===>START//

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement messageSendButton;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement messageUploadFileBtn;

    @FindBy(xpath = "(//input[@class='diskuf-fileUploader wd-test-file-light-inp '])[1]")
    public WebElement chooseFilesForMessage;

    @FindBy(xpath = "(//div[.='Photo:'])[1]")
    public WebElement uploadedJpegFile;


    @FindBy(xpath = "(//div[.='Files:'])[1]")
    public WebElement uploadedPDFFile;

    @FindBy(xpath = "(//div[.='Files:'])[1]")
    public WebElement uploadedDocXFile;

    @FindBy(xpath = "//img[@id='disk-attach-image-990']")
    public WebElement uploadImageProof;

    @FindBy(xpath = "(//span[.='Insert in text'])[2]")
    public WebElement msgInsertInTextBtn;

    @FindBy(xpath = "(//span[.='In text'])[2]")
    public WebElement msgInTextBtn;

    @FindBy(xpath = "(//a[@class='feed-con-file-changes-link'])[1]")
    public WebElement recipientEditBtn;

    @FindBy(xpath = "//span[@class='del-but']")
    public WebElement msgFileDeleteBtn;

    @FindBy(xpath = "//span[@title='Click to insert file']")
    public WebElement addedFile;

    @FindBy(xpath = "//span[@class='files-name-edit-btn']")
    public WebElement fileNameEditBtn;

    @FindBy(xpath = "//input[@value='DOCX Document (38)']")
    public WebElement inputRename;

    @FindBy(xpath = "//a[@title='Renamed fileDOCX Document (38).docx']")
    public WebElement renamedFile;


    //upload_stepDefinitions locators===>END//
}
