package ru.mail.forms;

import framework.BaseForm;
import org.openqa.selenium.By;

public class MailRuMainForm extends BaseForm {

  private LoginForm loginForm = new LoginForm();

  public MailRuMainForm() {
    super(By.xpath("//div[@id='logo']//a[@href='//mail.ru']"), "Main form");
  }

  public void login(String login, String password) {
    loginForm.login(login, password);
  }
}
