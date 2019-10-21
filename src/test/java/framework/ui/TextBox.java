package framework.ui;

import framework.BaseElement;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {

  private static final String TEXT_BOX = " text box";

  public TextBox(By locator, String name) {
    super(locator, name + TEXT_BOX);
  }


}
