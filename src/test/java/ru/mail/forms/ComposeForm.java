package ru.mail.forms;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.Input;
import org.openqa.selenium.By;

public class ComposeForm extends BaseForm {

  private Input toInput = new Input(By.xpath("//div[contains(@class, 'contacts')]//input"), "To ");
  private Button sendButton = new Button(By.xpath("//div[contains(@class, 'compose-app__buttons')]//span[contains(@data-title-shortcut, 'Ctrl+Enter')]"), "Send email");
  private Input bodyInput = new Input(By.xpath("//div[contains(@class, 'editable') and @role]"), "Body");

  public ComposeForm() {
    super(By.xpath("//div[contains(@class, 'ompose-app_popup')]"), "Compose form");
  }

  public void sendEmail(String to, String body) {
    toInput.sendKey(to);
    bodyInput.clear();
    bodyInput.sendKey(body);
    sendButton.click();
  }
}
