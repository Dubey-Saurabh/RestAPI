package com.qa.endpoints;

import com.qa.payload.User;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserSectionCrudOperation2 {


    public static ResourceBundle getUrl() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Routes");
        return resourceBundle;

    }

    public static Response createUser(User payload) {

        String postUrl = getUrl().getString("postUrl");

        Response response = given()
                .contentType("application/json").accept("application/json").body(payload)
                .when().post(postUrl);


        return response;


    }

    public static Response updateUser(String username, User payload) {

        String putUrl = getUrl().getString("putUrl");

        Response response = given()
                .pathParam("username", username).contentType("application/json").accept("application/json").body(payload)
                .when().put(putUrl);


        return response;


    }

    public static Response getUser(String username) {

        String getUrl = getUrl().getString("getUrl");

        Response response = given()
                .pathParam("username", username)
                .when().get(getUrl);


        return response;


    }

    public static Response deleteUser(String username) {

        String deleteUrl = getUrl().getString("deleteUrl");

        Response response = given()
                .pathParam("username", username)
                .when().delete(deleteUrl);


        return response;


    }


}
