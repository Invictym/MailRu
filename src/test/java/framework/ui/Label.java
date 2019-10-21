package framework.ui;

import framework.BaseElement;
import org.openqa.selenium.By;

public class Label extends BaseElement {

  private final static String LABEL_NAME = " label";

  public Label(By locator, String name) {
    super(locator, name + LABEL_NAME);
  }

}
