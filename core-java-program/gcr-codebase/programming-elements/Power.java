import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double base=sc.nextInt();
        double exponent = sc.nextInt();
        // calculate power
        System.out.println(Math.pow(base,exponent));
    }
}