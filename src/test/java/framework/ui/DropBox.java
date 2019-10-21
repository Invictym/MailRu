package framework.ui;

import framework.BaseElement;
import org.openqa.selenium.By;

public class DropBox extends BaseElement {

  private final static String DROP_BOX_NAME = " drop box";

  public DropBox(By locator, String name) {
    super(locator, name + DROP_BOX_NAME);
  }

}
