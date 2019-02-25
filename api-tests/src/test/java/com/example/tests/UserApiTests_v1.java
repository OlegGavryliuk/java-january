package com.example.tests;

import com.exemple.conditions.Conditions;
import com.exemple.model.UserPayload;
import com.exemple.responses.UserListResponse;
import com.exemple.services.UserApiService_v1;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTests_v1 {

    private final UserApiService_v1 userApiService_v1 = new UserApiService_v1();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://142.93.90.9/";
//        RestAssured.baseURI = ConfigFactory.create(ProjectConfig.class).apiPath();
    }



    /* POST */
    /** Проверка регистрации нового юзера */
    @Test()
    void _1_testCanRegisterUser() {

        UserPayload userPayload = new UserPayload()
                .setUsername(RandomStringUtils.randomAlphanumeric(6))
                .setPassword("12345")
                .setEmail("user@gmail.com");

        String id = userApiService_v1.registerUser(userPayload)
                .shouldHave(Conditions.statusCode( 200))
                .shouldHave(Conditions.statusBody(not(isEmptyString())))
                .getValue("id");


//        UserListResponse users = userApiService_v1.getAllUsers().asPojo(UserListResponse.class);
//        assertThat(users.getEmbedded().getCustomer()).size().isGreaterThan(100);
//        System.out.println("Юзери: " + users);


        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured
                .when()
                .get("customers")
                .then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .body("_embedded.customer.id", hasItems(id));
        System.out.println("все ок!!");


        RestAssured
                .when()
                .delete("customers/"+id)
                .then()
                .statusCode(200);
        System.out.println("все окeeeeeee!!");

        UserListResponse users = userApiService_v1.getAllUsers().asPojo(UserListResponse.class);
        String u = users.toString();
        assertThat(u).doesNotContain(id);
    }





    /** Проверка регистрации нового юзера с некоректными данными */
    @Test()
    void _2_testCanNotRegisterUser(){
        UserPayload userPayload = new UserPayload()
                .setEmail("user@gmail.com");

        userApiService_v1.registerUser(userPayload)
                .shouldHave(Conditions.statusCode(200));

    }




    /* GET */
    /** Проверка существования юзера по ИД */
    @Test()
    void _3_testCanGetCustomer() {
         userApiService_v1.getUserById("57a98d98e4b00679b4a830af")
               .shouldHave(Conditions.statusCode(200))
               .shouldHave(Conditions.statusBody("id", not(isEmptyString())));

    }







    /* DELETE */
    /** Проверка удаления юзера  */
    @Test()
    void testCanDeleteUser(){
        userApiService_v1
               .deleteUser("5c5d355eee11cb0001fa6697")
               .shouldHave(Conditions.statusCode(200));

    }


}

