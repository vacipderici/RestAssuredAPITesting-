package com.preassured.m5body;

import io.restassured.RestAssured;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class _2ValidatableNestedBodyDemo {

    public  static final String BASE_URL ="https://api.github.com/";

    @Test
    public void nestedBodyValidation() {

        RestAssured.get(BASE_URL)
                .then()
                .rootPath("resources.core")
                     .body("limit" , equalTo(60))
                     .body("remaining", lessThanOrEqualTo(60))
                     .body("reset", notNullValue())
                .rootPath("resources.search")
                    .body("limit",equalTo(10))
                    .body("remaining", lessThanOrEqualTo("0"))
                .noRootPath()
                    .body("resources.graphql.limit", is(0));
    }
}
