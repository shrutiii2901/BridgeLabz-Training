public class Transaction {
    Book book;

    public Transaction(Book book) {
        this.book = book;
    }

    public void issueBook() throws BookNotAvailableException {
        if (!book.available)
            throw new BookNotAvailableException("Book not available");
        book.available = false;
        System.out.println("Book issued: " + book.title);
    }
}
