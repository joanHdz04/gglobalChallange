package com.gglobal.utils;

public interface Constants {

  String BASE_URL = "https://staging-client-wms.g-global.io/login";
  String EMAIL_LOGIN_INPUT = "email";
  String PASS_LOGIN_INPUT = "password";
  String LOGIN_BUTTON = "//button[span[text()='Login']]";
  String TOASTIFY_ALERT = "Toastify__toast-body";
  String EMAIL_MSG = "//form/div/div[2]/div/p";
  String PASS_MSG = "//form/div/div[3]/div/p";
  String FORGOT_PASS_BUTTON = "//span[text()='Forgot password?']";
  String FORGOT_PASS_CANCEL = "//button[span[text()='Cancel']]";
  String FORGOT_PASS_SEND = "//button[span[text()='Send']]";
  String FORGOT_PASS_GO_TO_LOGIN = "//button[span[text()='Go to Login']]";
  String LINK_SENT_MSG = "//*[@id='root']/div[1]/div/div/div[4]/p";
  String LINK_SENT_TO_MAIL = "//*[@id='root']/div[1]/div/div/div[4]/b";
  String SEND_EMAIL_INPUT = "//form/div/div[3]/div/div/input";
  String SEND_EMAIL_INPUT_ERROR = "//form/div/div[3]/div/p";
  String WELCOME_HEADER = "//form/div/div[1]/h6/div/b[2]";

}
