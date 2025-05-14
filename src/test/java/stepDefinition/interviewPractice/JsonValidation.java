package stepDefinition.interviewPractice;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;

public class JsonValidation {
    public static void main(String[] args){
        //Headers headers = new Headers()
        given().header("","").body("")
                .when().post("")
                .then().extract().response().jsonPath().getList("data").size();

        //assert response irrespective of there order

        given().body("")
                .when().post()
                .then().body("path", hasItem("Ssumya, Rahul"));
        Response response = null;
        List<String> user = response.jsonPath().getList("user.email");
        assertTrue(user.stream().allMatch(email->email !=null && !email.isEmpty()));
    }
}
