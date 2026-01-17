import java.util.Scanner;

class MovieTicket {

    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    void bookTicket(String movie, String seat, double amount) {

        if (!isBooked) {
            movieName = movie;
            seatNumber = seat;
            price = amount;
            isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full");
        }
    }

    void displayTicket() {
        if (isBooked) {
            System.out.println("Price:" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price:" + price);
        } else {
            System.out.println("Ticket have not booked yet....");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();

        ticket.displayTicket();

        System.out.print("Enter Movie Name: ");
        String movie = sc.nextLine();

        System.out.print("Enter Seat Number: ");
        String seat = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double amount = sc.nextDouble();

        ticket.bookTicket(movie, seat, amount);

        
        ticket.bookTicket(movie, seat, amount);

        ticket.displayTicket();

        sc.close();
    }
}
