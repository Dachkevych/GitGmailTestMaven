package com.epam.lab.github.bo;

import com.epam.lab.github.pages.MainPageGithub;
import com.epam.lab.github.pages.SearchPageGithub;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class GithubSearchPageBO {
    private static final Logger LOGGER = Logger.getLogger(GithubSearchPageBO.class);

    private MainPageGithub mainPageGithub = new MainPageGithub();
    private SearchPageGithub searchPageGithub = new SearchPageGithub();

    public void findProjectsByName(String name) {
        mainPageGithub.inputSearch(name);
    }

    public void changeSort() {
        searchPageGithub.clickSortBtn();
        searchPageGithub.changeSort();
    }

    public void verifyTagName(final String tagName) {
        LOGGER.info("----------------------------------------------------------------------------");
        getResultCount();
        int countTag = ((int) mainPageGithub.getLists().stream().filter(el -> el.getText().contains(tagName)).count());
        LOGGER.info("Result verify tag: " + countTag + " from " + mainPageGithub.getLists().size() + " tags contains tag - " + tagName);
        printResult(tagName);
    }

    public void printResult(final String tagName) {
        mainPageGithub.getLists().stream().filter(el -> el.getText().contains(tagName)).forEach(elm ->  LOGGER.info(elm.findElement(By.className("v-align-middle")).getText()));
    }

    public void getResultCount() {
        LOGGER.info(mainPageGithub.getAmountSearchResult().getText());
    }

    public boolean checkChangeSortSuccess() {
        return searchPageGithub.checkChangeSortSuccess();
    }

    public boolean checkSiginSuccess() {
        return mainPageGithub.checkSiginSuccess();
    }
}
