package interviewPrep;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BasicCurdCalls {
    @Test
    public void getCall(){
        given().header("", ""). queryParam("key", "value")
                .when().get("")
                .then().statusCode(200).body("name", equalTo("Saumya"));
    }

    @Before
    public void buildRequestSpecification(){
        RequestSpecification requestSpecification
                 = new RequestSpecBuilder()
                .setBaseUri("")
                .addHeader("Header", "header data")
                .setBody("").build();

    }
}
