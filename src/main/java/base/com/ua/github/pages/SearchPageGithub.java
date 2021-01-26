package base.com.ua.github.pages;

import base.com.ua.decorator.BasePageElement;
import base.com.ua.decorator.Name;
import base.com.ua.PageObject;
import org.openqa.selenium.support.FindBy;

public class SearchPageGithub extends PageObject {

  private Boolean statusLoad;

  @Name("Sort type button")
  @FindBy(className = "js-select-button")
  private BasePageElement sortType;

  @Name("Fewest-Stars")
  @FindBy(css = ".select-menu-list>a:nth-child(3)")
  private BasePageElement sortFewestStars;

  @Name("Check sort")
  @FindBy(xpath = "//span[@class='js-select-button']")
  private BasePageElement checkSort;
}
