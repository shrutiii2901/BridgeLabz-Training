// MovieTicket class
class MovieTicket {

    // attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    // method to book ticket
    void bookTicket(String movie, String seat, double amount) {

        if(!isBooked) {
            movieName = movie;
            seatNumber = seat;
            price = amount;
            isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // method to display ticket details
    void displayTicket() {
        if (isBooked) {
            System.out.println("Price: $" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }

    // main method
    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        // before booking
        ticket.displayTicket();

        // first booking
        ticket.bookTicket("Dragon", "A10", 120.0);

        // trying to book again
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);

        // display final ticket details
        ticket.displayTicket();
    }
}