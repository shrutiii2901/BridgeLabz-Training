public class CinemaTimeMain {
    public static void main(String[] args) {

        CinemaTimeManager manager = new CinemaTimeManager();

        try {
            manager.addMovie("Avengers", "18:30");
            manager.addMovie("Inception", "21:00");
            manager.addMovie("Interstellar", "25:99"); // Invalid time
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll Movies:");
        manager.displayAllMovies();

        System.out.println("\nSearch Result:");
        manager.searchMovie("Incep");

        manager.printMovieReport();
    }
}
