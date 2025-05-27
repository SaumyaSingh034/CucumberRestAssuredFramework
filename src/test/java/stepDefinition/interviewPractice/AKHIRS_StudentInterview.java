package stepDefinition.interviewPractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.path.json.JsonPath;
import payloadBuilder.Payload1;

import java.util.List;

public class AKHIRS_StudentInterview {
    public static void main(String[] args) throws JsonProcessingException {
        String response = Payload1.payload2;
        ObjectMapper obj = new ObjectMapper();
        JsonNode root = obj.readTree(response);
        JsonNode students = root.path("students");
        System.out.println(students);
        for(JsonNode student : students){
            if("New Delhi".equalsIgnoreCase(student.get("place").asText())){
                System.out.println(student.get("name").asText());
            }
        }

    }
}
