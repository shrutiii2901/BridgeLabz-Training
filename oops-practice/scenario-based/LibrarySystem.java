import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    String title;
    String author;
    boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
}

public class LibrarySystem {
    static List<Book> books = new ArrayList<>();

    public static void searchBook(String keyword) {
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.title + " by " + b.author +
                        " (" + (b.available ? "Available" : "Checked Out") + ")");
            }
        }
    }

    public static void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.available) {
                    throw new BookNotAvailableException("Book is not available");
                }
                b.available = false;
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        books.add(new Book("Java Basics", "James"));
        books.add(new Book("Data Structures", "Mark"));

        searchBook("Java");

        try {
            checkoutBook("Java Basics");
            checkoutBook("Java Basics");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
