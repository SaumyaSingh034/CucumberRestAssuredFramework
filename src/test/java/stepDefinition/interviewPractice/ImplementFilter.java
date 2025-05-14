package stepDefinition.interviewPractice;

import io.restassured.filter.log.ErrorLoggingFilter;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ImplementFilter {
    @Test
    public void implementFiletrForFailure(){
        given()
                .filter(new ErrorLoggingFilter())
                .when().get().then().statusCode(200);
    }
}
