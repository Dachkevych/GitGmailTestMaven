package com.epam.lab;

import com.epam.lab.decoratorimpl.MyDefaultFieldDecorator;
import com.epam.lab.utils.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class PageObject {

    public PageObject() {
        PageFactory.initElements(
                new MyDefaultFieldDecorator(
                        new DefaultElementLocatorFactory(DriverManager.getDriver())
                ), this);
    }
}