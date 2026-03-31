import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    @Inject
    Engine engine;
}

public class SimpleDI {
    public static void main(String[] args) throws Exception {
        Car car = new Car();

        for (Field f : car.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(car, f.getType().getDeclaredConstructor().newInstance());
            }
        }

        car.engine.start();
    }
}
