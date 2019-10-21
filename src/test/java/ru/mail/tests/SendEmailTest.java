package ru.mail.tests;

import framework.BaseTest;
import framework.utils.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mail.forms.ComposeForm;
import ru.mail.forms.InboxForm;
import ru.mail.forms.MailRuMainForm;
import ru.mail.forms.SendMessageForm;

public class SendEmailTest extends BaseTest {

  @Test
  public void sendEmailTest() {
    Log.step("Login to mail.ru");
    MailRuMainForm mailRuMainForm = new MailRuMainForm();
    mailRuMainForm.login(parameters.get("login"), parameters.get("password"));

    Log.step("Write email");
    InboxForm inboxForm = new InboxForm();
    inboxForm.openWriteLetter();

    ComposeForm composeForm = new ComposeForm();
    composeForm.sendEmail(parameters.get("to"), parameters.get("body"));

    Log.step("Check is email sanded");
    SendMessageForm messageForm = new SendMessageForm();
    Assert.assertTrue(messageForm.isDisplayed(), "Message don't send");
  }
}
