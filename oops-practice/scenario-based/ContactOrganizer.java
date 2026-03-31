import java.util.*;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

public class ContactOrganizer {
    private static List<Contact> contacts = new ArrayList<>();

    public static void addContact(String name, String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Duplicate contact not allowed.");
                return;
            }
        }

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    public static void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c.getName() + " - " + c.getPhoneNumber());
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void deleteContact(String phone) {
        contacts.removeIf(c -> c.getPhoneNumber().equals(phone));
        System.out.println("Contact deleted if existed.");
    }

    public static void main(String[] args) {
        try {
            addContact("Alice", "9876543210");
            addContact("Bob", "1234567890");
            searchContact("Alice");
            deleteContact("1234567890");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
