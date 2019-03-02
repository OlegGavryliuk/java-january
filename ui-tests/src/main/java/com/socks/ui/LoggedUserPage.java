package com.socks.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPage {

    @Step
    public SelenideElement logoutBtn(){
        return $("#logout > a");
    }

}
