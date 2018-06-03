package com.epam.lab.github.pages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.PageElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class LoginPageGithub extends PageObject {

    private Boolean statusLoad;
    @Name("SignIn")
    @FindBy(xpath = "//a[@href='/login']")
    private PageElement signIn;

    @Name("Login")
    @FindBy(id = "login_field")
    private PageElement login;

    @Name("Password")
    @FindBy(id = "password")
    private PageElement password;

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
