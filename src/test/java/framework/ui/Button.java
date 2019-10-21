package framework.ui;

import framework.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {

  private final static String BUTTON_NAME = " button";

  public Button(By locator, String name) {
    super(locator, name + BUTTON_NAME);
  }
}
