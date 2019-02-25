package com.exemple.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class ApiService {

    public RequestSpecification setup(){

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .filters(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    //Записуємо значення в файл
    public void writeToFile(String value){
        try {
            FileWriter writer = new FileWriter("id.txt", false);
            writer.append(value);
            writer.flush();
            writer.close();
        } catch (IOException ex){System.out.println(ex.getMessage());}
    }

    //Читаємо значення з файлу
    public String readFile(){
        StringBuilder sb = new StringBuilder();
        String v ="";
        try {
            FileReader reader = new FileReader("id.txt");
            BufferedReader in = new BufferedReader(reader);
            String s;
            s = in.readLine();
            sb.append(s);
            v = s;
            reader.close();
        } catch (IOException ex){System.out.println(ex.getMessage());}
        return v;

    }


}
