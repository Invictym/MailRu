package framework.ui;

import framework.BaseElement;
import org.openqa.selenium.By;

public class Tab extends BaseElement {

  private final static String TAB_NAME = " tab";

  public Tab(By locator, String name) {
    super(locator, name + TAB_NAME);
  }
}
