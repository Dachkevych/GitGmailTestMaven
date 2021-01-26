package base.com.ua.gmail.bo;

import base.com.ua.gmail.dto.UserModelGmail;
import base.com.ua.gmail.pages.LoginPageGmail;
import base.com.ua.gmail.pages.MainPageGmail;

public class GmailLoginPageBO {

  public void login(UserModelGmail user) {
    LoginPageGmail loginPageGmail = new LoginPageGmail();
    loginPageGmail.logIn(user.getLogin(), user.getPassword());
  }

  public boolean checkLoginSuccess() {
    MainPageGmail mainPageGmail = new MainPageGmail();
    return mainPageGmail.checkLoadInbox();
  }
}
