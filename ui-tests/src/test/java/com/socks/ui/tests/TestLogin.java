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

    private UserApiService_v1 userApiService_v1 = new UserApiService_v1();

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "http://142.93.90.9/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
    }

    @Test
    public void userCanLogin(){

        UserPayload userPayload = new UserPayload()
                .setUsername(RandomStringUtils.randomAlphanumeric(6))
                .setPassword("12345")
                .setEmail("user@gmail.com");
        userApiService_v1.registerUser(userPayload);

        MainPage mainPage = open("http://142.93.90.9/", MainPage.class);
        LoggedUserPage loggedUserPage = mainPage.loginAs(userPayload.getUsername(), userPayload.getPassword());


        loggedUserPage.logoutBtn.shouldHave(Condition.text("Logout"));

    }

    //29
    //33
    //41
}