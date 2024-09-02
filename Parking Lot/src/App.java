public class App {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot=new ParkingLot(2, 2, 2);

        Vehicle vehicle=new Vehicle(VehicleType.BIKE);
        parkingLot.parkVehicle(vehicle);
        parkingLot.unparkVehicle(vehicle);
    }
}
