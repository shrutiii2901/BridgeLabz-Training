import java.time.LocalDate;
import java.util.Scanner;
public class GlobalShipment {

    static boolean validateCode(String code){
        if(!code.matches("SHIP-[1-9][0-9]{5}")) return false;

        String digits = code.substring(5);

        int count =0; 
        for(int i =0; i<digits.length();i++){
            if(digits.charAt(i)==digits.charAt(i-1)){
                count ++;
                if(count>3)return false;
            }else count =1;

        }
        return true;
    }

    static boolean validDate(String date){
        try{
            LocalDate d = LocalDate.parse(date);
            int year = d.getYear();
            return year>=2000 && year<=2099;
        }catch(Exception e){
            return false;
        }
    }

    static boolean validMode(String mode){
        String [] modes = {"AIR","SEA","ROAD","EXPRESS","FREIGHT"};
        for(String m : modes) if(m.equals(mode))return true;
        return false;
    }

    static boolean validWeight(String w){
        if(w.matches("([1-9]\\d{0,5}|0)(\\.\\d{1,2})"))return false;

        double val = Double.parseDouble(w);
        return val<=999999.99;
    }

    static boolean validStatus(String s){
        return s.equals("DELIVERED")||s.equals("CANCELLED")||s.equals("IN_TRANSIT");
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i =0; i<n; i++){
            String rec = sc.nextLine();
            String[] p = rec.split("\\|");

            if(p.length!=5){
                System.out.println("NON-COMPLAINT RECORD");
                continue;
            }
            if(validateCode(p[0])&& validDate(p[1])&&validMode(p[2])&&validWeight(p[3])&&validStatus(p[4])){
                System.out.println("COMPLAINT RECORD");
            }
            else{
                System.out.println("NON-COMPLAINT RECORD");
            }


        }
    }
}
