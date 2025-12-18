import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // take celsius
        int celsius=sc.nextInt();
        // calculate temperature in F
        System.out.println(celsius * 9/5 + 32);
    }
}