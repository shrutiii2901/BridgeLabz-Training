import org.json.JSONArray;
import org.json.JSONObject;

public class FilterByAge {
    public static void main(String[] args) {

        JSONArray users = new JSONArray();

        users.put(new JSONObject().put("name", "Aman").put("age", 28));
        users.put(new JSONObject().put("name", "Riya").put("age", 22));

        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            if (user.getInt("age") > 25) {
                System.out.println(user.toString(2));
            }
        }
    }
}
