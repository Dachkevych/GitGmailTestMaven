package base.com.ua.gmail.bo;

import base.com.ua.gmail.dto.UserModelGmail;
import base.com.ua.gmail.pages.DraftPageGmail;
import base.com.ua.gmail.pages.MainPageGmail;
import base.com.ua.gmail.pages.MessagePageGmail;

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
