import java.lang.reflect.Method;

class Task {
    public void run() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class MethodTiming {
    public static void main(String[] args) throws Exception {
        Task obj = new Task();
        Method method = Task.class.getMethod("run");

        long start = System.currentTimeMillis();
        method.invoke(obj);
        long end = System.currentTimeMillis();

        System.out.println("Execution Time: " + (end - start) + " ms");
    }
}
