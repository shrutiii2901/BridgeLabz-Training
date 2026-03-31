import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.Set;


public class ValidateEmail {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(new File("users.json"));

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
        JsonSchema schema = factory.getSchema("user_schema.json");


        for (JsonNode user : data.get("users")) {
            Set<ValidationMessage> errors = schema.validate(user);
            if (errors.isEmpty()) {
                System.out.println(user.get("email").asText() + " is valid.");
            } else {
                System.out.println(user.get("email").asText() + " is invalid.");
            }
        }
    }
}
