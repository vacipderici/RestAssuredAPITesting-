package com.preassured.m4header;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class _2ValidatableResponseDemo {
    public  static final String BASE_URL ="https://api.github.com";

    @Test
    public void basicValidatableExample(){
     RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("x-ratelimit-limit","60");

    }
}
