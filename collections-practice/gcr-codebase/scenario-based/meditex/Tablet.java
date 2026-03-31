import java.time.LocalDate;

public class Tablet {
    private String name;
    private String brand;
    private LocalDate expiryDate;
    private int mg;
    private double pricePertablet;

    public Tablet(){

    }

    public Tablet(String name, String brand, LocalDate expiryDate, int mg , double pricePerTablet){
        this.name= name;
        this.brand=brand;
        this.expiryDate=expiryDate;
        this.mg = mg;
        this.pricePertablet=pricePerTablet;
    }

    public String getName(){
        return name;
    }
    public String getBrand(){
        return brand;
    }
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    public int getMg(){
        return mg;
    }
    public double getPricePerTablet(){
        return pricePertablet;
    }

    public String toString(){
        return "Table name : " +name+ "Brand : " +brand+ "Expiry date : " +expiryDate+ "Mg : " +mg+ "Price per tablet : " + pricePertablet; 
      }


}
