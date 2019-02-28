package com.socks.ui;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public LoggedUserPage loginAs(String username, String password){
        $("#login > a").click();
        $("#username-modal").sendKeys(username);
        $("#password-modal").sendKeys(password);
        $("#login-modal p button").click();

        return new LoggedUserPage();
    }



}
