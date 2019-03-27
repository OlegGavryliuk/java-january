package com.socks.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.exemple.model.UserPayload;
import com.exemple.services.UserApiService_v1;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class TestLogin extends BaseUiTest {

//
//    @Test
//    public void userCanLogin(){
//        //given
//        UserPayload userPayload = createNewUser();
//
//        //when
//        MainPage.open().loginAs(userPayload.getUsername(), userPayload.getPassword());
//
////        MainPage mainPage = open("http://142.93.90.9/", MainPage.class);
////        LoggedUserPage loggedUserPage = mainPage.loginAs(userPayload.getUsername(), userPayload.getPassword());
//
//        //then
//        at(LoggedUserPage.class).logoutBtn().shouldHave(Condition.text("Logout"));
//
//    }





}