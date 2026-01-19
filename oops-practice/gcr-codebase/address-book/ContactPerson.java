

public class ContactPerson {
    private String firstName, lastName, address, city, state, zip, phone, email;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void display() {
        System.out.println("\nContact Details:");
        System.out.println(firstName + " " + lastName);
        System.out.println(address + ", " + city + ", " + state + " - " + zip);
        System.out.println("Phone: " + phone + ", Email: " + email);
    }
}
