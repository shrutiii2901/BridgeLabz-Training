import java.util.Scanner;

class Book {

    
    String title;
    String author;
    double price;

    
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println();
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // default constructor
        Book book1 = new Book();
        System.out.println("Book created using Default Constructor:");
        book1.displayDetails();

        
        System.out.println("Enter book title:");
        String t = sc.nextLine();

        System.out.println("Enter author name:");
        String a = sc.nextLine();

        System.out.println("Enter book price:");
        double p = sc.nextDouble();

        
        Book book2 = new Book(t, a, p);
        System.out.println("Book created using Parameterized Constructor:");
        book2.displayDetails();

    }
}