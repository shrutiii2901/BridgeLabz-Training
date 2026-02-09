import java.util.*;


public class UserInterface {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the input");
        String input = sc.nextLine();

        if(!input.matches("[a-zA-Z]+")){
            System.out.println(input + "is invailid input");
        }

        input = input.toUpperCase();

        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(char c : input.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character> even = new ArrayList<>();
        List<Character> odd = new ArrayList<>();

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue()%2==0){
                even.add(e.getKey());
            }else{
                odd.add(e.getKey());
            }
        }

        StringBuilder result = new StringBuilder();

        for(char c: even) result.append(c);
        for(char c: odd) result.append(c);

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            for(int i =1; i<e.getValue(); i++){
                result.append(e.getKey());
            }
        }

        int singleCount =0;
        for(int v : map.values()){
            if(v==1)singleCount++;
        }

        if(singleCount>0){
            int mid = (result.length()-1)/2;
            result.insert(mid+1, singleCount);
        }

        System.out.println("Encrypted Output : " + result);

    }   
}
