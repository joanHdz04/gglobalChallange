package com.gglobal.pages;

import static com.gglobal.utils.Constants.TOASTIFY_ALERT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GGlobalCommons extends BasePage {

  private static final Logger LOG = LogManager.getLogger(GGlobalCommons.class);

  @FindBy(className = TOASTIFY_ALERT)
  WebElement alert;

  public String getPageAlert(){
      return getAlertMsg(alert);
  }

  public void getUrl(String url) {
    driver.get(url);
  }

 }
