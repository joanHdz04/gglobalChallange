package com.gglobal.stepDefinitions;

import com.gglobal.pages.GGlobalCommons;
import com.gglobal.pages.LoginPage;
import com.gglobal.pages.NavBarPage;
import com.gglobal.pages.ReturnsPage;
import com.gglobal.utils.DriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinitions {

  private LoginPage loginPage = new LoginPage();
  private GGlobalCommons gGlobalCommons =new GGlobalCommons();
  private NavBarPage navBarPage = new NavBarPage();
  private ReturnsPage returnsPage = new ReturnsPage();

  @Given("user goes to the start url {string}")
  public void goToStartUrl(String baseUrl) {
    gGlobalCommons.getUrl(baseUrl);
  }

  @When("user writes an existing email into input")
  public void putValidUser(){
    loginPage.setUser(System.getProperty("portal.user"));
  }

  @When("user writes the correct password into input")
  public void putCorrectPass(){
    loginPage.setPassword(System.getProperty("portal.pass"));
  }

  @When("user clicks on the login button")
  public void clickLogin(){
    loginPage.login();
  }

  @When("user writes {string} into email input")
  public void putUser(String user){
    loginPage.setUser(user);
  }

  @When("user writes {string} into password input")
  public void putPass(String pass){
    loginPage.setPassword(pass);
  }

  @When("user clicks on forgot password button")
  public void forgotPassBtn(){
    loginPage.forgotPassClick();
  }

  @When("user clicks on cancel button in forgot password page")
  public void cancelBtnForgotPass(){
    loginPage.cancelForgotPasswordClick();
  }

  @When("user writes {string} in sendEmail input")
  public void setSendEmailInput(String email){
    loginPage.setSendEmailInput(email);
  }

  @When("user clicks on sendEmail button")
  public void clickSendEmail(){
    loginPage.sendEmailBtnClick();
  }

  @When("user clicks on backToLogin button")
  public void clickBackToLogin(){
    loginPage.backToLoginClick();
  }

  @When("user sees success login alert")
  public void successLogin(){
    gGlobalCommons.getPageAlert();
  }
  @When("user clicks on returns on navigation bar")
  public void clickOnReturnsInNavBar(){
    navBarPage.navBarReturnsClick();
  }

  @When("user writes {string} in RMA number field")
  public void setRMANumber(String rmaNumber){
    returnsPage.setRmaInput(rmaNumber+"\n");
  }

  @When("user writes {string} in tracking field")
  public void setTrackingNumber(String tracking){
    returnsPage.setTrackingInput(tracking+"\n");
  }
  @Then("user is now on {string} page")
  public void validateCurrentPage(String expectedPage){
    String actualPage= DriverUtils.getDriver().getCurrentUrl();

    Assert.assertEquals(actualPage,expectedPage);
  }

  @Then("alert display the message {string}")
  public void validatePageAlert(String alertMsg){
    Assert.assertTrue(gGlobalCommons.getPageAlert().contains(alertMsg));
  }

  @Then("the input {string} shows the error message {string} below")
  public void validateInputErrorMsg(String input, String inputErrorMsg){
    Assert.assertTrue(loginPage.getInputErrorMsg(input).contains(inputErrorMsg));
  }

  @Then("the input {string} error message is not displayed")
  public void validateInputErrorMsg(String input){
    Assert.assertFalse(loginPage.errorMsgVisibility(input));
  }

  @Then("user see the {string} header")
  public void validatePageHeadLine(String header){
    Assert.assertTrue(loginPage.getWelcomeHeader().contains(header));
  }

  @Then("the input sendEmail shows the error message {string} below")
  public void validateSendEmailErrorMsg(String inputErrorMsg){
    Assert.assertTrue(loginPage.getSendEmailErrorMsg(inputErrorMsg).contains(inputErrorMsg));
  }

  @Then("the send button is not enabled")
  public void validateSendButtonIsEnabled(){
    Assert.assertFalse(loginPage.isSendButtonEnabled());
  }

  @Then("the {string} {string} page is displayed")
  public void validateMailSentMsg(String msg, String mail){
    String expected = msg+mail;
    String actual= loginPage.getLinkSentMsgTxt()+loginPage.getlinkSentMailTxt();
    Assert.assertEquals(actual,expected);
  }

  @Then("the data table displays {string} in the {string} column in the {int} row")
  public void validateDataTable(String data, String columnName, int row){
    Assert.assertEquals(returnsPage.getDataTableCell(columnName,row-1,1),data);
  }

}
