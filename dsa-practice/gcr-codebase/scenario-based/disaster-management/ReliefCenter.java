import java.util.*;
public class ReliefCenter {
    private String centerName;
    private Map<String, Integer> stock = new HashMap<>();

    public ReliefCenter(String centerName){
        this.centerName=centerName;
    }
    public String getCenterName(){
        return centerName;
    }
    public Map<String,Integer> getStock(){
        return stock;
    }

    public void addResources(String item, int quantity){
        stock.put(item,stock.getOrDefault(item,0)+quantity);
    }

    public void allocate(AreaRequest request) throws InsufficientResourceException{
        for(Map.Entry<String,Integer> entry : request.getRequestedItem().entrySet()){
            String item = entry.getKey();
            int qty = entry.getValue();

            if(stock.getOrDefault(item,0)<qty){
                throw new InsufficientResourceException("Not enough" + item + "for areas" + request.getAreaName());
            }

        }
        for(Map.Entry<String, Integer> entry : request.getRequestedItem().entrySet()){
            String item = entry.getKey();
            int qty = entry.getValue();
            stock.put(item,stock.get(item)-qty);
        }
    }

}
