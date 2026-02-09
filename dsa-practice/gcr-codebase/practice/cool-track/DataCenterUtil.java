import java.util.*;

public class DataCenterUtil {
    private Set<DataCenter> dataCenterSet =new LinkedHashSet<>();

    public void addDataCenter(DataCenter dataCenter){
        dataCenterSet.add(dataCenter);
    }

    public DataCenter getDataCenterById(String dataCenterId){
        for (DataCenter dataCenter : dataCenterSet) {
            if (dataCenter.getDataCenterId().equals(dataCenterId))
                return dataCenter;
        }
        return null;
    }

    public List<DataCenter> getDataCentersWithMaximumCoolingPowerUsage(){
        List<DataCenter> list = new ArrayList<>();
        double max= Double.MIN_VALUE;
        
        for(DataCenter dc : dataCenterSet ){
            if(dc.getcoolingPowerUsage()>max){
                max = dc.getcoolingPowerUsage();
            }
        }
        for(DataCenter dc : dataCenterSet){
            if(dc.getcoolingPowerUsage()==max){
                list.add(dc);
            }
        }
        return list;
    }
}


