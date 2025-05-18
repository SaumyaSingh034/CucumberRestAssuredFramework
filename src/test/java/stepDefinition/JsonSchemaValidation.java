package stepDefinition;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.index.qual.LessThan;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;
//import static stepDefinition.Interview.token;

public class JsonSchemaValidation {
    @Test
    public void jsonSchemaValidation(){
        String token = "";
   given().header("Autherization","Bearer "+token)
                .pathParam("","").queryParam("","")
                .body("")
                .when().post().then().statusCode(200).
        body(matchesJsonSchemaInClasspath("user-schema.json"));
        //matchesJsonSchemaInClasspath
    }

    @Test
    public void requestSpec(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("")
                .addHeader("","").build();
    }

    @Test
    public void validateResponseTime(){
        given()
                .when().get("")
                .then().statusCode(200).time(lessThan(1000L));
    }
}
