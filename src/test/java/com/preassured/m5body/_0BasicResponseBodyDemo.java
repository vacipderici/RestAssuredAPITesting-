package com.preassured.m5body;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.Map;

public class _0BasicResponseBodyDemo {

    public  static final String BASE_URL ="https://api.github.com/rate_limit";

    @Test
    public void jsonPathReturnsMap(){
        Response response = RestAssured.get(BASE_URL);

        ResponseBody<?> body = response.body();  // We pulled the data from the relevant link
        JsonPath jPath = body.jsonPath(); //First way

        JsonPath jPath2 = response.body().jsonPath(); // Best Practise

        Map<String, String> fullJson = jPath2.get();
        Map<String, String> subMap = jPath2.get("resources");
        Map<String, String> subMap2 = jPath2.get("resources.core");
        Map<String, String> submap3 = jPath2.get("resources.search");

        int value = jPath.get("resources.core.limit");
        int value2 = jPath.get("resources.graphql.remaining");
        int value3 = jPath.get("resources.integration_manifest.reset");

        System.out.println(fullJson);
        System.out.println(subMap);
        System.out.println(subMap2 + "sad");
        System.out.println(value);
        System.out.println(value3);
        System.out.println(submap3);


    }
}
