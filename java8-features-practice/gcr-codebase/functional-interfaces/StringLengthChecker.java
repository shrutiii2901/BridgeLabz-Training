import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {

        Function<String, Integer> lengthFunc = msg -> msg.length();

        String message = "System Alert";

        System.out.println("Length: " + lengthFunc.apply(message));
    }
}
