package com.example.tests;

import com.exemple.services.UserApiService_v2;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserApiTests_v2 {

    private final UserApiService_v2 userApiService_v2 = new UserApiService_v2();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://142.93.90.9/";
    }


    @Test()
    @Description("POST. Check user registration with correct data.")
    void _1_testCanRegisterUser() {
        userApiService_v2.canRegisterUser();
    }

    @Test()
    @Description("POST. Check user registration with incorrect data.")
    void _2_testCanNotRegisterUser(){
        userApiService_v2.canNotRegisterUser();
    }

    @Test()
    @Description("GET. Check the existence of the user ID.")
    void _3_testCanGetCustomer() {
        userApiService_v2.canGetCustomer();
    }

    @Test()
    @Description("DELETE. User removal check.")
    void testCanDeleteUser(){
        userApiService_v2.deleteUser();
    }

}

