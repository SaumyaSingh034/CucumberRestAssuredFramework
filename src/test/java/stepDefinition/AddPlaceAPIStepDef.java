package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlacePojo;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AddPlaceAPIStepDef {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    AddPlacePojo addPlacePojo;
    Response response;

    @Given("Add Place  Payload")
    public void add_place_payload() {
//        RestAssured.baseURI="";
        Location location = new Location();
        location.setLat(55.9981811);
        location.setLng(33.17373773);
        List<String> types = new ArrayList<>();
        types.add("Shoe Park");
        types.add("Central Park");
        types.add("New York Park");
        addPlacePojo = new AddPlacePojo();
        addPlacePojo.setAccuracy(50);
        addPlacePojo.setAddress("Wakad, Edden Towers, Pune");
        addPlacePojo.setLanguage("English-EN");
        addPlacePojo.setName("AutomationCucumber");
        addPlacePojo.setPhone_number("(+91) 984 551 8951");
        addPlacePojo.setWebsite("www.rahulshettytutor.com");
        addPlacePojo.setLocation(location);
        addPlacePojo.setTypes(types);

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();






    }
    @When("user make {string} call to {string} api")
    public void user_make_call_to_api(String httpRequest, String api) {
        response = given().spec(requestSpecification).body(addPlacePojo)
                .when().post("/maps/api/place/add/json")
                .then().spec(responseSpecification).extract().response();

    }



    @Then("user gets the success response with status code {int}")
    public void userGetsTheSuccessResponseWithStatusCode(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("validate response body field {string} should be {string}")
    public void validate_response_body_field_should_be(String responseKey, String responseValue) {
        assertEquals(response.jsonPath().get(responseKey).toString(), responseValue);

    }
}
