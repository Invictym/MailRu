package framework;

import framework.utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BaseElement extends BaseEntity {

  private By locator;
  private String name;

  protected BaseElement(final By loc, final String nameOf) {
    locator = loc;
    name = nameOf;
  }

  private void waitForElementPresent() {
    Log.debug(name, "wait for element present");
    try {
    new WebDriverWait(getBrowser().getDriver(), Integer.parseInt(fileWorker.getProperties("timeout")))
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    } catch (TimeoutException ex) {
      Log.debug("Element not visible");
    }
  }

  private void waitUntilClickable() {
      new WebDriverWait(getBrowser().getDriver(), Integer.parseInt(fileWorker.getProperties("timeout")))
          .until(ExpectedConditions.elementToBeClickable(locator));

  }

  public void click() {
    waitForElementPresent();
    int attempts = 0;
    boolean result = false;
    String text = null;
    while (attempts < 2) {
      try {
        waitUntilClickable();
        getBrowser().getDriver().findElement(locator).click();
        result = true;
        break;
      } catch (ElementClickInterceptedException e) {
        Log.debug(name, "element not found");
      }
      attempts++;
    }
    Assert.assertTrue(result);
    Log.debug(name, "click");
  }

  public String getText() {
    Log.debug(name, "get text from element");
    int attempts = 0;
    boolean result = false;
    String text = null;
    while (attempts < 2) {
      try {
        text = getBrowser().getDriver().findElement(locator).getText();
        result = true;
        break;
      } catch (StaleElementReferenceException e) {
        Log.debug(name, "element not found");
      }
      attempts++;
    }
    Assert.assertTrue(result);
    Log.debug(name, "text in element: " + text);
    return text;
  }

  public By getLocator() {
    return locator;
  }

  public boolean elementIsDisplayed() {
    Log.debug(name, "check is element displayed");
    return getBrowser().getDriver().findElement(locator).isDisplayed();
  }

  public void clear() {
    waitForElementPresent();
    getBrowser().getDriver().findElement(locator).clear();
    Log.debug(name, "clear text");
  }

  public void sendKey(String key) {
    waitForElementPresent();
    getBrowser().getDriver().findElement(locator).sendKeys(key);
    Log.debug(name, "set text: " + key);
  }

  public void sendKeyJs(String key) {
    WebElement element = getBrowser().getDriver().findElement(locator);
    ((JavascriptExecutor) getBrowser().getDriver()).executeScript("document.querySelector(\"" + locator.toString() + "\").value='" + key + "'");
    Log.debug(name, "set text: " + key);
  }
}
