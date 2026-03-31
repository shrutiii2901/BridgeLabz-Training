 import java.util.*;
 
 public class ReverseString {
    public static void main(String[] args) {
        String originalStr = "Hello World";
        
        StringBuilder reversedStr = new StringBuilder(originalStr);

        
        reversedStr.reverse();

        
        System.out.println("Original String: " + originalStr);
        System.out.println("Reversed String: " + reversedStr.toString());
    }
}
