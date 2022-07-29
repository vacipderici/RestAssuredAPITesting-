package com.preassured.m6objectmapping;

import com.psrestassured.AnotherUser;
import com.psrestassured.User;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

import static org.testng.Assert.assertEquals;

public class ObjectMappingDemo {

    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @Test
    public void ObjectMappingTestOne() {
        User user = RestAssured.get(BASE_URL)
                .as(User.class);

        assertEquals(user.getLogin(), "rest-assured");
        assertEquals(user.getId(), 19369327);
        assertEquals(user.getPublicRepos(), 2);

    }


}
