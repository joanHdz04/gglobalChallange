package com.gglobal.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

  private static final Logger LOG = LogManager.getLogger(DriverUtils.class);
  private static WebDriver driver;
  private static WebDriverWait wait;
  public final static int TIMEOUT = 5;
  ChromeOptions options = new ChromeOptions();

  public DriverUtils(String browser) {
    switch (browser) {
      case "chrome":
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        LOG.info("Using chrome browser");
        break;
      default:
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        LOG.info("Add default browser here");
        break;
    }
    LOG.info("=============>" + driver.getTitle());
  }

  public static void delay(int seconds) throws InterruptedException {
    TimeUnit.SECONDS.sleep(seconds);
  }

  public void closeDriver() {
    driver.quit();
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public static WebDriverWait getWait() {
    return wait;
  }

  public void changeSize(String size, int width, int height) {
    switch (size) {
      case "fullscreen":
        driver.manage().window().fullscreen();
        LOG.info("==> Windows size:  fullScreen");
        break;
      case "customized":
        driver.manage().window().setSize(new Dimension(width, height));
        LOG.info("==> Windows size: " + width + " x " + height);
        break;
      case "maximize":
        driver.manage().window().maximize();
        LOG.info("==> Windows size:  maximize");
        break;
      default:
        LOG.info("==> Windows size:  default");
        break;
    }
  }
}