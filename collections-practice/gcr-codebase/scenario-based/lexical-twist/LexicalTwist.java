import java.util.Scanner;   
public class LexicalTwist {
    

    public  static boolean isValid(String word1){
        if(word1 == null || word1.isEmpty()){
            return false;
        }
        if(word1.contains(" ")){
            return false;
        }
        return true;
    }

    public static boolean isReversed(String word1, String word2){
        StringBuilder rev = new StringBuilder(word1).reverse();
        return rev.toString().equals(word2);
    }

    public static String ReversedTranform(String word1){
        StringBuilder reversed = new StringBuilder(word1).reverse();

        String lowerCase = reversed.toString().toLowerCase();

        String replaced = lowerCase.replaceAll("[aeiouAEIOU]", "@");

        return replaced;
    }

    public static int countVowels(String word1){

        int count =0;
        for(char c: word1.toCharArray()){
            if("AIEOUaeiou".indexOf(c)!=-1){
                count++;
            }
        }
        return count;
    }
    public static int countConsonants(String word1){
        int count =0;
        for(char c : word1.toCharArray()){
            if(c >= 'A' && c <= 'Z' && "AEIOU".indexOf(c) == -1){
                count++;
            }
        }
        return count;   
    }
    
    public static String getFirstTwoUnique(String word1, boolean vowel){
        String result = "";
        for(char c : word1.toCharArray()){
            boolean isVowel = "AEIOUaeiou".indexOf(c)!=-1;
            if(isVowel == vowel && result.indexOf(c)==-1){
                result += c;
                if(result.length()==2){
                    break;
                }

            }

        }
        return result;
        }

        public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);;
           System.out.println("Enter the first word : ");
           String word1 = sc.nextLine();
           if(!isValid(word1)){
            System.out.println( word1 + "is Invalid word");
            return;
           }
           System.out.println("Enter the second word : ");
           String word2 = sc.nextLine();

           if(!isValid(word2)){
            System.out.println(word2 + "is Invalid word");
            return;
           }

           if(isReversed(word1, word2)){
             String transformed = ReversedTranform(word1);
             System.out.println(transformed);
             
           }else{
            String combined = (word1+word2).toUpperCase();
            int vowelCounts = countVowels(combined);
            int consonantsCount = countConsonants(combined);

            if(vowelCounts> consonantsCount){
                System.out.println(getFirstTwoUnique(word1, true));
            }else if ( consonantsCount > vowelCounts){
                System.out.println(getFirstTwoUnique(word1, false));
            }else{
                System.out.println("Vowels and Consonants are equal in count.");
            }
           }
        }

        
}
