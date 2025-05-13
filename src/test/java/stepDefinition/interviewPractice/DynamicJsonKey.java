package stepDefinition.interviewPractice;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class DynamicJsonKey {

    @Test
    public void handleDynamicJsonKey(){
        Response response = given().header("","")
                .when().get().then()
                .statusCode(200).extract().response();

        Map<String, Object> allFields = response.jsonPath().getMap("$");

        for(String key : allFields.keySet()){
            System.out.println(key+" "+allFields.get(key));
        }
    }
}
