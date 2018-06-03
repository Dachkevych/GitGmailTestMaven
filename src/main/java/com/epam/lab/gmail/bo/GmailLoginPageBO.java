package com.epam.lab.gmail.bo;

import com.epam.lab.gmail.dataobject.UserModelGmail;
import com.epam.lab.gmail.pages.LoginPageGmail;
import com.epam.lab.gmail.pages.MainPageGmail;

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
