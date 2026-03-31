import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    User(String u, int a) {
        username = u;
        age = a;
    }
}

public class JsonDemo {

    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");

        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                f.setAccessible(true);
                JsonField jf = f.getAnnotation(JsonField.class);
                sb.append("\"").append(jf.name()).append("\":\"")
                  .append(f.get(obj)).append("\",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Shruti", 21);
        System.out.println(toJson(user));
    }
}
