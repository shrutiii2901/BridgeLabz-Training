public class DataCenter {
    private String dataCenterId;
    private String location;
    private String supervisorName;
    private double coolingPowerUsage;

    public DataCenter(){}
    
    public DataCenter(String dataCenterField, String location, String supervisorName, double coolingPowerUsage){
        this.dataCenterId=dataCenterField;
        this.location=location;
        this.supervisorName=supervisorName;
        this.coolingPowerUsage=coolingPowerUsage;
    }

    public String getDataCenterId(){
        return dataCenterId;
    }
     public String getLocation(){
        return location;
    }
     public String getsupervisorName(){
        return supervisorName;
    }
    public double getcoolingPowerUsage(){
        return coolingPowerUsage;
    }

}
