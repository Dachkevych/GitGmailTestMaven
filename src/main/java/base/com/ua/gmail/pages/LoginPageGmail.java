package base.com.ua.gmail.pages;

import base.com.ua.decorator.BasePageElement;
import base.com.ua.decorator.Name;
import base.com.ua.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class LoginPageGmail extends PageObject {

  @Name("Login")
  @FindBy(name = "identifier")
  private BasePageElement loginInput;

  @Name("Password")
  @FindBy(name = "password")
  private BasePageElement passwordInput;

  @Name("Submit")
  @FindBy(id = "identifierNext")
  private BasePageElement nextBtn;

  @Name("Submit Logi and Password")
  @FindBy(id = "passwordNext")
  private BasePageElement submitLogin;

  @FindBy(className = "gmail-nav__nav-link__sign-in")
  private BasePageElement signInNewButton;

  public void logIn(String login, String password) {
    loginInput.sendKeys(login, Keys.ENTER);
    passwordInput.waitUntilVisible().sendKeys(password, Keys.ENTER);
  }
}
