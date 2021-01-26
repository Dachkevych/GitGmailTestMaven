package base.com.ua.gmail.pages;

import base.com.ua.decorator.BasePageElement;
import base.com.ua.decorator.Name;
import base.com.ua.utils.DriverManager;
import base.com.ua.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageGmail extends PageObject {
  private Boolean statusLoad;

  @Name("Draft message")
  @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#drafts']")
  private BasePageElement draftBtn;

  @Name("Compose button")
  @FindBy(xpath = "//div[@gh='cm']")
  private BasePageElement composeBtn;

  public MainPageGmail() {}

  public void clickComposeBtn() {
    DriverManager.newWait().until(ExpectedConditions.visibilityOf(composeBtn));
    composeBtn.click();
  }

  public void clickDraftBtn() {
    DriverManager.newWait().until(ExpectedConditions.visibilityOf(draftBtn));
    draftBtn.click();
  }

  public boolean checkLoadInbox() {
    if ((new WebDriverWait(DriverManager.getDriver(), 20))
            .until(ExpectedConditions.elementToBeClickable(composeBtn))
        != null) {
      statusLoad = true;
    }
    return statusLoad;
  }
}
