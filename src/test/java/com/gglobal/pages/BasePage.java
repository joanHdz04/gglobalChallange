package com.gglobal.pages;

import com.gglobal.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  WebDriver driver;

  public BasePage() {
    this.driver = DriverUtils.getDriver();
    PageFactory.initElements(driver, this);
  }

  public void hoverOption(WebElement element) {
    Actions builderHoverOption = new Actions(driver);
    Actions hoverOverOption = builderHoverOption.moveToElement(element);
    hoverOverOption.perform();
  }
}
