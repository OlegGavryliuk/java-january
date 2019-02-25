package com.exemple.conditions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

@RequiredArgsConstructor
public class BodyFieldCondition implements Condition {

    private final String path;
    private final Matcher matcher;




    @Override
    public void check(Response response) {
          if (StringUtils.isBlank(path)){
            response.then().assertThat().body(matcher);
        } else {
            response.then().assertThat().body(path, matcher);
        }

    }

//contentType(ContentType.TEXT).

    @Override
    public String toString(){
        if (StringUtils.isBlank(path)){
            return "Body field " + matcher;
        }
        return "Body field " + path + "" + matcher;
    }
}
