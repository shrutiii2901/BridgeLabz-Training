import java.util.List;

class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return name + " | Rating: " + rating + " | Year: " + releaseYear;
    }
}

public class TrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = List.of(
                new Movie("Movie A", 4.5, 2024),
                new Movie("Movie B", 4.8, 2023),
                new Movie("Movie C", 4.9, 2025),
                new Movie("Movie D", 4.2, 2024),
                new Movie("Movie E", 4.7, 2025),
                new Movie("Movie F", 4.6, 2022)
        );

        movies.stream()
              .filter(m -> m.releaseYear >= 2023)
              .sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))


              .limit(5)
              .forEach(System.out::println);
    }
}
