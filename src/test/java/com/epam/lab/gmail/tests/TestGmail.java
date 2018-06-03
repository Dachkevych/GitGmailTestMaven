package com.epam.lab.gmail.tests;

import com.epam.lab.gmail.bo.GmailLoginPageBO;
import com.epam.lab.gmail.bo.GmailWriteMessageBO;
import com.epam.lab.gmail.dataProvider.DataProviderGmail;
import com.epam.lab.gmail.dataobject.UserModelGmail;
import com.epam.lab.utils.DriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import static com.epam.lab.utils.Constants.*;
import static org.testng.Assert.assertTrue;

public class TestGmail {

    private GmailLoginPageBO gmailLoginPageBO;
    private GmailWriteMessageBO gmailWriteMessageBO;

    @BeforeClass
    public void createInstance() {
        DriverManager.getDriver().get(LINK_GMAIL);
        PropertyConfigurator.configure(PATH_LOG4J);
        gmailLoginPageBO = new GmailLoginPageBO();
        gmailWriteMessageBO = new GmailWriteMessageBO();
    }

    @Test(dataProvider = GMAIL_PROVIDER, dataProviderClass = DataProviderGmail.class)
    public void createAndSendMessage(UserModelGmail user) {
        gmailLoginPageBO.login(user);
        assertTrue(gmailLoginPageBO.checkLoginSuccess());

        gmailWriteMessageBO.writeMessage(user);
        gmailWriteMessageBO.sendMessage();
        assertTrue(gmailWriteMessageBO.checkSentMessage());
    }

    @AfterClass
    public void close() {
        DriverManager.removeDriver();
    }
}
