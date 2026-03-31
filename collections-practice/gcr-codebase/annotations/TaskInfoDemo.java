import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}


class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Shruti")
    public void completeTask() {
        System.out.println("Task completed");
    }
}

public class TaskInfoDemo {

    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();
        manager.completeTask();

        Method method = TaskManager.class.getMethod("completeTask");

        TaskInfo info = method.getAnnotation(TaskInfo.class);

        System.out.println("Task Info ");
        System.out.println("Priority    : " + info.priority());
        System.out.println("Assigned To : " + info.assignedTo());
    }
}
