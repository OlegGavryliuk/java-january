package com.example.tests;

import com.exemple.model.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.*;

public class UserApiTests {

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

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(userPayload)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(isEmptyString()));
    }



    /* GET */
    /* Проверка существования юзера по ИД */
    @Test()
    void testCanGetCustomer(){
        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured
                .when()
                .get("customers")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body("_embedded.customer.id",hasItems("5c48c0cfee11cb0001fa6644"));
    }

    /* GET */
    /* Проверка существования кредитной карты по ИД юзера */
    @Test()
    void testCanGetCards(){
        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured
                .when()
                .get("cards")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body("_embedded.card.id",hasItems("57a98d98e4b00679b4a830b4"));
    }



    /* DELETE */
    /* Проверка удаления юзера по ИД */
    @Test()
    void testCanDeleteUser(){
        RestAssured
                .when()
                .delete("customers/5c4cad2cee11cb0001fa6652")
                .then()
                .statusCode(200);
    }



}

