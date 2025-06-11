package com.gglobal.stepDefinitions;

import com.gglobal.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class StepDefinitions {

  private LoginPage loginPage = new LoginPage();

  @Given("User goes to start url {string}")
  public void goToStartUrl(String baseUrl) {

    loginPage.getMainUrl(baseUrl);
  }

  @Then("User is on start url {string}")
  public void verifyLogin(String startURLExpected) {

    Assert.assertEquals(loginPage.verifyIminMainURL(), startURLExpected);
  }

}
