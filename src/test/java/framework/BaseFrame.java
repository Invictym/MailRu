package framework;

import framework.utils.Log;
import org.openqa.selenium.By;

public class BaseFrame extends BaseEntity {

  protected By frameLocator;

  public BaseFrame(By frameLocator) {
    this.frameLocator = frameLocator;
  }

  protected void switchToFrame() {
    Log.debug("Switch to frame");
    getBrowser().getDriver().switchTo().frame(getBrowser().getDriver().findElement(frameLocator));
  }

  protected void exitFromFrame() {
    Log.debug("Switch to default content");
    getBrowser().getDriver().switchTo().defaultContent();
  }
}
