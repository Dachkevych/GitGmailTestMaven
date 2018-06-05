package com.epam.lab.gmail.pages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.utils.DriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.lab.utils.DriverManager.newWait;

public class MainPageGmail extends PageObject {
    private Boolean statusLoad;
    @Name("Draft message")
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
    private PageElement draftBtn;

    @Name("Compose button")
    @FindBy(xpath = "//div[@gh='cm']")
    private PageElement composeBtn;

    public MainPageGmail() {
    }

    public void clickComposeBtn() {
        newWait().until(ExpectedConditions.visibilityOf(composeBtn));
        composeBtn.click();
    }

    public void clickDraftBtn() {
        newWait().until(ExpectedConditions.visibilityOf(draftBtn));
        draftBtn.click();
    }

    public boolean checkLoadInbox() {
        if ((new WebDriverWait(DriverManager.getDriver(), 20)).until(ExpectedConditions.elementToBeClickable(composeBtn)) != null) {
            statusLoad = true;
        }
        return statusLoad;
    }
}
