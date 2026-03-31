import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task = "Add login feature", assignedTo = "Shruti", priority = "HIGH")
    public void login() {}

    @Todo(task = "Improve UI", assignedTo = "Aman")
    public void uiUpdate() {}
}

public class TodoDemo {
    public static void main(String[] args) {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(
                    m.getName() + " Task: " + t.task() +
                    " Assigned: " + t.assignedTo() +
                    " Priority: " + t.priority()
                );
            }
        }
    }
}
