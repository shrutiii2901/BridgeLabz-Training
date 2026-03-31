
import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;

import javax.swing.text.AbstractDocument;
public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of tablets: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Tablet> list = new ArrayList<>();

        System.out.println("Enter the tablet details: ");
        for(int i =0; i<n; i++){
            String input = sc.nextLine();

            String [] data = input.split(":");
            String name = data[0];
            String brand = data[1];
            LocalDate expiryDate = LocalDate.parse(data[2]);
            int mg = Integer.parseInt(data[3]);
            double pricePerTablet = Double.parseDouble(data[4]);

            list.add(new Tablet(name, brand, expiryDate, mg, pricePerTablet ));
        }

        System.out.println("Enter the brand name: ");

        String brandName = sc.nextLine();

        TabletUtil util = new TabletUtil();

        List<Tablet> brandresult = util.retrieveTabletsByBrand(list.stream(), brandName);

        brandresult.forEach(System.out::println);

        System.out.println("Enter the mg value: ");
        int mgValue = sc.nextInt();
        List<String> mgResult = util.getTabletsAboveMg(list.stream(), mgValue);
        if(mgResult.isEmpty()){
            System.out.println("No tablets found above mg value " + mgValue);
        }else{
            System.out.println("Tablets above mg value " + mgValue + "are");
            mgResult.forEach(System.out::println);
        }

    }
}
