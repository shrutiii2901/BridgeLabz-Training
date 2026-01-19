
import java.util.*;

public class AddressBookMain {
    static AddressBook book = new AddressBook();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");

        while (true) {
            System.out.println("\n1. Add Contact\n2. Edit Contact\n3. Delete Contact\n4. View Contacts\n5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    System.out.print("Address: ");
                    String addr = sc.nextLine();
                    System.out.print("City: ");
                    String city = sc.nextLine();
                    System.out.print("State: ");
                    String state = sc.nextLine();
                    System.out.print("Zip: ");
                    String zip = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    book.addContact(new ContactPerson(fn, ln, addr, city, state, zip, phone, email));
                    break;

                case 2:
                    System.out.print("Enter name to edit: ");
                    book.editContact(sc.nextLine(), sc);
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    book.deleteContact(sc.nextLine());
                    break;

                case 4:
                    book.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

}
