package framework;

import framework.ui.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class BaseForm extends BaseEntity {

  public String title;

  public BaseForm(final By formLocator, final String formTitle) {
    title = formTitle;
    Label titlePicture = new Label(formLocator, title);
    Assert.assertTrue(titlePicture.elementIsDisplayed());
  }
}

