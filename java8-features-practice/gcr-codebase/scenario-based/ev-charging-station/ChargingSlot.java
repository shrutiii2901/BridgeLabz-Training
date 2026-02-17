public class ChargingSlot {
    private int slotID;
    private boolean isOccupied;

    public ChargingSlot(int slotID){
        this.slotID=slotID;
        this.isOccupied=false;
    }

    public int getSlotID(){
        return slotID;
    }

    public boolean isOccupied(){
        return true;
    }
    public void assignSlot(){
        isOccupied=true;
    }
    public void releaseSlot(){
        isOccupied=false;
    }

}
