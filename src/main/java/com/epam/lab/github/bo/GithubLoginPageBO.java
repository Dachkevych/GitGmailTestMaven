package com.epam.lab.github.bo;

import com.epam.lab.github.dataobject.UserModelGithub;
import com.epam.lab.github.pages.LoginPageGithub;

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
