package ru.mail.forms;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.Input;
import org.openqa.selenium.By;

public class LoginForm extends BaseForm {

  private Input loginInput = new Input(By.id("mailbox:login"), "Login");
  private Button submitButton = new Button(By.id("mailbox:submit"), "Submit");
  private Input passwordInput = new Input(By.id("mailbox:password"), "Password field");

  public LoginForm() {
    super(By.id("mailbox-container"), "Login form");
  }

  public void login(String login, String password) {
    loginInput.sendKey(login);
    submitButton.click();
    passwordInput.sendKey(password);
    submitButton.click();
  }
}
