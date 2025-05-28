package runner;// Mock Base URL: https://mock-api.nab.com/api

// 1. POST /login with { "username": "test", "password": "test" }
// 2. Extract token from response: { "token": "abc123" }
// 3. Use token in header to:
//    - GET /users/123
//    - DELETE /users/123

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APITest {
    public static void main(String[] args) {
        String token;
        // Use RestAssured here
        Response response = given().formParam("username","test")
                .formParam("password", "test")
                .when().post("")
                .then().statusCode(201)
                .extract().response();

        token = response.jsonPath().getString("token");

        given().header("Authorization", "Beare "+token)
                .when()
                .get("")
                .then().statusCode(200);

        given().header("Authorization", "Beare "+token)
                .when()
                .delete("")
                .then().statusCode(204);


    }
}
