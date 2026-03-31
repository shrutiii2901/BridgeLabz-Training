import java.util.Scanner;

class BookLib {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String a) {
        author = a;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends BookLib {
    void show() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

public class BookLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EBook eb = new EBook();

        System.out.print("Enter ISBN: ");
        eb.ISBN = sc.nextLine();

        System.out.print("Enter Title: ");
        eb.title = sc.nextLine();

        System.out.print("Enter Author: ");
        String auth = sc.nextLine();
        eb.setAuthor(auth);

        System.out.println("\nBook Details:");
        eb.show();

        sc.close();
    }
}
