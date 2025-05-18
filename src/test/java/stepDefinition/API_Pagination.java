package stepDefinition;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_Pagination {

    @Test
    public void validatePages(){
        int totalPages;
        boolean hasMore = false;
        int page=1;
        do {
            Response response = given().contentType(ContentType.JSON)
                    .body("")
                    .when().post("");

            totalPages = response.jsonPath().get("totalPages");

        }while(hasMore);

    }
}
