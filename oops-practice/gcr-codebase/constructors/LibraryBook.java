import java.util.Scanner;


class LibraryBook {

   
    String title;
    String author;
    double price;
    boolean available;

    
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; 
    }

    
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry, book is not available.");
        }
    }

    
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book title:");
        String title = sc.nextLine();

        System.out.println("Enter author name:");
        String author = sc.nextLine();

        System.out.println("Enter book price:");
        double price = sc.nextDouble();

       
        LibraryBook book = new LibraryBook(title, author, price);

        
        System.out.println("\nBook Details:");
        book.displayDetails();

        
        book.borrowBook();

       
        System.out.println("\nAfter Borrowing:");
        book.displayDetails();

    }
}