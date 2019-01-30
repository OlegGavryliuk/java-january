package com.example.tests;

import com.exemple.model.UserPayload;
import com.exemple.services.UserApiService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class UserApiTestsNew {

    private final UserApiService userApiService = new UserApiService();

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://142.93.90.9/";
    }


    /* POST */
    /* Проверка регистрации нового юзера */
    @Test()
    void testCanRegisterUser(){
        UserPayload userPayload = new UserPayload()
                .setUsername(RandomStringUtils.randomAlphanumeric(6))
                .setPassword("12345")
                .setEmail("user@gmail.com");

        userApiService.registerUser(userPayload)
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }

    @Test()
    void testCanNotRegisterUser(){
        UserPayload userPayload = new UserPayload()
                .setEmail("user@gmail.com");

        userApiService.registerUser(userPayload)
                .assertThat()
                .statusCode(200) 
                .body("id", not(isEmptyString()));
    }


//23 minute


}

