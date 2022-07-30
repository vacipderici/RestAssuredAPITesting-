package com.preassured.m7httpmethods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class CustomRequestDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void CustomRequest() {
        //both equivelant to RestAssured.get(...)
        RestAssured.request(Method.GET,BASE_URL)
                .then()
                .statusCode()
                .body(containsString("current_user_url"));

        RestAssured.get(BASE_URL)
                .then()
                .statusCode()
                .body(containsString("current_user_url"));
    }
    @Test
    public void traceExample(){
        RestAssured.request(Method.TRACE, BASE_URL)
                .then()
                .statusCode(405);  // Method not allowed
    }

}
