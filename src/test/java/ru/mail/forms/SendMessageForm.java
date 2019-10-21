package ru.mail.forms;

import framework.BaseForm;
import framework.ui.Label;
import org.openqa.selenium.By;

public class SendMessageForm extends BaseForm {

  private static final By messageSentForm = By.xpath("//div[contains(@class, 'layer-sent-page')]");

  public SendMessageForm() {
    super(messageSentForm, "Send message result");
  }

  public boolean isDisplayed() {
    return new Label(messageSentForm, "Send message form").elementIsDisplayed();
  }
}