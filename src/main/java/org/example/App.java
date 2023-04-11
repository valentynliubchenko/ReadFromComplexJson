package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class App {
    public static void main (String[] args) throws IOException {
        {
            //Read from JSON example 1
            String object = IOUtils.resourceToString("/issue.json", Charset.defaultCharset());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonIssues = objectMapper.readTree(object);
                String issues = jsonIssues.get("issues").toString();
                List<Object> listIssues = objectMapper.readValue(issues, new TypeReference<List<Object>>() {});
                for (Object issue : listIssues) {
                    JsonNode node = objectMapper.convertValue(issue, JsonNode.class);
                    System.out.println(node.get("key"));
                    System.out.println(node.get("fields").get("creator").get("emailAddress"));
                    System.out.println(node.get("fields").get("updated"));
                    System.out.println(node.get("fields").get("created"));
                    System.out.println(node.get("fields").get("status").get("statusCategory"));
                }

            } catch (Exception e) {
                System.out.println("Error");
            }
        }

        //Read from JSON example 2

        String object = IOUtils.resourceToString("/issue.json", Charset.defaultCharset());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(object);
        try {

            String sw = jsonNode.get("issues").asText();

            System.out.println(sw);
        } catch (Exception e) {
            System.out.println("Error");
        }
        //Read from JSON example 3
        //                List<Issue> res = getSolvitCase();
        //                System.out.println( res );
        //                System.out.println( "---------------------------" );

        //        System.out.println( res.getLineMeasurement() );


    }

    private static String getStartData () throws IOException {
        return IOUtils.resourceToString("/data.txt", Charset.defaultCharset());
    }

    private static List<Issue> getSolvitCase () throws IOException {
        String object = IOUtils.resourceToString("/array.json", Charset.defaultCharset());
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(object);
            String sw = jsonNode.get("issues").toString();
            return mapper.readValue(sw, new TypeReference<List<Issue>>() {});


        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Can not deserialize solvitCase", e);
        }
    }
}
