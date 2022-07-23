package com.preassured.m4header;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class _1BasicResponseDemo {
    public  static final String BASE_URL ="https://api.github.com";
    Response response = RestAssured.get(BASE_URL);

    @Test
    public void convienceMethods(){

        assertEquals(response.getStatusCode(),200);
        assertEquals(response.getContentType(),"application/json; charset=utf-8");
    }

    @Test
    public void genericHeader(){

        assertEquals(response.getHeader("server"),"Github.com");
        assertEquals(response.getHeader("x-ratelimit-limit"),"60");

        // OR

        assertEquals(Integer.parseInt(response.getHeader("x-ratelimit-limit")) ,"60");
    }

    @Test
    public void getHeaders(){
       Headers headers = response.getHeaders();
       String val = headers.getValue("header1");
       int size = headers.size();
       List<Header> list  = headers.asList();
       boolean isPresent = headers.hasHeaderWithName("header2");
       assertTrue(isPresent);

    }

    @Test
    public void timeExample(){

        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.MINUTES));
    }


}
