import java.util.*;

public class AreaRequest {
    private String areaName;
    private Map<String, Integer> requestedItem;

    public AreaRequest(String areaName, Map<String, Integer> requestedItem){
        this.areaName=areaName;
        this.requestedItem=requestedItem;
    }

    public String getAreaName(){
        return areaName;
    }

    public Map<String,Integer> getRequestedItem(){
        return requestedItem;
    }

}
