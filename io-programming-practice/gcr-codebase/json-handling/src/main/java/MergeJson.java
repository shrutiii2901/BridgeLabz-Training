import org.json.JSONObject;

public class MergeJson {
    public static void main(String[] args) {

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Shruti");

        JSONObject obj2 = new JSONObject();
        obj2.put("age", 21);

        obj1.put("age", obj2.getInt("age"));

        System.out.println(obj1.toString(2));
    }
}
