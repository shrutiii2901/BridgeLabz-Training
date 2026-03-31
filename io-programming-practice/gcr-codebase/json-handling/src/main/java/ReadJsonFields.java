import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonFields {
    public static void main(String[] args) throws Exception {

        String content = new String(Files.readAllBytes(Paths.get("data/user.json")));
        JSONObject json = new JSONObject(content);

        System.out.println("Name: " + json.getString("name"));
        System.out.println("Email: " + json.getString("email"));
    }
}
