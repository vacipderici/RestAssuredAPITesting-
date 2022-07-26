package com.preassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;


public class _3ValidatableResponseRepeatingItemsDemo {

    public static final String BASE_URL = "https://reqres.in/api/users?page=1";

    @Test
    public void repeatingItems(){
        RestAssured.get(BASE_URL)
                .then()
                .body("data.id[0]", Matchers.equalTo(1))
                .body("data.id[1]",  Matchers.equalTo(2))
                .body("data.first.name[2]",  Matchers.equalTo("Janet"))
                .body("data.first.name[3]", Matchers.equalTo("Eva"))
  //              .body("data.first.name", Matchers.containsInAnyOrder("Eve","Emma"))
                .body("data.first.name",  Matchers.hasItems("Eve"))
                .body("data.first.name",  Matchers.hasItems("Emma"))
                .body("data.first.name",  Matchers.hasItems(Matchers.endsWith("ma")));

    }
}
