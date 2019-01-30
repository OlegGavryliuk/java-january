package com.exemple.services;

import com.exemple.model.UserPayload;
import io.restassured.response.ValidatableResponse;

public class UserApiService extends ApiService {

    public ValidatableResponse registerUser(UserPayload userPayload){
        return setup()
                .body(userPayload)
                .when()
                .post("register")
                .then();
    }
}
