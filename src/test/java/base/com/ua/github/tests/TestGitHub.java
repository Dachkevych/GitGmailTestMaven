package base.com.ua.github.tests;

import base.com.ua.github.bo.GithubLoginPageBO;
import base.com.ua.github.bo.GithubSearchPageBO;
import base.com.ua.github.dataProvider.DataProviderGithub;
import base.com.ua.github.dto.UserModelGithub;
import base.com.ua.listeners.CustomListener;
import base.com.ua.utils.DriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static base.com.ua.utils.Constants.*;
import static org.testng.Assert.assertTrue;

@Listeners({CustomListener.class})
public class TestGitHub {

  SoftAssert softAssert;
  private GithubSearchPageBO githubSearchPageBO;
  private GithubLoginPageBO githubLoginPageBO;

  @BeforeClass
  public void createInstance() {
    DriverManager.load(LINK_GITHUB);
    PropertyConfigurator.configure(PATH_LOG4J);
    githubSearchPageBO = new GithubSearchPageBO();
    githubLoginPageBO = new GithubLoginPageBO();
    softAssert = new SoftAssert();
  }

  /*
  Test's going to fail
   */
  @Test(dataProvider = GIT_PROVIDE, dataProviderClass = DataProviderGithub.class)
  public void logIn(UserModelGithub user) {
    githubLoginPageBO.login(user);
    assertTrue(githubSearchPageBO.checkSiginSuccess());

    githubSearchPageBO.findProjectsByName(SELENIUM_JAVA);
    githubSearchPageBO.verifyTagName(SELENIUM);
    softAssert.assertEquals(githubSearchPageBO.verifyCountTag(SELENIUM), LIST_SIZE);

    githubSearchPageBO.findProjectsByName(SELENIUM_JAVA);
    githubSearchPageBO.verifyTagName(SELENIUM);
    softAssert.assertEquals(githubSearchPageBO.verifyCountTag(SELENIUM), LIST_SIZE);

    githubSearchPageBO.findProjectsByName(CUCUMBER_JAVA);
    githubSearchPageBO.verifyTagName(CUCUMBER);
    softAssert.assertEquals(githubSearchPageBO.verifyCountTag(CUCUMBER), LIST_SIZE);

    githubSearchPageBO.findProjectsByName(TESTNG_JAVA);
    githubSearchPageBO.verifyTagName(TESTNG);
    softAssert.assertEquals(githubSearchPageBO.verifyCountTag(TESTNG), LIST_SIZE);

    githubSearchPageBO.findProjectsByName(JUNIT_JAVA);
    githubSearchPageBO.verifyTagName(JUNIT);
    softAssert.assertEquals(githubSearchPageBO.verifyCountTag(JUNIT), LIST_SIZE);
    softAssert.assertAll();
  }

  @AfterClass
  public void kill() {
    DriverManager.removeDriver();
  }
}
