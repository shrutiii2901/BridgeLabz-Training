import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double price = sc.nextDouble();
        int qty = sc.nextInt();

        double bill = price * qty;

        System.out.println(
            "The total purchase price is INR " + bill +
            " if the quantity " + qty + " and unit price is INR " + price
        );
    }
}
