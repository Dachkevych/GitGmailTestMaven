package com.epam.lab.decorator;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static com.epam.lab.utils.DriverManager.newWait;

public class PageElement implements WebElement {

    private static final Logger LOGGER = Logger.getLogger(PageElement.class);
    private WebElement webElement;
    private String name;

    public PageElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void click() {
        LOGGER.info("Click on [" + this.name + "]");
        webElement.click();
    }

    public void textOfElementShouldBeEqualTo(String text) {
        Assert.assertEquals(getText(), text, "Text of element [" + name + "] does not match");

    }

    public void submit() {
        webElement.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        LOGGER.info("Sending keys to [" + this.name + "] value [" + Arrays.toString(keysToSend) + "]");
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        webElement.clear();
    }

    public String getTagName() {
        return webElement.getTagName();
    }

    public String getAttribute(String name) {
        LOGGER.info("Getting attribute [" + name + "]");
        return webElement.getAttribute(name);
    }

    public boolean isSelected() {
        LOGGER.info("Checking isSelected [" + name + "]");
        return webElement.isSelected();
    }

    public boolean isEnabled() {
        LOGGER.info("Checking isEnable [" + name + "]");
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    public List<WebElement> findElements(By by) {
        LOGGER.info("Finding elements [" + name + "]");
        return webElement.findElements(by);
    }

    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public Point getLocation() {
        LOGGER.info("Getting element location [" + name + "]");
        return webElement.getLocation();
    }

    public Dimension getSize() {
        LOGGER.info("Getting elements size [" + name + "]");
        return webElement.getSize();
    }

    public Rectangle getRect() {
        LOGGER.info("Getting elements rect [" + name + "]");
        return webElement.getRect();
    }

    public String getCssValue(String propertyName) {
        LOGGER.info("Getting css value [" + name + "]");
        return webElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }

    public PageElement waitUntilVisible() {
        newWait().until(ExpectedConditions.visibilityOf(this));
        return this;
    }
}