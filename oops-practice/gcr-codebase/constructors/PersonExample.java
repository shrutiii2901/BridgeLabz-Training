class PersonExample {
    String name;
    int age;

    PersonExample(String n, int a) {
        name = n;
        age = a;
    }

    // Copy constructor
    PersonExample(PersonExample p) {
        name = p.name;
        age = p.age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }

    public static void main(String[] args) {
        PersonExample p1 = new PersonExample("Shruti", 21);
        PersonExample p2 = new PersonExample(p1);
        p2.display();
    }
}
