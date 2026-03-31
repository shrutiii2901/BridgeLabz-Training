import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}


class Software {

    @BugReport(description = "NullPointerException occurs on login")
    @BugReport(description = "UI freezes when submitting form")
    public void process() {
        System.out.println("Processing software...");
    }
}


public class RepeatableAnnotationDemo {

    public static void main(String[] args) throws Exception {

        Method method = Software.class.getMethod("process");

        BugReport[] bugs = method.getAnnotationsByType(BugReport.class);

        System.out.println(" Bug Reports ");
        for (BugReport bug : bugs) {
            System.out.println(bug.description());
        }
    }
}
