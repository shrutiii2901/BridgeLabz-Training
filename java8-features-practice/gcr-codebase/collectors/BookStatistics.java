import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String genre;
    private int pages;

    Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}

public class BookStatistics {
    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book("Book1", "Fiction", 300),
                new Book("Book2", "Fiction", 450),
                new Book("Book3", "Science", 500)
        );

        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println();
        });
    }
}
