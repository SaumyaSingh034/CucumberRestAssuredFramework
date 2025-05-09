package stepDefinition.interviewPractice;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import payloadBuilder.Payload1;

import java.util.List;

public class PayloadVerification {

    public static void main(String[] args){

        JsonPath js = new JsonPath(Payload1.payload);
     List<String> productNames =  js.getList("name");
     System.out.println(productNames);
        Assert.assertTrue(productNames.contains("Notebook"));

        JsonPath jsResponse = new JsonPath(Payload1.payload1);
        int size = jsResponse.get("data.size()");
        System.out.println(size);
        System.out.println(jsResponse.getString("data[0].id"));
        System.out.println(jsResponse.getString("data[0].skills[0]"));

    }
}
