package com.preassured.m7httpmethods;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class OtherMethodsDemo {

    public static final String BASE_URL="https://api.github.com/user/repos";
    public static final String TOKEN ="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";

    @Test(description = "Create a repo")
    public void postTest(){

        RestAssured
                .given()
                .header("Authorization","token " + TOKEN)
                   .body("{\"name\": \"deleteme2\"}")
                .when()
                    .post(BASE_URL)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update a repo")
    public void patchTest(){

        RestAssured
                .given()
                .header("Authorization","token " + TOKEN)
                    .body("{\"name\": \"deleteme-patched\"}")
                .when()
                    .patch("https://api.github.com/repos/vacipderici/deleteme")
                .then()
                    .statusCode(200);
    }
    @Test(description = "Delete a repo")
    public void deleteTest(){

        RestAssured
                .given()
                .header("Authorization","token " + TOKEN)
                .when()
                     .delete("https://api.github.com/repos/vacipderici/deleteme2")
                .then()
                .statusCode(204);
    }
}
