package stepDefinition;

import io.cucumber.java.Before;
import io.restassured.response.Response;

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
}
