package com.gglobal.stepDefinitions;

import com.gglobal.utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

  DriverUtils driverUtils;

  @Before
  public void setUp() {
    driverUtils = new DriverUtils("chrome");
  }

  @After
  public void teardown() {
    driverUtils.closeDriver();
  }

}
