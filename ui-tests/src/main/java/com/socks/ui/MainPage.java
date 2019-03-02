package com.socks.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step
    public static MainPage open(){
        Selenide.open("/");
        return new MainPage();
    }

    @Step
    public void loginAs(String username, String password){
        $("#login > a").click();
        $("#username-modal").sendKeys(username);
        $("#password-modal").sendKeys(password);
        $("#login-modal p button").click();

    }



}
