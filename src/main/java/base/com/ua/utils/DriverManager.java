package base.com.ua.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

  private static ThreadLocal<WebDriver> driver =
      ThreadLocal.withInitial(
          () -> {
            System.setProperty(
                ConfigProperties.getTestProperty("driverType"),
                ConfigProperties.getTestProperty("driverPath"));
            return new ChromeDriver();
          });

  private DriverManager() {}

  public static void load(String URL) {
    getDriver().get(URL);
  }

  public static WebDriver getDriver() {
    return driver.get();
  }

  public static void removeDriver() {
    driver.get().quit();
    driver.remove();
  }

  public static WebDriverWait newWait() {
    return new WebDriverWait(getDriver(), 15);
  }
}
