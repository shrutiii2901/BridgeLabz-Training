
import java.util.*;

public class AddressBook {
    private ArrayList<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson person) {
        contacts.add(person);
        System.out.println("Contact added successfully!");
    }

    public void editContact(String name, Scanner sc) {
        for (ContactPerson p : contacts) {
            if (p.getFullName().equalsIgnoreCase(name)) {
                System.out.print("Enter new Address: ");
                String addr = sc.nextLine();
                System.out.print("Enter new Phone: ");
                String phone = sc.nextLine();
                System.out.print("Enter new Email: ");
                String email = sc.nextLine();

                p = new ContactPerson(name.split(" ")[0], name.split(" ")[1], addr, "", "", "", phone, email);
                System.out.println("Contact updated!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public void deleteContact(String name) {
        contacts.removeIf(p -> p.getFullName().equalsIgnoreCase(name));
        System.out.println("Contact deleted if existed.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (ContactPerson p : contacts) {
            p.display();
        }
    }
}
