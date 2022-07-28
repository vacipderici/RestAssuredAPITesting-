package com.preassured.m6objectmapping;

import com.psrestassured.User;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ObjectMappingDemo {

    public  static final String BASE_URL ="https://api.github.com/users/rest-assured";

    @Test
    public void ObjectMappingTestOne(){
         User user =   RestAssured.get(BASE_URL)
                .as(User.class);

            assertEquals(user.getLogin(),"rest-assured");
            assertEquals(user.getId(),"rest-assured");

    }
}
