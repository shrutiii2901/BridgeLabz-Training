import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {

    @LogExecutionTime
    public void slowMethod() throws InterruptedException {
        Thread.sleep(300);
    }

    @LogExecutionTime
    public void fastMethod() throws InterruptedException {
        Thread.sleep(100);
    }
}

public class ExecutionTimeDemo {
    public static void main(String[] args) throws Exception {
        PerformanceTest obj = new PerformanceTest();

        for (Method m : PerformanceTest.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(obj);
                long end = System.nanoTime();
                System.out.println(m.getName() + " took " + (end - start) + " ns");
            }
        }
    }
}
