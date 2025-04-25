package stepDefinition;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ExponentialBackOff {

    public static void main(String[] args) throws InterruptedException {

        int maxRetry = 5;
        int waitTime = 1000; //1 sec

        for(int i=0;i< maxRetry ; i++){
            Response response = given().when().get("");
            if(response.getStatusCode() != 429){
                break;
            }else{
                Thread.sleep(waitTime);
                waitTime *= 2;
            }
        }
    }
}
