package com.qa.endpoints;

import com.qa.payload.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserSectionCrudOperation {

    public static Response createUser(User payload) {

        Response response = given()
                .contentType("application/json").accept("application/json").body(payload)
                .when().post(Routes.postUrl);


        return response;


    }

    public static Response updateUser(String username, User payload) {

        Response response = given()
                .pathParam("username", username).contentType("application/json").accept("application/json").body(payload)
                .when().put(Routes.putUrl);


        return response;


    }

    public static Response getUser(String username) {

        Response response = given()
                .pathParam("username", username)
                .when().get(Routes.getUrl);


        return response;


    }

    public static Response deleteUser(String username) {

        Response response = given()
                .pathParam("username", username)
                .when().delete(Routes.deleteUrl);


        return response;


    }


}
