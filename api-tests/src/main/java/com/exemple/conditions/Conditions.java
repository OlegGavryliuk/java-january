package com.exemple.conditions;


import io.restassured.http.ContentType;
import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;

@UtilityClass
public class Conditions {

    public static StatusCodeCondition statusCode(int code){
        return new StatusCodeCondition(code);
    }

    public static BodyFieldCondition statusBody(String path, Matcher matcher){
        return new BodyFieldCondition(path, matcher);
    }

    public static BodyFieldCondition statusBody(Matcher matcher){
        return new BodyFieldCondition(null, matcher);
    }



}
