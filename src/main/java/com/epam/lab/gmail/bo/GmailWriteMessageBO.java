package com.epam.lab.gmail.bo;

import com.epam.lab.gmail.dataobject.UserModelGmail;
import com.epam.lab.gmail.pages.DraftPageGmail;
import com.epam.lab.gmail.pages.MainPageGmail;
import com.epam.lab.gmail.pages.MessagePageGmail;

public class GmailWriteMessageBO {

    private MainPageGmail mainPageGmail;
    private MessagePageGmail messagePageGmail;
    private DraftPageGmail draftPageGmail;

    public GmailWriteMessageBO() {
        mainPageGmail = new MainPageGmail();
        messagePageGmail = new MessagePageGmail();
        draftPageGmail = new DraftPageGmail();
    }

    public void writeMessage(UserModelGmail user) {
        mainPageGmail.clickComposeBtn();
        messagePageGmail.writeMessage(user.getReceiver(), user.getSubject(), user.getText());
        mainPageGmail.clickDraftBtn();
    }

    public void sendMessage() {
        draftPageGmail.clickLastDraft();
        draftPageGmail.clickSendDraft();
    }

    public boolean checkSentMessage() {
        return draftPageGmail.checkSentMessage();
    }
}
