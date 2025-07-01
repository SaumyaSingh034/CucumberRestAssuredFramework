package interviewPrep;


import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import payloadBuilder.Payload1;

public class JsonResponse1 {
    @Test
    public void validateJsonResponse(){
        String response = Payload1.payload3;
        JsonPath js  = new JsonPath(response);
        String name = js.get("user.name");
        Assert.assertEquals(name, "Saumya", "The name is not same");
    }
}
