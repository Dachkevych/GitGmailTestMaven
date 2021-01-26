package base.com.ua.gmail.pages;

import base.com.ua.decorator.BasePageElement;
import base.com.ua.decorator.Name;
import base.com.ua.utils.DriverManager;
import base.com.ua.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagePageGmail extends PageObject {

  @Name("Reciever message")
  @FindBy(name = "to")
  private BasePageElement reciever;

  @Name("Subject message")
  @FindBy(name = "subjectbox")
  private BasePageElement subject;

  @Name("Text message")
  @FindBy(xpath = "//div[@role='textbox']")
  private BasePageElement text;

  @Name("Close message")
  @FindBy(xpath = "//div[@role='dialog']//img[3]")
  private BasePageElement closeMessage;

  public void writeMessage(String to, String subj, String str) {
    DriverManager.newWait().until(ExpectedConditions.visibilityOf(reciever));
    reciever.sendKeys(to);
    subject.sendKeys(subj);
    text.sendKeys(str);
    closeMessage.click();
  }
}
