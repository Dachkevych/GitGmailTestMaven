package com.epam.lab.gmail.pages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.utils.DriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.lab.utils.DriverManager.newWait;

public class DraftPageGmail extends PageObject {

    private Boolean ifSentMessage;

    @Name("Last draft message")
    @FindBy(xpath = "//tr[1]/td[4]/div[2]/font[1]")
    private PageElement lastDraft;

    @Name("Sent message")
    @FindBy(xpath = "//td[1]/div/div[2 and @tabindex='1' and @role='button']")
    private PageElement sendDraftMessage;

    @FindBy(xpath = "//input[@name='q']")
    private PageElement searchInput;


    public void clickLastDraft() {
        newWait().until(ExpectedConditions.visibilityOf(lastDraft));
        lastDraft.click();
    }

    public void clickSendDraft() {
        newWait().until(ExpectedConditions.visibilityOf(sendDraftMessage));
        sendDraftMessage.click();
    }

    public boolean checkSentMessage() {
        if ((new WebDriverWait(DriverManager.getDriver(), 15))
                .until(ExpectedConditions.elementToBeClickable(sendDraftMessage)) != null) {
            ifSentMessage = true;
        }
        return ifSentMessage;
    }
}
