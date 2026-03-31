import java.util.*;

public class KeyGeneration {
    
    static boolean hasSpecial(String s ){
        for(char c : s.toCharArray()){
            if(!Character.isLetter(c)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while(n-- >0){
            String s = sc.nextLine();

            if(s.length()==0){
                System.out.println("Invalid Input (empty string)");
                continue;
            }
            if(s.contains(" ")){
                System.out.println("Invalid Input");
                continue;
            }
            if(s.length()<6){
                System.out.println("Invalid Input");
                continue;
            }
            if(s.matches(".*\\d.*")){
                System.out.println("Invalid Input");
                continue;
            }
            if(hasSpecial(s)){
                System.out.println("Invalid Input");
                continue;
            }

            s.toLowerCase();

            StringBuilder sb = new StringBuilder();

            for(int i =0; i<sb.length();i++){
                if(i%2==0){
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                }

            System.out.println("The generated key is - " + sb.toString());
            }
        }
    }
}
