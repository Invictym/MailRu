package framework.ui;

import framework.BaseElement;
import org.openqa.selenium.By;

public class Input extends BaseElement {

  private final static String INPUT_NAME = " input";

  public Input(By loc, String nameOf) {
    super(loc, nameOf + INPUT_NAME);
  }
}
