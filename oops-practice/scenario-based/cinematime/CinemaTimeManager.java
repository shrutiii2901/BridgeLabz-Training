import java.util.ArrayList;
import java.util.List;

class CinemaTimeManager {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();

    
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }

        movieTitles.add(title);
        showTimes.add(time);
    }

    
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}"))
            return false;

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }

   
    public void searchMovie(String keyword) {
        boolean found = false;

        try {
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).contains(keyword)) {
                    System.out.println(
                        String.format("Movie: %s | Time: %s",
                                movieTitles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error while searching movies.");
        }

        if (!found) {
            System.out.println("No movie found with keyword: " + keyword);
        }
    }

   
    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                String.format("Movie: %s | Time: %s",
                        movieTitles.get(i), showTimes.get(i))
            );
        }
    }

    
    public void printMovieReport() {
        String[] titleArray = movieTitles.toArray(new String[0]);
        String[] timeArray = showTimes.toArray(new String[0]);

        System.out.println("\n--- Movie Report ---");
        for (int i = 0; i < titleArray.length; i++) {
            System.out.println(titleArray[i] + " at " + timeArray[i]);
        }
    }
}
