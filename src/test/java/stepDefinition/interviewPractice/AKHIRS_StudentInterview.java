package stepDefinition.interviewPractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.eo.Se;
import io.restassured.path.json.JsonPath;
import payloadBuilder.Payload1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AKHIRS_StudentInterview {
    public static void main(String[] args) throws JsonProcessingException {
        String response = Payload1.payload2;
//        ObjectMapper obj = new ObjectMapper();
//        JsonNode root = obj.readTree(response);
//        JsonNode students = root.path("students");
//        System.out.println(students);
//        for(JsonNode student : students){
//            if("New Delhi".equalsIgnoreCase(student.get("place").asText())){
//                System.out.println(student.get("name").asText());
//            }
//        }

        JsonPath js = new JsonPath(response);
        int size = js.get("students.size()");
        System.out.println(size);
        int count = 0;
        Set<String> list = new HashSet<>();

        for(int i=0;i<size;i++){
            String section = js.getString("students["+i+"].section");
            if("A".equalsIgnoreCase(section)){
                System.out.println(js.getString("students["+i+"].name"));
            }
            if("New Delhi".equalsIgnoreCase(js.getString("students["+i+"].place")))
                count++;
            list.add(js.getString("students["+i+"].place"));


        }
        System.out.println("Number of students from New Delhi: "+count);
        System.out.println(list);

    }
}
