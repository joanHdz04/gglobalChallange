package com.gglobal.pages;

import static com.gglobal.utils.Constants.EMAIL_LOGIN_INPUT;
import static com.gglobal.utils.Constants.EMAIL_MSG;
import static com.gglobal.utils.Constants.FORGOT_PASS_BUTTON;
import static com.gglobal.utils.Constants.FORGOT_PASS_CANCEL;
import static com.gglobal.utils.Constants.FORGOT_PASS_GO_TO_LOGIN;
import static com.gglobal.utils.Constants.FORGOT_PASS_SEND;
import static com.gglobal.utils.Constants.LINK_SENT_MSG;
import static com.gglobal.utils.Constants.LINK_SENT_TO_MAIL;
import static com.gglobal.utils.Constants.LOGIN_BUTTON;
import static com.gglobal.utils.Constants.PASS_LOGIN_INPUT;
import static com.gglobal.utils.Constants.PASS_MSG;
import static com.gglobal.utils.Constants.SEND_EMAIL_INPUT;
import static com.gglobal.utils.Constants.SEND_EMAIL_INPUT_ERROR;
import static com.gglobal.utils.Constants.WELCOME_HEADER;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  private static final Logger LOG = LogManager.getLogger(LoginPage.class);

  @FindBy(name = EMAIL_LOGIN_INPUT)
  WebElement emailLoginInput;
  @FindBy(name = PASS_LOGIN_INPUT)
  WebElement passLoginInput;
  @FindBy(xpath = LOGIN_BUTTON)
  WebElement loginBtn;
  @FindBy(xpath= EMAIL_MSG)
  WebElement emailMsg;
  @FindBy(xpath= PASS_MSG)
  WebElement passMsg;
  @FindBy(xpath = FORGOT_PASS_BUTTON)
  WebElement forgotPassBtn;
  @FindBy(xpath = FORGOT_PASS_CANCEL)
  WebElement forgotPassCancel;
  @FindBy(xpath = FORGOT_PASS_SEND)
  WebElement forgotPassSend;
  @FindBy(xpath = FORGOT_PASS_GO_TO_LOGIN)
  WebElement forgotPassGoToLogin;
  @FindBy(xpath = LINK_SENT_MSG)
  WebElement linkSentMsg;
  @FindBy(xpath = LINK_SENT_TO_MAIL)
  WebElement linkSentMail;
  @FindBy(xpath = SEND_EMAIL_INPUT)
  WebElement sendEmailInput;
  @FindBy(xpath = SEND_EMAIL_INPUT_ERROR)
  WebElement sendMailInputError;
  @FindBy(xpath = WELCOME_HEADER)
  WebElement welcomeHeader;

  public LoginPage() {
    super();
  }

  public void setUser(String user) {
    emailLoginInput.sendKeys(Keys.CONTROL + "a");
    emailLoginInput.sendKeys(user);
  }

  public void setPassword(String password) {
    passLoginInput.sendKeys(Keys.CONTROL + "a");
    passLoginInput.sendKeys(password);
  }

  public String getInputErrorMsg(String input){
    LOG.info("Error in field:::: "+input);
    LOG.info("INPUT email TEXT:::"+emailLoginInput.getAttribute("value"));
    LOG.info("INPUT pass TEXT:::"+passLoginInput.getAttribute("value"));

    switch(input.toLowerCase()){
      case "email":
        return getTextIfVisible(emailMsg);
      case "password":
        return getTextIfVisible(passMsg);
      default:
        return "";
    }
  }

  public Boolean errorMsgVisibility(String input){
    LOG.info("Error in field:::: "+input);
    LOG.info("INPUT email TEXT:::"+emailLoginInput.getAttribute("value"));
    LOG.info("INPUT pass TEXT:::"+passLoginInput.getAttribute("value"));

    switch(input.toLowerCase()){
      case "email":
        return isElementPresent(emailMsg);
      case "password":
        return isElementPresent(passMsg);
      default:
        return true;
    }
  }
  public void login() {
    loginBtn.submit();
  }

  public void forgotPassClick(){
    forgotPassBtn.click();
  }

  public void cancelForgotPasswordClick(){
    clickIfVisible(forgotPassCancel);
  }

  public String getWelcomeHeader(){
    return getTextIfVisible(welcomeHeader);
  }

  public void setSendEmailInput(String email){
    sendEmailInput.sendKeys(email);
  }

  public String getSendEmailErrorMsg(String email){
    return getTextIfVisible(sendMailInputError);
  }

  public Boolean isSendButtonEnabled() {
    return forgotPassSend.isEnabled();
  }

  public void sendEmailBtnClick(){
    clickIfEnable(forgotPassSend);
  }
  public String getLinkSentMsgTxt(){
    return getTextIfVisible(linkSentMsg);
  }
  public String getlinkSentMailTxt(){
    return getTextIfVisible(linkSentMail);
  }
  public void backToLoginClick(){
    clickIfEnable(forgotPassGoToLogin);
  }
}