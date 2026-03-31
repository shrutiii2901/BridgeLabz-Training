import org.json.JSONArray;
import org.json.JSONObject;

public class ListToJson {
    public static void main(String[] args) {

        JSONArray array = new JSONArray();

        JSONObject u1 = new JSONObject();
        u1.put("name", "Aman");
        u1.put("age", 26);

        JSONObject u2 = new JSONObject();
        u2.put("name", "Riya");
        u2.put("age", 22);

        array.put(u1);
        array.put(u2);

        System.out.println(array.toString(2));
    }
}
