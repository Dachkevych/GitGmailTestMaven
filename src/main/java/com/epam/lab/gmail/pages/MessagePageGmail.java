package com.epam.lab.gmail.pages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.PageElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.epam.lab.utils.DriverManager.newWait;

public class MessagePageGmail extends PageObject {

    @Name("Reciever message")
    @FindBy(name = "to")
    private PageElement reciever;

    @Name("Subject message")
    @FindBy(name = "subjectbox")
    private PageElement subject;

    @Name("Text message")
    @FindBy(xpath = "//div[@role='textbox']")
    private PageElement text;

    @Name("Close message")
    @FindBy(xpath = "//div[@role='dialog']//img[3]")
    private PageElement closeMessage;

    public void writeMessage(String to, String subj, String str) {
        newWait().until(ExpectedConditions.visibilityOf(reciever));
        reciever.sendKeys(to);
        subject.sendKeys(subj);
        text.sendKeys(str);
        closeMessage.click();
    }
}
