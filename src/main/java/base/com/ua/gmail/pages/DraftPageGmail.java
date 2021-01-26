package base.com.ua.gmail.pages;

import base.com.ua.decorator.BasePageElement;
import base.com.ua.decorator.Name;
import base.com.ua.PageObject;
import base.com.ua.utils.DriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.com.ua.utils.DriverManager.newWait;

public class DraftPageGmail extends PageObject {

  private Boolean ifSentMessage;

  @Name("Last draft message")
  @FindBy(xpath = "//tr[1]/td[4]/div[2]/font[1]")
  private BasePageElement lastDraft;

  @Name("Sent message")
  @FindBy(xpath = "//td[1]/div/div[2 and @tabindex='1' and @role='button']")
  private BasePageElement sendDraftMessage;

  @FindBy(xpath = "//input[@name='q']")
  private BasePageElement searchInput;

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
            .until(ExpectedConditions.elementToBeClickable(sendDraftMessage))
        != null) {
      ifSentMessage = true;
    }
    return ifSentMessage;
  }
}
