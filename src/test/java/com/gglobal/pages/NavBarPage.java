package com.gglobal.pages;

import static com.gglobal.utils.Constants.NAVBAR_DASHBOARD;
import static com.gglobal.utils.Constants.NAVBAR_INVENTORY;
import static com.gglobal.utils.Constants.NAVBAR_ORDERS_MONITOR;
import static com.gglobal.utils.Constants.NAVBAR_RETURNS;
import static com.gglobal.utils.Constants.NAVBAR_SHIPPING_NOTICES;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarPage extends BasePage {

  private static final Logger LOG = LogManager.getLogger(NavBarPage.class);

  @FindBy(xpath = NAVBAR_DASHBOARD)
  WebElement navBarDashboard;
  @FindBy(xpath = NAVBAR_ORDERS_MONITOR)
  WebElement navBarOrdersMonitor;
  @FindBy(xpath = NAVBAR_INVENTORY)
  WebElement navBarInventory;
  @FindBy(xpath = NAVBAR_SHIPPING_NOTICES)
  WebElement navBarShippingNotices;
  @FindBy(xpath = NAVBAR_RETURNS)
  WebElement navBarReturns;

  public void navBarDashboardClick(){
    navBarDashboard.click();
  }

  public void navBarOrdersClick(){
    navBarOrdersMonitor.click();
  }

  public void navBarInventoryClick(){
    navBarInventory.click();
  }

  public void navBarShippingNoticesClick(){
    navBarShippingNotices.click();
  }

  public void navBarReturnsClick(){
    navBarReturns.click();
  }

}
