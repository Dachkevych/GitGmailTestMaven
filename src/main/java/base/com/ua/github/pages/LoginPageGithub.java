package base.com.ua.github.pages;

import base.com.ua.PageObject;
import base.com.ua.decorator.Name;
import base.com.ua.decorator.BasePageElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class LoginPageGithub extends PageObject {

  private Boolean statusLoad;

  @Name("SignIn")
  @FindBy(xpath = "//a[@href='/login']")
  private BasePageElement signIn;

  @Name("Login")
  @FindBy(id = "login_field")
  private BasePageElement login;

  @Name("Password")
  @FindBy(id = "password")
  private BasePageElement password;

  public void clickSignInBtn() {
    signIn.click();
  }

  public void setLogin(String email) {
    login.sendKeys(email);
  }

  public void setPassword(String pass) {
    password.sendKeys(pass, Keys.ENTER);
  }

  public void signIn(String log, String pass) {
    signIn.sendKeys(log);
    login.sendKeys(pass, Keys.ENTER);
  }
}
