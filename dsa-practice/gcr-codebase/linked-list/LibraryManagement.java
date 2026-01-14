class BookNode {
    int id;
    String title;
    BookNode next, prev;

    BookNode(int i, String t) {
        id = i; title = t;
    }
}

class Library {
    BookNode head, tail;

    void addBook(int id, String title) {
        BookNode node = new BookNode(id, title);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(1, "Java");
        lib.addBook(2, "DSA");

        System.out.println("Total Books: " + lib.countBooks());
    }
}
