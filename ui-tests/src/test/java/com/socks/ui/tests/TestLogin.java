package com.socks.ui.tests;

import com.codeborne.selenide.Selenide;
import com.exemple.services.UserApiService_v2;
import org.testng.annotations.Test;


public class TestLogin {

  private UserApiService_v2 userApiService = new UserApiService_v2();

  @Test
  public void userCanLogin(){

      userApiService.canRegisterUser();

      Selenide.open("http://142.93.90.9/");
      Selenide.$("#login > a").click();
      Selenide.$("#username-modal").sendKeys("");
      Selenide.$("#password-modal").sendKeys("");
      Selenide.$("#login-modal p button").click();

  }
  //27:09

}
