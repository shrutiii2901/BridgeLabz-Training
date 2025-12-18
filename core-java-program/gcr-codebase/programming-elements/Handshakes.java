import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int handshakes = n * (n - 1) / 2;
        System.out.println("The maximum number of possible handshakes is " + handshakes);
    }
}
