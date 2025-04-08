package stepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Interview {
    private static String token;
    private static long tokenExpiryTime;

    @Before
    public void getToken()
    {
        if(token == null || System.currentTimeMillis() > tokenExpiryTime){
            fetchNewToken();
        }

    }

    private void fetchNewToken() {
       Response response =  given().body("")
                .when().post("");
       if(response.getStatusCode() == 200 ){
         token =  response.jsonPath().getString("access_token");
       }else{
           System.out.println("getting error while"+response.getStatusCode());
       }
       tokenExpiryTime = System.currentTimeMillis() + (30 * 60 * 1000);
    }

    @Test
    public void testRun() throws JsonProcessingException {
        Response response = given().when().get("");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node =  mapper.readTree(response.getBody().asString());
        if(node.has("data")){
            JsonNode data = node.get("data");
        }
    }

    @Test
    public void test() throws JsonProcessingException {
        Response response = given().when().get("");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody().asString());
        JsonNode data = root.get("data");
        if(data.isTextual()){

        }else if(data.isArray()){

        }else if(data.isObject()){

        }

    }
}
