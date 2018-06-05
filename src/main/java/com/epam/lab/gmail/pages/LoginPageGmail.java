package com.epam.lab.gmail.pages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.PageElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class LoginPageGmail extends PageObject {

    @Name("Login")
    @FindBy(name = "identifier")
    private PageElement loginInput;

    @Name("Password")
    @FindBy(name = "password")
    private PageElement passwordInput;

    @Name("Submit")
    @FindBy(id = "identifierNext")
    private PageElement nextBtn;

    @Name("Submit Logi and Password")
    @FindBy(id = "passwordNext")
    private PageElement submitLogin;

    @FindBy(className = "gmail-nav__nav-link__sign-in")
    private PageElement signInNewButton;

    public void logIn(String login, String password) {
        loginInput.sendKeys(login, Keys.ENTER);
        passwordInput.waitUntilVisible().sendKeys(password, Keys.ENTER);
    }
}
