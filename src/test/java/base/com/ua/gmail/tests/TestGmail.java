package base.com.ua.gmail.tests;

import base.com.ua.gmail.bo.GmailLoginPageBO;
import base.com.ua.gmail.bo.GmailWriteMessageBO;
import base.com.ua.gmail.dataProvider.DataProviderGmail;
import base.com.ua.gmail.dto.UserModelGmail;
import base.com.ua.listeners.CustomListener;
import base.com.ua.utils.DriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static base.com.ua.utils.Constants.LINK_GMAIL;
import static base.com.ua.utils.Constants.PATH_LOG4J;

@Listeners({CustomListener.class})
public class TestGmail {
  private GmailLoginPageBO gmailLoginPageBO;
  private GmailWriteMessageBO gmailWriteMessageBO;

  @BeforeMethod
  public void createInstance() {
    DriverManager.load(LINK_GMAIL);
    PropertyConfigurator.configure(PATH_LOG4J);
    gmailLoginPageBO = new GmailLoginPageBO();
    gmailWriteMessageBO = new GmailWriteMessageBO();
  }

  @Test(dataProvider = "getData", dataProviderClass = DataProviderGmail.class)
  public void createAndSendMessage(UserModelGmail user) {
    gmailLoginPageBO.login(user);
    gmailWriteMessageBO.writeMessage(user);
    gmailWriteMessageBO.sendMessage();
  }

  @AfterMethod
  public void close() {

    DriverManager.removeDriver();
  }
}
