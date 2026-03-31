public class Main {
    public static void main(String[] args) {
        Book b = new Book("Java Basics");
        Member m = new Member("Shruti");
        Transaction t = new Transaction(b);

        try {
            t.issueBook();
            System.out.println("Fine: " + m.calculateFine(3));
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
