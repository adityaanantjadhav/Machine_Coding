public class ParkingSpot {
    private ParkingSpotType pType;
    private Vehicle vehicle;
    private boolean free;

    public ParkingSpot(ParkingSpotType pType){
        this.pType=pType;
    }

    
    public ParkingSpotType getPType() {
        return pType;
    }
    public void setPType(ParkingSpotType pType) {
        this.pType = pType;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public boolean isFree() {
        return free;
    }
    public void setFree(boolean free) {
        this.free = free;
    }

    
}
