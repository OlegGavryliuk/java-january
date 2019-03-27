package com.socks.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.exemple.model.UserPayload;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.testng.annotations.Test;


public class TestClass extends BaseUiTest {


    @Test
    public void Test(){
        Selenide.open("https://www.google.com.ua/");
        Selenide.sleep(5000);
    }





}