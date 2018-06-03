package com.epam.lab.github.pages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.PageElement;
import com.epam.lab.utils.DriverManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPageGithub extends PageObject {

    private Boolean statusLoad;
    @Name("Sort type button")
    @FindBy(className = "js-select-button")
    private PageElement sortType;

    @Name("Fewest-Stars")
    @FindBy(css = ".select-menu-list>a:nth-child(3)")
    private PageElement sortFewestStars;

    @Name("Check sort")
    @FindBy(xpath = "//span[@class='js-select-button']")
    private PageElement checkSort;

    public void clickSortBtn() {
        sortType.click();
    }

    public void changeSort() {
        sortFewestStars.click();
    }

    public boolean checkChangeSortSuccess() {
        if (DriverManager.newWait().until(ExpectedConditions.visibilityOf(checkSort)).getText().contains("Fewest stars")) {
            statusLoad = true;
        }
        return statusLoad;
    }
}
