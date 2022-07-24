package com.preassured.m4header;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

public class _2ValidatableResponseDemo {
    public  static final String BASE_URL ="https://api.github.com";

    @Test
    public void basicValidatableExample(){
     RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                  .statusCode(200)
                .and()
                  .contentType(ContentType.JSON)
                .and().assertThat()
                    .header("x-ratelimit-limit","60");

    }

    @Test
    public void simpleHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .statusCode(Matchers.lessThan(300))
                .header("cache-control",Matchers.containsStringIgnoringCase("max-age=60"))
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS)
                .header("etag",Matchers.notNullValue())
                .header("etag",Matchers.not(emptyString()));

    }
    @Test
    public void complexHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .header("x-rateLimit-limit",Integer::parseInt,Matchers.equalTo(60))
                .header("date",date -> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME),
                        OrderingComparison.comparesEqualTo(LocalDate.now()))
                .header("x-ratelimit-limit" ,
                        response -> greaterThan(response.header("x-ratelimit-remaining")));


    }

    Map<String,String> expectedHeaders = Map.of("content-encoding","gzip",
            "access-control-allow-origin","*"
            );

    @Test
    public void usingMapsToTestHeaders(){
        RestAssured.get(BASE_URL)
                .then()
                .headers("content-encoding","gzip",
                        "acsess-control-allow-origin",   "*",
                        "cache-control", contains("public"))
                .headers(expectedHeaders);

    }

}
