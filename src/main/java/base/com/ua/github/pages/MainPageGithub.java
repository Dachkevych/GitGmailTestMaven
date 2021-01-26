package base.com.ua.github.pages;

import base.com.ua.decorator.BasePageElement;
import base.com.ua.PageObject;
import base.com.ua.github.bo.GithubSearchPageBO;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static base.com.ua.utils.DriverManager.newWait;

public class MainPageGithub extends PageObject {

  private static final Logger LOG = Logger.getLogger(MainPageGithub.class);

  @FindBy(name = "q")
  private BasePageElement search;

  @FindBy(xpath = "//div[@class='col-8 pr-3']")
  private List<BasePageElement> lists;

  @FindBy(xpath = "//div[@class='d-flex flex-justify-between border-bottom pb-3']/h3")
  private BasePageElement resultCount;

  @FindBy(xpath = "//h3[contains(text(), 'repository results')]")
  private BasePageElement amountSearchResult;

  @FindBy(className = "name")
  private BasePageElement accountButton;

  @FindBy(className = "header-nav-current-user")
  private BasePageElement signIn;

  public void performSearch(String searchTerm) {
    LOG.info(String.format("Performing search for the term [%s]", searchTerm));
    search.clear();
    search.sendKeys(searchTerm, Keys.ENTER);
  }

  public boolean checkSignInSuccess() {
    newWait().until(ExpectedConditions.visibilityOf(accountButton));
    accountButton.click();
    return signIn.getText().contains("Signed in");
  }

  public List<BasePageElement> getLists() {
    return lists;
  }

  public BasePageElement getAmountSearchResult() {
    return amountSearchResult;
  }
}
