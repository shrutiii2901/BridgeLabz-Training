import java.util.Scanner;


class HotelBooking {

   
    String guestName;
    String roomType;
    int nights;

    
    HotelBooking() {
        guestName = "Guest";
        roomType = "Basic";
        nights = 1;
    }

    
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    
    void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.println("Default Booking:");
        HotelBooking b1 = new HotelBooking();
        b1.displayBooking();

        
        System.out.println("Enter guest name:");
        String name = sc.nextLine();

        System.out.println("Enter room type:");
        String room = sc.nextLine();

        System.out.println("Enter number of nights:");
        int nights = sc.nextInt();

        
        System.out.println("User Booking:");
        HotelBooking b2 = new HotelBooking(name, room, nights);
        b2.displayBooking();

        
        System.out.println("Copied Booking:");
        HotelBooking b3 = new HotelBooking(b2);
        b3.displayBooking();

        
    }
}