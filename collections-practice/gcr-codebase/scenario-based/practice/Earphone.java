import java.time.LocalDate;

public class Earphone {
    private String brandname;
    private LocalDate releaseDate;
    private double price;
    private double rating;

    public Earphone(String brandName, LocalDate releaseDate, double price, double rating){
        this.brandname=brandName;
        this.releaseDate=releaseDate;
        this.price=price;
        this.rating=rating;
    }

    public String getName(){
        return brandname;
    }
    public LocalDate getReleaseDate(){
        return releaseDate;
    }
    public double getPrice(){
        return price;
    }
    public double getRating(){
        return rating;
    }

    public String toString(){
        return "Brand Name: " + brandname+ " Release Date: " + releaseDate+ "Price : "+price+ "Rating: " + rating;
    }

}
