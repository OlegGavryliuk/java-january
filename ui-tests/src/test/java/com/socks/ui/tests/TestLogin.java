package com.socks.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.exemple.model.UserPayload;
import com.exemple.services.UserApiService_v2;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestLogin {

  private UserApiService_v2 userApiService_v2 = new UserApiService_v2();

  @BeforeClass
  public void setUp(){
      RestAssured.baseURI = "http://142.93.90.9/";
      Configuration.browser = "chrome";
  }

  @Test
  public void userCanLogin(){

      userApiService_v2.canRegisterUser();
      UserPayload userPayload = new UserPayload();

      Selenide.open("http://142.93.90.9/");
      Selenide.$("#login > a").click();
      Selenide.$("#username-modal").sendKeys(userPayload.getUsername());
      Selenide.$("#password-modal").sendKeys(userPayload.getPassword());
      Selenide.$("#login-modal p button").click();

  }

//29
    //33
}
