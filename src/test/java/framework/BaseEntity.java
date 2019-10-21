package framework;

import framework.browser.Browser;
import framework.utils.FileWorker;
import framework.utils.Log;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntity {

  FileWorker fileWorker = new FileWorker("config.properties");

  @BeforeSuite
  public void init() {
    String url = fileWorker.getProperties("url");
    Log.info("Open page: " + url);
    getBrowser().navigate(url);
  }

  protected Browser getBrowser() {
    return Browser.getBrowser();
  }

  @AfterSuite(alwaysRun = true)
  public void exit() {
    getBrowser().getDriver().quit();
  }

  public void openNewWindow() {
    new WebDriverWait(getBrowser().getDriver(), Integer.parseInt(fileWorker.getProperties("timeout")))
        .until(driver -> new ArrayList<String>(driver.getWindowHandles()).size() > 1);
    List<String> tabs2 = new ArrayList<String>(getBrowser().getDriver().getWindowHandles());
    getBrowser().getDriver().switchTo().window(tabs2.get(1));
  }
}
