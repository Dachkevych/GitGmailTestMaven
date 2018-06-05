package com.epam.lab.gmail.tests;

import com.epam.lab.gmail.bo.GmailLoginPageBO;
import com.epam.lab.gmail.bo.GmailWriteMessageBO;
import com.epam.lab.gmail.dataProvider.DataProviderGmail;
import com.epam.lab.gmail.dataobject.UserModelGmail;
import com.epam.lab.listeners.CustomListener;
import com.epam.lab.utils.DriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.lab.utils.Constants.LINK_GMAIL;
import static com.epam.lab.utils.Constants.PATH_LOG4J;

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
