import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {

    @ImportantMethod
    public void processData() {}

    @ImportantMethod(level = "LOW")
    public void cleanup() {}

    public void helper() {}
}

public class ImportantMethodDemo {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " → Level: " + im.level());
            }
        }
    }
}
