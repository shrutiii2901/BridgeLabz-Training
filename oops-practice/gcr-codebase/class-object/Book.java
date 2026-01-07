// Book class
class Booker {

    
    String title;
    String author;
    double price;

    // method to display 
    void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    
    public static void main(String[] args) {

        // first book 
        Booker book1 = new Booker();
        book1.title = "2States";
        book1.author = "Chetan Bhagat";
        book1.price = 500.0;

        // second book 
        Booker book2 = new Booker();
        book2.title = "Wings Of Fire";
        book2.author = "Abdul kalam.A.P.J";
        book2.price = 500.0;

        book1.displayDetails();
        book2.displayDetails();
    }
}