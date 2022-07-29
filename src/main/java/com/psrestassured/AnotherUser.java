package com.psrestassured;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnotherUser {

    public String login;
    public  int id;
    public  int publicRepos;


    public String getLogin () {return login; }
    public int getId () {return id; }
    public int getPublicRepos () {return publicRepos; }




}
