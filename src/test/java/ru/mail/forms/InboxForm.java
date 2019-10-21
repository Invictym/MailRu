package ru.mail.forms;

import framework.BaseForm;
import framework.ui.Button;
import org.openqa.selenium.By;

public class InboxForm extends BaseForm {

  private Button writeEmailButton = new Button(By.xpath("//span[contains(@class, 'compose-button') and @title]"), "Write email");

  public InboxForm() {
    super(By.xpath("//div[contains(@class, 'letter-list')]"), "Inbox");
  }

  public void openWriteLetter() {
    writeEmailButton.click();
  }
}
