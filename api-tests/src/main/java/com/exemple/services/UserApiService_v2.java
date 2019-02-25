package com.exemple.services;

import com.exemple.assertions.AssertableResponse;
import com.exemple.conditions.Conditions;
import com.exemple.model.UserPayload;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Slf4j
public class UserApiService_v2 extends ApiService {


    /** Регистрация нового юзера */
    public String userName(){
        return RandomStringUtils.randomAlphanumeric(6);
    }

    @Step
    public AssertableResponse registerUser_v2(String name, String pass, String mail) {
        UserPayload userPayload = new UserPayload()
                .setUsername(name)
                .setPassword(pass)
                .setEmail(mail);

        return new AssertableResponse(setup()
                .body(userPayload)
                .when()
                .post("register"));
    }

    @Step
    public void canRegisterUser(){
        String id = registerUser_v2(userName(),"12345","user@gmail.com")
                .shouldHave(Conditions.statusCode( 200))
                .shouldHave(Conditions.statusBody(not(isEmptyString())))
                .getValue("id");

        writeToFile(id);
    }


    /** Регистрация нового юзера с некоректными данными */
    @Step
    public void canNotRegisterUser() {
        registerUser_v2("","", "")
                .shouldHave(Conditions.statusCode(500))
                .shouldHave(Conditions.statusBody(isEmptyString()));
    }



    /** Проверка существования юзера по ИД */
    @Step
    public void canGetCustomer(){
        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured
                .when()
                .get("customers")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body("_embedded.customer.id", hasItems(readFile()));
    }


    /** Проверка удаления юзера  */

    @Step
    public AssertableResponse deleteUser() {
        return new AssertableResponse(setup()
                .when()
                .delete("customers/{id}", readFile()));
    }




}
