package com.epam.lab.github.bo;

import com.epam.lab.github.pages.MainPageGithub;
import org.apache.log4j.Logger;

public class GithubSearchPageBO {
    private static final Logger LOGGER = Logger.getLogger(GithubSearchPageBO.class);
    private MainPageGithub mainPageGithub = new MainPageGithub();
    private int countTag;
    private int countResultTag;

    public void findProjectsByName(String name) {
        mainPageGithub.inputSearch(name);
    }

    public void verifyTagName(final String tagName) {
        getResultCount();
        countTag = getCountTagName(tagName);
        countResultTag = mainPageGithub.getLists().size();
        LOGGER.info("Result verify tag: " + countTag + " from " + countResultTag + " tags contains tag - " + tagName);
    }

    public void getResultCount() {
        LOGGER.info(mainPageGithub.getAmountSearchResult().getText());
    }

    public boolean checkSiginSuccess() {
        return mainPageGithub.checkSiginSuccess();
    }

    private int getCountTagName(String tagName) {
        return ((int) mainPageGithub.getLists().stream().filter(el -> el.getText().contains(tagName)).count());
    }

    public int verifyCountTag(String tagName) {
        return getCountTagName(tagName);
    }
}
