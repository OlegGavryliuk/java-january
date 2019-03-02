package com.exemple.services;

import com.exemple.assertions.AssertableResponse;
import com.exemple.model.UserPayload;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserApiService_v1 extends ApiService {




    @Step
    public AssertableResponse registerUser(UserPayload userPayload) {
        //log.info("About to create new user [ " + userPayload + " ]");
        return new AssertableResponse(setup()
                .body(userPayload)
                .when()
                .post("register"));
    }


    @Step
    public AssertableResponse deleteUser(String id) {
        return new AssertableResponse(setup()
                .when()
                .delete("customers/{id}", id));
    }

    @Step
    public AssertableResponse getUserById(String id) {
        return new AssertableResponse(setup()
                .when()
                .get("customers/{id}", id));
    }

    @Step
    public AssertableResponse getAllUsers() {
        return new AssertableResponse(setup()
                .when()
                .get("customers"));
    }




}
