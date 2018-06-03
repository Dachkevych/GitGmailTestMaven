package com.epam.lab.github.tests;

import com.epam.lab.github.bo.GithubLoginPageBO;
import com.epam.lab.github.bo.GithubSearchPageBO;
import com.epam.lab.github.dataProvider.DataProviderGithub;
import com.epam.lab.github.dataobject.UserModelGithub;
import com.epam.lab.utils.DriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import static com.epam.lab.utils.Constants.*;
import static org.testng.Assert.assertTrue;

public class TestGitHub {

    private GithubSearchPageBO githubSearchPageBO;
    private GithubLoginPageBO githubLoginPageBO;

    @BeforeClass
    public void createInstance() {
        DriverManager.getDriver().get(LINK_GITHUB);
        PropertyConfigurator.configure(PATH_LOG4J);
        githubSearchPageBO = new GithubSearchPageBO();
        githubLoginPageBO = new GithubLoginPageBO();
    }

    @Test(dataProvider = GIT_PROVIDE, dataProviderClass = DataProviderGithub.class)
    public void findAndVerifyTagName(UserModelGithub user) {
        githubLoginPageBO.login(user);
        assertTrue(githubSearchPageBO.checkSiginSuccess());

        githubSearchPageBO.findProjectsByName(SELENIUM_JAVA);
        githubSearchPageBO.changeSort();
        assertTrue(githubSearchPageBO.checkChangeSortSuccess());

        githubSearchPageBO.verifyTagName(SELENIUM);
        githubSearchPageBO.findProjectsByName(SPRING_JAVA);
        githubSearchPageBO.verifyTagName(SPRING);
    }

    @AfterClass
    public void kill() {
        DriverManager.removeDriver();
    }
}
