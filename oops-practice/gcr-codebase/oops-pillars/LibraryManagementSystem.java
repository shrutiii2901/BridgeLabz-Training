import java.util.Scanner;

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private int id;
    private String title;
    private String author;
    private boolean available = true;

    LibraryItem(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow(String name) {
        if (available) {
            available = false;
            System.out.println("Item borrowed by " + name);
        } else {
            System.out.println("Item not available.");
        }
    }

    public void showDetails() {
        System.out.println("ID: " + id + ", Title: " + title +
                ", Author: " + author + ", Available: " + available);
    }

    abstract int getLoanDuration();
}

class Book extends LibraryItem implements Reservable {

    Book(int id, String t, String a) { 
        super(id, t, a); 
    }
    int getLoanDuration() { 
        return 14; 
    }
    public void reserveItem() {
         System.out.println("Book reserved."); 
    }
    public boolean checkAvailability() {
         return isAvailable(); 
    }

}

class Magazine extends LibraryItem implements Reservable {
    Magazine(int id, String t, String a) {
         super(id, t, a); 
        }
    int getLoanDuration() {
         return 7; 
        }
    public void reserveItem() {
         System.out.println("Magazine reserved."); 
        }
    public boolean checkAvailability() {
         return isAvailable(); 
        }
}

class DVD extends LibraryItem implements Reservable {
    DVD(int id, String t, String a) {
         super(id, t, a); 
        }
    int getLoanDuration() {
         return 3; 
        }
    public void reserveItem() {
         System.out.println("DVD reserved."); 
        }
    public boolean checkAvailability() {
         return isAvailable(); 
        }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Item Type: 1.Book  2.Magazine  3.DVD");
        int type = sc.nextInt(); 
        sc.nextLine();

        System.out.print("Enter ID: ");
        int id = sc.nextInt(); 
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        LibraryItem item = (type == 1) ? new Book(id, title, author)
                          : (type == 2) ? new Magazine(id, title, author)
                          : new DVD(id, title, author);

        item.showDetails();
        System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

        System.out.print("Borrow this item? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter borrower name: ");
            item.borrow(sc.nextLine());
        }

        item.showDetails();

        System.out.print("Reserve this item? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            ((Reservable) item).reserveItem();
        }

        sc.close();
    }
}
