package com.gglobal.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage {

  private static final Logger LOG = LogManager.getLogger(LoginPage.class);

  public LoginPage() {
    super();
  }

  public void getMainUrl(String baseUrl) {
    driver.get(baseUrl);
  }

  public String verifyIminMainURL() {
    return driver.getTitle();
  }

}