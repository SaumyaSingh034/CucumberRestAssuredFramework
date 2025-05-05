package stepDefinition.interviewPractice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test1 {

    @Test
    public void test1(){
        given().header("Authetication", "Bearer Token")
                .pathParam("key","value").contentType(ContentType.JSON)
                .when().get("")
                .then().statusCode(200)
                .header("Autheication","123")
                .body("key", equalTo("data"));

    }
}
