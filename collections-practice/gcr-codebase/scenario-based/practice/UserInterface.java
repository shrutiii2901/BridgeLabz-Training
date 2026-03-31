import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.*;
import java.util.stream.Collectors; 



public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter the number of earphones");
        int n = sc.nextInt();
        sc.nextLine();
        List<Earphone> list = new ArrayList<>();
        System.out.println("Enter the earphone details: ");
        for(int i =0; i<n; i++){
            String input = sc.nextLine();
            String [] data = input.split(":");

            String brand = data[0];
            LocalDate date = LocalDate.parse(data[1]);
            double price = Double.parseDouble(data[2]);
            double rating = Double.parseDouble(data[3]);

            list.add(new Earphone(brand,date,price,rating));
        }

        EarphoneUtil util = new EarphoneUtil();

        System.out.println("Enter the brand name");

        String brandName = sc.nextLine();

        List<Earphone> brandResult = util.getEarphonesByBrandName(list.stream(), brandName)
                                         .collect(Collectors.toList());

        if(brandResult.isEmpty()){
            System.out.println("No earphones found for the brand " + brandName);
        }else{
            System.out.println("Earphones of brand" + brandName + "are");
            brandResult.forEach(System.out::println);
        }


        System.out.println("Enter the minimum price and maximum price range");

        double minPrice = sc.nextDouble();
        double maxPrice = sc.nextDouble();

        List<Earphone> priceResult = util.getEarphonesWithinPriceRange(list.stream(), minPrice, maxPrice);

        if(priceResult.isEmpty()){
            System.out.println("No earphones found within the price range" +minPrice+ "to" +maxPrice);
        }else{
            System.out.println("earphones within the price range" +minPrice+ "to" +maxPrice+ "are");

            priceResult.forEach(System.out::println);
        }

        
        
        
    

    }
}
