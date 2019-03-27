package com.socks.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.exemple.model.UserPayload;
import com.exemple.services.UserApiService_v1;
//import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;


import java.util.Locale;

public class BaseUiTest {

    @BeforeClass
    public void setUp(){
        //RestAssured.baseURI = "http://142.93.90.9/";
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        Configuration.browser = "SelenoidWebDriverProvider";
        Configuration.browserSize = "1366x768";
        Configuration.baseUrl = "https://www.google.com.ua/";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }

//    private UserApiService_v1 userApiService_v1 = new UserApiService_v1();
//
//    //protected final Faker faker = new Faker(new Locale(""));
//
//    @Step
//    protected <T> T at(Class<T> pageClass){
//        return Selenide.page(pageClass);
//    }
//
//    protected UserPayload createNewUser() {
//        UserPayload userPayload = new UserPayload()
//                .setUsername(RandomStringUtils.randomAlphanumeric(6))
//                .setPassword("12345")
//                .setEmail("user@gmail.com");
//        userApiService_v1.registerUser(userPayload);
//        return userPayload;
//    }
}
