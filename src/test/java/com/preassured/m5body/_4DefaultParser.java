package com.preassured.m5body;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class _4DefaultParser {

    public  static final String BASE_URL ="https://api.github.com/";

    @Test
    public void parserAndSyntacticSugar() {

        RestAssured.get(BASE_URL)
                .then()
                .using()
                .defaultParser(Parser.JSON)
                .body("current_user_url",equalTo(BASE_URL + "user"));

    }
}
