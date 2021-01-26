package base.com.ua.github.bo;

import base.com.ua.github.dto.UserModelGithub;
import base.com.ua.github.pages.LoginPageGithub;

public class GithubLoginPageBO {

  private LoginPageGithub loginPageGithub;

  public GithubLoginPageBO() {
    loginPageGithub = new LoginPageGithub();
  }

  public void login(UserModelGithub user) {
    loginPageGithub.clickSignInBtn();
    loginPageGithub.setLogin(user.getLogin());
    loginPageGithub.setPassword(user.getPassword());
  }
}
