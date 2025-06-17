package com.gglobal.pages;

import com.gglobal.utils.DriverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  WebDriver driver;
  WebDriverWait wait;

  public BasePage() {
    this.driver = DriverUtils.getDriver();
    this.wait = DriverUtils.getWait();
    PageFactory.initElements(driver, this);
  }

  public void hoverOption(WebElement element) {
    Actions builderHoverOption = new Actions(driver);
    Actions hoverOverOption = builderHoverOption.moveToElement(element);
    hoverOverOption.perform();
  }

  public String getAlertMsg(WebElement alert){
    wait.until(ExpectedConditions.visibilityOf(alert));
    String alertMsg = alert.getText();
    wait.until(ExpectedConditions.invisibilityOf(alert));
    return alertMsg;
  }

  public String getTextIfVisible(WebElement webElement){
    wait.until(ExpectedConditions.visibilityOf(webElement));
    return  webElement.getText();
  }

  public Boolean isElementPresent(WebElement webElement){
      try {
        return webElement.isDisplayed();
      } catch (NoSuchElementException e) {
        return false;
      }
   }

  public void clickIfVisible(WebElement webElement){
    wait.until(ExpectedConditions.visibilityOf(webElement));
    webElement.click();
  }

  public void clickIfEnable(WebElement webElement){
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
    webElement.click();
  }
}
